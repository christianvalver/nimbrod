
package ec.com.vipsoft.ce.backend.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "GeneradorFacturaXML", targetNamespace = "http://service.backend.ce.vipsoft.com.ec/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface GeneradorFacturaXML {


    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "generarFacturaEnXml", targetNamespace = "http://service.backend.ce.vipsoft.com.ec/", className = "ec.com.vipsoft.ce.backend.service.GenerarFacturaEnXml")
    @ResponseWrapper(localName = "generarFacturaEnXmlResponse", targetNamespace = "http://service.backend.ce.vipsoft.com.ec/", className = "ec.com.vipsoft.ce.backend.service.GenerarFacturaEnXmlResponse")
    public String generarFacturaEnXml(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        FacturaBiding arg1);

}
