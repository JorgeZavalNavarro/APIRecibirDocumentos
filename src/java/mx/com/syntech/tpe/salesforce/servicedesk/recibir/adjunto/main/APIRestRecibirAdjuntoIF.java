package mx.com.syntech.tpe.salesforce.servicedesk.recibir.adjunto.main;

import java.lang.reflect.Field;
import java.nio.charset.Charset;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import mx.com.syntech.tpe.salesforce.servicedesk.recibir.adjunto.bean.cache.DepurarArchivosCacheBean;
import mx.com.syntech.tpe.salesforce.servicedesk.recibir.adjunto.bean.core.CoreBean;
import mx.com.syntech.tpe.salesforce.servicedesk.recibir.adjunto.bean.core.CoreException;
import mx.com.syntech.tpe.salesforce.servicedesk.recibir.adjunto.bean.main.CodeKeys;
import mx.com.syntech.tpe.salesforce.servicedesk.recibir.adjunto.bean.main.RecibirAdjuntoBean;
import mx.com.syntech.tpe.salesforce.servicedesk.recibir.adjunto.bean.main.RecibirAdjuntoInputVO;
import mx.com.syntech.tpe.salesforce.servicedesk.recibir.adjunto.bean.main.RecibirAdjuntoOutputVO;
import org.apache.log4j.Category;

/**
 * REST Web Service
 *
 * @author dell
 */
@Path("salesforce/recibir/adjunto")
public class APIRestRecibirAdjuntoIF {

    // Constantes de la clase
    private static Category log = Category.getInstance(APIRestRecibirAdjuntoIF.class);

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of APIRestRecibirAdjuntoIF
     */
    public APIRestRecibirAdjuntoIF() {
    }

    /**
     * Retrieves representation of an instance of
     * mx.com.syntech.tpe.salesforce.servicedesk.recibir.adjunto.APIRestRecibirAdjuntoIF
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getJson() {
        String retorno = null;
        //TODO return proper representation object
        log.error("Solicitud de servicio incorrecto");
        retorno = "<error>" + "\n"
                + "   <titulo>Solicitud de servicio incorrecto</titulo>" + "\n"
                + "   <descripcion>Esta API se debe de consumir solamente por su método POST</descripcion>" + "\n"
                + "</error>";
        return retorno;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public RecibirAdjuntoOutputVO recibirAdjunto(RecibirAdjuntoInputVO inputVO) {
        RecibirAdjuntoOutputVO retorno = null;
        String fechaInicio = CoreBean.fechaActual();

        log.info("Establecemos el Encode UTF-8...");
        /**
         * ASIGNANDO EL CHARSET *
         */
        log.info("Asignando Charset UTF-8");
        String charSet = "UTF-8";
        log.info("Configurando charset: " + charSet);

        try {
            asignarCharSet(charSet);
        } catch (Exception ex) {
            log.error("No se pudo asignar el charset " + charSet);
            log.error(ex);
            log.error("El programa puede presentar caracteres extraños en la información en lugar de letras con acentos, tildes, etc.");
        }

        log.warn("Recibiendo archivo adjunto en APIRest");

