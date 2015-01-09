
package ec.com.vipsoft.ce.clientapi;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ec.com.vipsoft.ce.clientapi package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CrearEntidad_QNAME = new QName("http://service.backend.ce.vipsoft.com.ec/", "crearEntidad");
    private final static QName _CrearEntidadResponse_QNAME = new QName("http://service.backend.ce.vipsoft.com.ec/", "crearEntidadResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ec.com.vipsoft.ce.clientapi
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CrearEntidad }
     * 
     */
    public CrearEntidad createCrearEntidad() {
        return new CrearEntidad();
    }

    /**
     * Create an instance of {@link CrearEntidadResponse }
     * 
     */
    public CrearEntidadResponse createCrearEntidadResponse() {
        return new CrearEntidadResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CrearEntidad }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.backend.ce.vipsoft.com.ec/", name = "crearEntidad")
    public JAXBElement<CrearEntidad> createCrearEntidad(CrearEntidad value) {
        return new JAXBElement<CrearEntidad>(_CrearEntidad_QNAME, CrearEntidad.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CrearEntidadResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.backend.ce.vipsoft.com.ec/", name = "crearEntidadResponse")
    public JAXBElement<CrearEntidadResponse> createCrearEntidadResponse(CrearEntidadResponse value) {
        return new JAXBElement<CrearEntidadResponse>(_CrearEntidadResponse_QNAME, CrearEntidadResponse.class, null, value);
    }

}
