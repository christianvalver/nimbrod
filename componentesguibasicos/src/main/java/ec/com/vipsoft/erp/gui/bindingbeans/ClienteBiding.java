package ec.com.vipsoft.erp.gui.bindingbeans;

import java.io.Serializable;

public class ClienteBiding implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8783235624019692330L;
	protected String ruc;
	protected String razonSocial;
	protected String direccion;
	protected String telefono;
	protected String email;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRuc() {
		return ruc;
	}
	public void setRuc(String ruc) {
		this.ruc = ruc;
	}
	public String getRazonSocial() {
		return razonSocial;
	}
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	

}
