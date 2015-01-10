package ec.com.vipsoft.erp.gui.bindingbeans;

import java.io.Serializable;
import java.math.BigDecimal;

public class FacturaDetalleBinding implements Serializable{

	private static final long serialVersionUID = -4148940559183031447L;
	protected String codigo;
	protected String codigoIva;
	protected String codigoIce;
	protected BigDecimal cantidad;
	protected BigDecimal valorUnitario;
	protected BigDecimal descuento;
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
	
}
