
package mx.com.syntech.tpe.salesforce.servicedesk.recibir.adjunto.wssd.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 *         &lt;element name="sid" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="contextObject" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="lrelName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="addObjectHandles" type="{http://www.ca.com/UnicenterServicePlus/ServiceDesk}ArrayOfString"/>
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
    "sid",
    "contextObject",
    "lrelName",
    "addObjectHandles"
})
@XmlRootElement(name = "createLrelRelationships")
public class CreateLrelRelationships {

    protected int sid;
    @XmlElement(required = true)
    protected String contextObject;
    @XmlElement(required = true)
    protected String lrelName;
    @XmlElement(required = true)
    protected ArrayOfString addObjectHandles;

    /**
     * Obtiene el valor de la propiedad sid.
     * 
     */
    public int getSid() {
        return sid;
    }

    /**
     * Define el valor de la propiedad sid.
     * 
     */
    public void setSid(int value) {
        this.sid = value;
    }

    /**
     * Obtiene el valor de la propiedad contextObject.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContextObject() {
        return contextObject;
    }

    /**
     * Define el valor de la propiedad contextObject.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContextObject(String value) {
        this.contextObject = value;
    }

    /**
     * Obtiene el valor de la propiedad lrelName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLrelName() {
        return lrelName;
    }

    /**
     * Define el valor de la propiedad lrelName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLrelName(String value) {
        this.lrelName = value;
    }

    /**
     * Obtiene el valor de la propiedad addObjectHandles.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getAddObjectHandles() {
        return addObjectHandles;
    }

    /**
     * Define el valor de la propiedad addObjectHandles.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setAddObjectHandles(ArrayOfString value) {
        this.addObjectHandles = value;
    }

}
