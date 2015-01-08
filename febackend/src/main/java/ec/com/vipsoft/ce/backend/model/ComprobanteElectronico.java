package ec.com.vipsoft.ce.backend.model;

import javax.persistence.Entity;

import java.io.Serializable;

import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import java.lang.Override;
import java.util.Date;

@Entity
@Table(name = "comprobanteelectronico")
public class ComprobanteElectronico implements Serializable {

	private static final long serialVersionUID = 5162007224426119942L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	@Version
	@Column(name = "version")
	private int version;

	@Column(length = 49, name = "can")
	private String claveAcceso;

	@Column(length = 49, name = "cac")
	private String claveAccesoContingencia;
	@Column(length = 13, name = "rucidcliente")
	private String identificacionBeneficiario;
	private byte[] xmlOriginal;
	private byte[] xmlconclaveAcceso;
	private byte[] xmlfirmado;
	private String razonRechazo;
	private boolean enviado;
	private boolean recibido;
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaFirmado;
	@Column(length = 37, name = "an")
	private String autorizacionNormal;
	private byte[] xmlautorizado;
	@ManyToOne
	private Entidad entidad;
	
	@OneToOne
	private Contingencia contingencia;

	public Long getId() {
		return this.id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public int getVersion() {
		return this.version;
	}

	public String getIdentificacionBeneficiario() {
		return identificacionBeneficiario;
	}

	public void setIdentificacionBeneficiario(String identificacionBeneficiario) {
		this.identificacionBeneficiario = identificacionBeneficiario;
	}

	public void setVersion(final int version) {
		this.version = version;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof ComprobanteElectronico)) {
			return false;
		}
		ComprobanteElectronico other = (ComprobanteElectronico) obj;
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

	public String getClaveAcceso() {
		return claveAcceso;
	}

	public void setClaveAcceso(String claveAcceso) {
		this.claveAcceso = claveAcceso;
	}

	public String getClaveAccesoContingencia() {
		return claveAccesoContingencia;
	}

	public void setClaveAccesoContingencia(String claveAccesoContingencia) {
		this.claveAccesoContingencia = claveAccesoContingencia;
	}

	@Override
	public String toString() {
		String result = getClass().getSimpleName() + " ";
		if (id != null)
			result += "id: " + id;
		result += ", version: " + version;
		if (claveAcceso != null && !claveAcceso.trim().isEmpty())
			result += ", claveAcceso: " + claveAcceso;
		if (claveAccesoContingencia != null
				&& !claveAccesoContingencia.trim().isEmpty())
			result += ", claveAccesoContingencia: " + claveAccesoContingencia;
		return result;
	}

	public byte[] getXmlOriginal() {
		return xmlOriginal;
	}

	public void setXmlOriginal(byte[] xmlOriginal) {
		this.xmlOriginal = xmlOriginal;
	}

	public byte[] getXmlconclaveAcceso() {
		return xmlconclaveAcceso;
	}

	public void setXmlconclaveAcceso(byte[] xmlconclaveAcceso) {
		this.xmlconclaveAcceso = xmlconclaveAcceso;
	}

	public byte[] getXmlfirmado() {
		return xmlfirmado;
	}

	public void setXmlfirmado(byte[] xmlfirmado) {
		this.xmlfirmado = xmlfirmado;
	}

	public String getRazonRechazo() {
		return razonRechazo;
	}

	public void setRazonRechazo(String razonRechazo) {
		this.razonRechazo = razonRechazo;
	}

	public boolean isEnviado() {
		return enviado;
	}

	public void setEnviado(boolean enviado) {
		this.enviado = enviado;
	}

	public boolean isRecibido() {
		return recibido;
	}

	public void setRecibido(boolean recibido) {
		this.recibido = recibido;
	}

	public Date getFechaFirmado() {
		return fechaFirmado;
	}

	public void setFechaFirmado(Date fechaFirmado) {
		this.fechaFirmado = fechaFirmado;
	}

	public String getAutorizacionNormal() {
		return autorizacionNormal;
	}

	public void setAutorizacionNormal(String autorizacionNormal) {
		this.autorizacionNormal = autorizacionNormal;
	}

	public byte[] getXmlautorizado() {
		return xmlautorizado;
	}

	public void setXmlautorizado(byte[] xmlautorizado) {
		this.xmlautorizado = xmlautorizado;
	}

	public Contingencia getContingencia() {
		return contingencia;
	}

	public void setContingencia(Contingencia contingencia) {
		this.contingencia = contingencia;
	}

	public Entidad getEntidad() {
		return entidad;
	}

	public void setEntidad(Entidad entidad) {
		this.entidad = entidad;
	}

}