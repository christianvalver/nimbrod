package ec.com.vipsoft.erp.gui.bindingbeans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class FacturaDetalleBinding implements Serializable{

	private static final long serialVersionUID = -4148940559183031447L;
	
	protected String codigo;
	protected String codigoIva;
	protected String codigoIce;
	protected BigDecimal cantidad;
	protected BigDecimal valorUnitario;
	protected BigDecimal descuento;
	protected String descripcion;
	protected BigDecimal valorTotal;
	protected BigDecimal iva;
	protected BigDecimal ice;
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getCodigoIva() {
		if(codigoIva==null){
			codigoIva=new String("2");
		}
		return codigoIva;
	}
	public void setCodigoIva(String codigoIva) {
		this.codigoIva = codigoIva;
	}
	public String getCodigoIce() {		
		return codigoIce;
	}
	public void setCodigoIce(String codigoIce) {
		this.codigoIce = codigoIce;
	}
	public BigDecimal getCantidad() {
		return cantidad;
	}
	public void setCantidad(BigDecimal cantidad) {
		this.cantidad = cantidad;
	}
	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}
	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	public BigDecimal getDescuento() {
		return descuento;
	}
	public void setDescuento(BigDecimal descuento) {
		this.descuento = descuento;
	}
	public BigDecimal getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}
	public BigDecimal getIva() {
		return iva;
	}
	public void setIva(BigDecimal iva) {
		this.iva = iva;
	}
	public BigDecimal getIce() {
		return ice;
	}
	public void setIce(BigDecimal ice) {
		this.ice = ice;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public void calcularValorTotal() {		
		if((cantidad!=null)&&(valorUnitario!=null)){
			valorTotal=cantidad.multiply(valorUnitario);
			if(descuento!=null){
				valorTotal=valorTotal.subtract(descuento);
			}
		}
		
	}
	public BigDecimal calculaBaeImponible() {
		BigDecimal baseImponible=BigDecimal.ZERO;
		if(codigoIva.equalsIgnoreCase("2")){
			baseImponible=cantidad.multiply(valorUnitario);
		}
		return baseImponible.setScale(2, RoundingMode.HALF_DOWN);
	}	
	
}
