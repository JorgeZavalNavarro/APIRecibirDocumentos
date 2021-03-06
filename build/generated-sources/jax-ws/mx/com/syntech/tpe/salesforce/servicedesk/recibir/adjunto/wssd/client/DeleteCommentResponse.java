
package mx.com.syntech.tpe.salesforce.servicedesk.recibir.adjunto.wssd.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="deleteCommentReturn" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "deleteCommentReturn"
})
@XmlRootElement(name = "deleteCommentResponse")
public class DeleteCommentResponse {

    protected int deleteCommentReturn;

    /**
     * Obtiene el valor de la propiedad deleteCommentReturn.
     * 
     */
    public int getDeleteCommentReturn() {
        return deleteCommentReturn;
    }

    /**
     * Define el valor de la propiedad deleteCommentReturn.
     * 
     */
    public void setDeleteCommentReturn(int value) {
        this.deleteCommentReturn = value;
    }

}
