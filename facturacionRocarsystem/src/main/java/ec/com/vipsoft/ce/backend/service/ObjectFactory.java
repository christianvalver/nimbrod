
package ec.com.vipsoft.ce.backend.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ec.com.vipsoft.ce.backend.service package. 
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

    private final static QName _GenerarFacturaEnXmlResponse_QNAME = new QName("http://service.backend.ce.vipsoft.com.ec/", "generarFacturaEnXmlResponse");
    private final static QName _GenerarFacturaEnXml_QNAME = new QName("http://service.backend.ce.vipsoft.com.ec/", "generarFacturaEnXml");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ec.com.vipsoft.ce.backend.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GenerarFacturaEnXmlResponse }
     * 
     */
    public GenerarFacturaEnXmlResponse createGenerarFacturaEnXmlResponse() {
        return new GenerarFacturaEnXmlResponse();
    }

    /**
     * Create an instance of {@link GenerarFacturaEnXml }
     * 
     */
    public GenerarFacturaEnXml createGenerarFacturaEnXml() {
        return new GenerarFacturaEnXml();
    }

    /**
     * Create an instance of {@link FacturaDetalleBinding }
     * 
     */
    public FacturaDetalleBinding createFacturaDetalleBinding() {
        return new FacturaDetalleBinding();
    }

    /**
     * Create an instance of {@link FacturaBiding }
     * 
     */
    public FacturaBiding createFacturaBiding() {
        return new FacturaBiding();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GenerarFacturaEnXmlResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.backend.ce.vipsoft.com.ec/", name = "generarFacturaEnXmlResponse")
    public JAXBElement<GenerarFacturaEnXmlResponse> createGenerarFacturaEnXmlResponse(GenerarFacturaEnXmlResponse value) {
        return new JAXBElement<GenerarFacturaEnXmlResponse>(_GenerarFacturaEnXmlResponse_QNAME, GenerarFacturaEnXmlResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GenerarFacturaEnXml }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.backend.ce.vipsoft.com.ec/", name = "generarFacturaEnXml")
    public JAXBElement<GenerarFacturaEnXml> createGenerarFacturaEnXml(GenerarFacturaEnXml value) {
        return new JAXBElement<GenerarFacturaEnXml>(_GenerarFacturaEnXml_QNAME, GenerarFacturaEnXml.class, null, value);
    }

}
