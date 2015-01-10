package ec.com.vipsoft.erp.gui.bindingbeans;

import java.io.Serializable;

public class BienEconomicoBiding implements Serializable,Comparable<BienEconomicoBiding>{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2031003360425277583L;
	private String codigo;
	private String descripcion;
	private String codigoIVA;
	private String codigoICE;
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getCodigoIVA() {
		return codigoIVA;
	}

	public void setCodigoIVA(String codigoIVA) {
		this.codigoIVA = codigoIVA;
	}

	public String getCodigoICE() {
		return codigoICE;
	}

	public void setCodigoICE(String codigoICE) {
		this.codigoICE = codigoICE;
	}

	@Override
	public int compareTo(BienEconomicoBiding o) {
		int retorno=descripcion.compareTo(o.descripcion);
		if(retorno==0){
			retorno=codigo.compareTo(o.codigo);
		}
		return retorno;
	}
}
