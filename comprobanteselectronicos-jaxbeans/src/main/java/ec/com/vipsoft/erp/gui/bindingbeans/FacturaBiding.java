package ec.com.vipsoft.erp.gui.bindingbeans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class FacturaBiding implements Serializable{

	private static final long serialVersionUID = -8237183958880944232L;
	private String rucEmisor;
	private String direccionMatriz;
	private String razonSocialEmisor;
	private Boolean contribuyenteEspecial;
	private String resolucionContribuyenteEspecial;
	protected String numeroComprobante;	
	protected List<FacturaDetalleBinding>detalles;
	protected BigDecimal subtotalIva0;
	protected BigDecimal subtotalIva12;
	protected BigDecimal iva12;
	protected BigDecimal ice;
	protected BigDecimal descuento;
	protected BigDecimal totalFactura;
	protected Date fechaFactura;
	protected String direccion;
	protected String razonSocial;	
	protected String ruc;
	protected String secuenciaFactura;
	
	
	
//	public Factura obtenerFactura(Entidad e){
//		ObjectFactory factoria=new ObjectFactory();
//		Factura facturaRetorno=factoria.createFactura();
//		facturaRetorno.setId("comprobante");
//		facturaRetorno.setVersion("1.1.0");
//		
//		InfoTributaria infoTributaria = factoria.createInfoTributaria();
//		if(esPruebas){
//			infoTributaria.setAmbiente("1");
//		}else{
//			infoTributaria.setAmbiente("2");
//		}
//		infoTributaria.setClaveAcceso(codigoAcceso);
//		infoTributaria.setCodDoc("01");
//		
//		infoTributaria.setDirMatriz(administradorEntidad.buscarDireccionMatriz(ruc));
//		infoTributaria.setNombreComercial(administradorEntidad.buscarNombreComerical(ruc));
//		infoTributaria.setRazonSocial(administradorEntidad.buscarRazonSocial(ruc));
//		infoTributaria.setRuc(ruc);
//		infoTributaria.setTipoEmision("1");
//		infoTributaria.setEstab(_factura.calcularEstablecimiento());
//		infoTributaria.setPtoEmi(_factura.calcularPuntoEmision());
//		infoTributaria.setSecuencial(_factura.calcularSecuencial());			
//		facturaRetorno.setInfoTributaria(infoTributaria);
//				
//	}
	public String getRucEmisor() {
		return rucEmisor;
	}
	public void setRucEmisor(String rucEmisor) {
		this.rucEmisor = rucEmisor;
	}
	public String getDireccionMatriz() {
		return direccionMatriz;
	}
	public void setDireccionMatriz(String direccionMatriz) {
		this.direccionMatriz = direccionMatriz;
	}
	public String getRazonSocialEmisor() {
		return razonSocialEmisor;
	}
	public void setRazonSocialEmisor(String razonSocialEmisor) {
		this.razonSocialEmisor = razonSocialEmisor;
	}
	public Boolean getContribuyenteEspecial() {
		return contribuyenteEspecial;
	}
	public void setContribuyenteEspecial(Boolean contribuyenteEspecial) {
		this.contribuyenteEspecial = contribuyenteEspecial;
	}
	public String getResolucionContribuyenteEspecial() {
		return resolucionContribuyenteEspecial;
	}
	public void setResolucionContribuyenteEspecial(
			String resolucionContribuyenteEspecial) {
		this.resolucionContribuyenteEspecial = resolucionContribuyenteEspecial;
	}
	public Date getFechaFactura() {
		return fechaFactura;
	}
	public void setFechaFactura(Date fechaFactura) {
		this.fechaFactura = fechaFactura;
	}
	public BigDecimal getSubtotalIva0() {
		return subtotalIva0.setScale(2,RoundingMode.HALF_UP);
	}
	public void setSubtotalIva0(BigDecimal subtotalIva0) {
		this.subtotalIva0 = subtotalIva0;
	}
	public BigDecimal getSubtotalIva12() {
		return subtotalIva12.setScale(2,RoundingMode.HALF_UP);
	}
	public void setSubtotalIva12(BigDecimal subtotalIva12) {
		this.subtotalIva12 = subtotalIva12;
	}
	public BigDecimal getIva12() {
		return iva12.setScale(2,RoundingMode.HALF_UP);
	}
	public void setIva12(BigDecimal iva12) {
		this.iva12 = iva12;
	}
	public BigDecimal getIce() {
		return ice.setScale(2,RoundingMode.HALF_UP);
	}
	public void setIce(BigDecimal ice) {
		this.ice = ice;
	}
	public BigDecimal getDescuento() {
		return descuento.setScale(2,RoundingMode.HALF_UP);
	}
	public void setDescuento(BigDecimal descuento) {
		this.descuento = descuento;
	}
	public BigDecimal getTotalFactura() {
		
		return totalFactura.setScale(2,RoundingMode.HALF_UP);
	}
	public void setTotalFactura(BigDecimal totalFactura) {
		this.totalFactura = totalFactura;
	}
	public List<FacturaDetalleBinding> getDetalles() {
		return detalles;
	}
	public void setDetalles(List<FacturaDetalleBinding> detalles) {
		this.detalles = detalles;
	}

	public FacturaBiding() {
		super();
		detalles=new ArrayList<FacturaDetalleBinding>();
		subtotalIva0=BigDecimal.ZERO;
		descuento=BigDecimal.ZERO;
		ice=BigDecimal.ZERO;
		iva12=BigDecimal.ZERO;
		subtotalIva12=BigDecimal.ZERO;
		totalFactura=BigDecimal.ZERO;	
		fechaFactura=new Date();
		
	}
	public String getNumeroComprobante() {
		if(numeroComprobante==null){
			numeroComprobante=new String("001-001-000000134");
		}
		return numeroComprobante;
	}
	public void setNumeroComprobante(String numeroComprobante) {
		this.numeroComprobante = numeroComprobante;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getRazonSocial() {
		return razonSocial;
	}
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	public String getRuc() {
		return ruc;
	}
	public void setRuc(String ruc) {
		this.ruc = ruc;
	}
	public String getSecuenciaFactura() {
		return secuenciaFactura;
	}
	public void setSecuenciaFactura(String secuenciaFactura) {
		this.secuenciaFactura = secuenciaFactura;
	}	

	public void anadirFacturaDetalle(FacturaDetalleBinding nuevoDetalle) {
		BigDecimal aporteIva = BigDecimal.ZERO;
		BigDecimal aporteSubtotal12 = BigDecimal.ZERO;	
		BigDecimal aportIce=BigDecimal.ZERO;
		BigDecimal aporteSubtotal0=BigDecimal.ZERO;
		
		if(nuevoDetalle.getCodigoIva().equals("2")){
			aporteIva=nuevoDetalle.getValorTotal().multiply(new BigDecimal("0.12"));
			aporteSubtotal12=nuevoDetalle.getValorTotal();				
		}else{
			aporteSubtotal0=nuevoDetalle.getValorTotal();
		}
		if(nuevoDetalle.getCodigoIce()!=null){
			
		}
		setIce(getIce().add(aportIce));
		setIva12(getIva12().add(aporteIva));
		setSubtotalIva0(getSubtotalIva0().add(aporteSubtotal0));
		setSubtotalIva12(getSubtotalIva12().add(aporteSubtotal12));
		BigDecimal elTotal=getSubtotalIva0().add(subtotalIva12);
		elTotal=elTotal.add(iva12).add(ice);
		setTotalFactura(elTotal);
		detalles.add(nuevoDetalle);			
	}
	public String getCodigoTipoIdentificacion() {
		if(ruc.length()==13){
			return "04";
		}
		if(ruc.length()==10){
			return "05";
		}
		if((ruc.length()==13)&&(ruc.equalsIgnoreCase("9999999999999"))){
			return "07";
		}		
		return "06";
	}
}
