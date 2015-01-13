
package ec.com.vipsoft.ce.backend.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for facturaBiding complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="facturaBiding">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="contribuyenteEspecial" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="descuento" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="detalles" type="{http://service.backend.ce.vipsoft.com.ec/}facturaDetalleBinding" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="direccion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="direccionMatriz" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fechaFactura" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="ice" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="iva12" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="numeroComprobante" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="razonSocial" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="razonSocialEmisor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="resolucionContribuyenteEspecial" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ruc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="rucEmisor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="secuenciaFactura" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="subtotalIva0" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="subtotalIva12" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="totalFactura" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "facturaBiding", propOrder = {
    "contribuyenteEspecial",
    "descuento",
    "detalles",
    "direccion",
    "direccionMatriz",
    "fechaFactura",
    "ice",
    "iva12",
    "numeroComprobante",
    "razonSocial",
    "razonSocialEmisor",
    "resolucionContribuyenteEspecial",
    "ruc",
    "rucEmisor",
    "secuenciaFactura",
    "subtotalIva0",
    "subtotalIva12",
    "totalFactura"
})
public class FacturaBiding {

    protected Boolean contribuyenteEspecial;
    protected BigDecimal descuento;
    @XmlElement(nillable = true)
    protected List<FacturaDetalleBinding> detalles;
    protected String direccion;
    protected String direccionMatriz;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaFactura;
    protected BigDecimal ice;
    protected BigDecimal iva12;
    protected String numeroComprobante;
    protected String razonSocial;
    protected String razonSocialEmisor;
    protected String resolucionContribuyenteEspecial;
    protected String ruc;
    protected String rucEmisor;
    protected String secuenciaFactura;
    protected BigDecimal subtotalIva0;
    protected BigDecimal subtotalIva12;
    protected BigDecimal totalFactura;

    /**
     * Gets the value of the contribuyenteEspecial property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isContribuyenteEspecial() {
        return contribuyenteEspecial;
    }

    /**
     * Sets the value of the contribuyenteEspecial property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setContribuyenteEspecial(Boolean value) {
        this.contribuyenteEspecial = value;
    }

    /**
     * Gets the value of the descuento property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDescuento() {
        return descuento;
    }

    /**
     * Sets the value of the descuento property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDescuento(BigDecimal value) {
        this.descuento = value;
    }

    /**
     * Gets the value of the detalles property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the detalles property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDetalles().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FacturaDetalleBinding }
     * 
     * 
     */
    public List<FacturaDetalleBinding> getDetalles() {
        if (detalles == null) {
            detalles = new ArrayList<FacturaDetalleBinding>();
        }
        return this.detalles;
    }

    /**
     * Gets the value of the direccion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Sets the value of the direccion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDireccion(String value) {
        this.direccion = value;
    }

    /**
     * Gets the value of the direccionMatriz property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDireccionMatriz() {
        return direccionMatriz;
    }

    /**
     * Sets the value of the direccionMatriz property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDireccionMatriz(String value) {
        this.direccionMatriz = value;
    }

    /**
     * Gets the value of the fechaFactura property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaFactura() {
        return fechaFactura;
    }

    /**
     * Sets the value of the fechaFactura property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaFactura(XMLGregorianCalendar value) {
        this.fechaFactura = value;
    }

    /**
     * Gets the value of the ice property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getIce() {
        return ice;
    }

    /**
     * Sets the value of the ice property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setIce(BigDecimal value) {
        this.ice = value;
    }

    /**
     * Gets the value of the iva12 property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getIva12() {
        return iva12;
    }

    /**
     * Sets the value of the iva12 property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setIva12(BigDecimal value) {
        this.iva12 = value;
    }

    /**
     * Gets the value of the numeroComprobante property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroComprobante() {
        return numeroComprobante;
    }

    /**
     * Sets the value of the numeroComprobante property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroComprobante(String value) {
        this.numeroComprobante = value;
    }

    /**
     * Gets the value of the razonSocial property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRazonSocial() {
        return razonSocial;
    }

    /**
     * Sets the value of the razonSocial property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRazonSocial(String value) {
        this.razonSocial = value;
    }

    /**
     * Gets the value of the razonSocialEmisor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRazonSocialEmisor() {
        return razonSocialEmisor;
    }

    /**
     * Sets the value of the razonSocialEmisor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRazonSocialEmisor(String value) {
        this.razonSocialEmisor = value;
    }

    /**
     * Gets the value of the resolucionContribuyenteEspecial property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResolucionContribuyenteEspecial() {
        return resolucionContribuyenteEspecial;
    }

    /**
     * Sets the value of the resolucionContribuyenteEspecial property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResolucionContribuyenteEspecial(String value) {
        this.resolucionContribuyenteEspecial = value;
    }

    /**
     * Gets the value of the ruc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRuc() {
        return ruc;
    }

    /**
     * Sets the value of the ruc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRuc(String value) {
        this.ruc = value;
    }

    /**
     * Gets the value of the rucEmisor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRucEmisor() {
        return rucEmisor;
    }

    /**
     * Sets the value of the rucEmisor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRucEmisor(String value) {
        this.rucEmisor = value;
    }

    /**
     * Gets the value of the secuenciaFactura property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSecuenciaFactura() {
        return secuenciaFactura;
    }

    /**
     * Sets the value of the secuenciaFactura property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSecuenciaFactura(String value) {
        this.secuenciaFactura = value;
    }

    /**
     * Gets the value of the subtotalIva0 property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSubtotalIva0() {
        return subtotalIva0;
    }

    /**
     * Sets the value of the subtotalIva0 property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSubtotalIva0(BigDecimal value) {
        this.subtotalIva0 = value;
    }

    /**
     * Gets the value of the subtotalIva12 property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSubtotalIva12() {
        return subtotalIva12;
    }

    /**
     * Sets the value of the subtotalIva12 property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSubtotalIva12(BigDecimal value) {
        this.subtotalIva12 = value;
    }

    /**
     * Gets the value of the totalFactura property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotalFactura() {
        return totalFactura;
    }

    /**
     * Sets the value of the totalFactura property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotalFactura(BigDecimal value) {
        this.totalFactura = value;
    }

}
