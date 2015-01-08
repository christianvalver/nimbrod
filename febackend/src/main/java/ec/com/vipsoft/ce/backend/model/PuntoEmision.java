package ec.com.vipsoft.ce.backend.model;

import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Version;
import java.lang.Override;

@Entity
public class PuntoEmision implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4293091103146428944L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	@Version
	@Column(name = "version")
	private int version;

	private Integer secuenciaFactura;
	private Integer secuenciaNotaCredito;
	private Integer secuenciaNotaDebito;
	private Integer secuenciaGuiaRemision;
	private Integer secuenciaComprobanteRetencion;

	public Integer getSecuenciaNotaCredito() {
		return secuenciaNotaCredito;
	}

	public void setSecuenciaNotaCredito(Integer secuenciaNotaCredito) {
		this.secuenciaNotaCredito = secuenciaNotaCredito;
	}

	public Integer getSecuenciaNotaDebito() {
		return secuenciaNotaDebito;
	}

	public void setSecuenciaNotaDebito(Integer secuenciaNotaDebito) {
		this.secuenciaNotaDebito = secuenciaNotaDebito;
	}

	public Integer getSecuenciaGuiaRemision() {
		return secuenciaGuiaRemision;
	}

	public void setSecuenciaGuiaRemision(Integer secuenciaGuiaRemision) {
		this.secuenciaGuiaRemision = secuenciaGuiaRemision;
	}

	public Integer getSecuenciaComprobanteRetencion() {
		return secuenciaComprobanteRetencion;
	}

	public void setSecuenciaComprobanteRetencion(
			Integer secuenciaComprobanteRetencion) {
		this.secuenciaComprobanteRetencion = secuenciaComprobanteRetencion;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(final int version) {
		this.version = version;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof PuntoEmision)) {
			return false;
		}
		PuntoEmision other = (PuntoEmision) obj;
		if (id != null) {
			if (!id.equals(other.id)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	public Integer getSecuenciaFactura() {
		return secuenciaFactura;
	}

	public void setSecuenciaFactura(Integer secuenciaFactura) {
		this.secuenciaFactura = secuenciaFactura;
	}

	@Override
	public String toString() {
		String result = getClass().getSimpleName() + " ";
		if (id != null)
			result += "id: " + id;
		result += ", version: " + version;
		if (secuenciaFactura != null)
			result += ", secuenciaFactura: " + secuenciaFactura;
		return result;
	}

	public int siguienteSecuenciaFactura() {
		return secuenciaFactura++;
	}
	public int siguienteSecuenciaNotaDebito(){
		return secuenciaNotaDebito++;
	}
	public int siguienteSecuenciaNotaCredito(){
		return secuenciaNotaCredito++;
	}
	public int siguienteSecuenciaGuiaRemision(){
		return secuenciaGuiaRemision++;
	}
	public int siguienteSecuenciaRetencion(){
		return secuenciaComprobanteRetencion++;
	}
}