        try {
            // Inicializar nuestro valor de retorno
            retorno = new RecibirAdjuntoOutputVO();

            log.info("  ::: Adjuntanto el archivo con la siguiente información:");
            log.info("  ::: Tamaño del adjunto (Base64)...: " + inputVO.getArchivoBase64().length());
            log.info("  ::: Comentario....................: " + inputVO.getComentario());
            log.info("  ::: Nombre del archivo............: " + inputVO.getNombreArchivo());
            log.info("  ::: Ticket de Salesforce..........: " + inputVO.getTicketSalesForce());
            log.info("  ::: Ticket de ServioceDesk........: " + inputVO.getTicketServiceDesk());
            log.info("  ::: Tipo de Archivo...............: " + inputVO.getTipoArchivo());
            log.info("  ::: Usuario.......................: " + inputVO.getUsuario());
            log.info("  ::: Tipo de archivo y comentario no son obligatorios. (20210526)");

            log.info("  ::: Adjuntando archivo");
            RecibirAdjuntoBean bean = new RecibirAdjuntoBean();
            retorno = bean.adjuntar(inputVO);

            // Completamos el valor de retorno como satisfactoriuo
            retorno.setCodigoRespuesta(CodeKeys.CODE_000_OK);
            retorno.setDescripcionRespuesta("El archivo " + inputVO.getNombreArchivo() + " se adjuntó correctamente en el ticket Numero: " + inputVO.getTicketServiceDesk());
            retorno.setMensajeServicio("Se adjuntó correctamente el documento: " + inputVO.getNombreArchivo() + " en el ticket: " + inputVO.getTicketServiceDesk());
            retorno.setRespuestaBoolean("true");
            retorno.setFechaSolicitud(fechaInicio);
            retorno.setFechaRespuesta(CoreBean.fechaActual());

        } catch (CoreException ex) {
            ex.printStackTrace();
            log.error("Algo no salio bien al intentar adjuntar el archivo correspondiente");
            retorno = new RecibirAdjuntoOutputVO();
            retorno.setRespuestaBoolean("false");
            retorno.setCodigoRespuesta(ex.getIdError());
            retorno.setDescripcionRespuesta(ex.getMensaje());
            retorno.setMensajeServicio(ex.getMensaje());
            retorno.setFechaSolicitud(fechaInicio);
            retorno.setFechaRespuesta(CoreBean.fechaActual());
            retorno.setFolioDocumento("");

        } catch (Exception ex) {
            ex.printStackTrace();
            log.error("Exception: Algo no salio bien al intentar adjuntar el archivo correspondiente");
            retorno = new RecibirAdjuntoOutputVO();
            retorno.setRespuestaBoolean("false");
            retorno.setCodigoRespuesta(CodeKeys.CODE_980_ERROR);
            retorno.setDescripcionRespuesta(ex.getMessage());
            retorno.setMensajeServicio(ex.getMessage());
            retorno.setFechaSolicitud(fechaInicio);
            retorno.setFechaRespuesta(CoreBean.fechaActual());
            retorno.setFolioDocumento("");

        } catch (Throwable ex) {
            ex.printStackTrace();
            log.error("Throwable: Algo no salio bien al intentar adjuntar el archivo correspondiente: " + retorno);
            retorno = new RecibirAdjuntoOutputVO();
            retorno.setRespuestaBoolean("false");
            retorno.setCodigoRespuesta(CodeKeys.CODE_980_ERROR);
            retorno.setDescripcionRespuesta(ex.getMessage());
            retorno.setMensajeServicio(ex.getMessage());
            retorno.setFechaSolicitud(fechaInicio);
            retorno.setFechaRespuesta(CoreBean.fechaActual());
            retorno.setFolioDocumento("");
        } finally {
            // Intentamos eliminar archivos cache
            log.info("Depurando archivos temporales");
            DepurarArchivosCacheBean depurarBean = new DepurarArchivosCacheBean();
            depurarBean.depurarCache();
            log.info("Fin de proceso !!");
        }
        return retorno;
    }

    /**
     * PUT method for updating or creating an instance of
     * APIRestRecibirAdjuntoIF
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }

    public static void asignarCharSet(String charset) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        log.info("   ::: Charset actual: " + Charset.defaultCharset().name());
        log.info("   ::: File encoding actual: " + System.getProperty("file.encoding"));
        log.info("   ::: Asignando el charset: " + charset);
        System.setProperty("file.encoding", charset);

        log.info("   ::: File encoding actual: " + System.getProperty("file.encoding"));

        Field fieldCharset = Charset.class.getDeclaredField("defaultCharset");
        fieldCharset.setAccessible(true);
        fieldCharset.set(null, null);
        log.info("   ::: Charset actual: " + Charset.defaultCharset().name());

    }

}
