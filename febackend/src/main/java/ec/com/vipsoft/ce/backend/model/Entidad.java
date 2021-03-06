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
public class Entidad implements Serializable {

	private static final long serialVersionUID = -7941741947427454818L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	@Version
	@Column(name = "version")
	private int version;

	
	@Column
	private String razonSocial;

	@Column
	private String direccion;
	
	@Column(name="pruebasf")
	private boolean facturaEnPruebas;
	@Column(name="pruebasnc")
	private boolean notaCreditoEnPruebas;
	@Column(name="pruebasnd")
	private boolean notaDebitioEnPruebas;
	@Column(name="pruebasgr")
	private boolean guiaRemisionEnPruebas;
	@Column(name="pruebascr")
	private boolean comprobanteRetencionEnPruebas;
	@Column(name="obcontabilidad")
	private boolean obligadoContabilidad;
	
	private boolean contribuyenteEspecial;
	@Column(name="resolucion")
	private String resolucionContibuyenteEspecial;
	private String ruc;
	private String nombreComercial;
	@Column(name="secf")
	private Integer secuenciacafactura;
	@Column(name="secnd")
	private Integer secuenciacanotadebito;
	@Column(name="senc")
	private Integer secuenciacanotacredito;
	@Column(name="segr")
	private Integer secuenciacaguiaremision;
	@Column(name="seret")
	private Integer secuenciacaretencion;
	public Integer siguienteCAFactura(){
		return secuenciacafactura++;	
	}
	public Integer siguienteCANotaDebito(){
		return secuenciacanotadebito++;		
	}
	public Integer siguienteCANotaCredito(){
		return secuenciacanotacredito++;		
	}
	public Integer siguienteCAGuiaRemision(){
		return secuenciacaguiaremision++;		
	}
	public Integer siguienteCARetencion(){
		return secuenciacaretencion++;		
	}

	public Integer getSecuenciacafactura() {
		return secuenciacafactura;
	}

	public void setSecuenciacafactura(Integer secuenciacafactura) {
		this.secuenciacafactura = secuenciacafactura;
	}

	public String getRuc() {
		return ruc;
	}
	public void setRuc(String ruc) {
		this.ruc = ruc;
	}
	public String getNombreComercial() {
		return nombreComercial;
	}
	public void setNombreComercial(String nombreComercial) {
		this.nombreComercial = nombreComercial;
	}
	public Integer getSecuenciacanotadebito() {
		return secuenciacanotadebito;
	}

	public void setSecuenciacanotadebito(Integer secuenciacanotadebito) {
		this.secuenciacanotadebito = secuenciacanotadebito;
	}

	public Integer getSecuenciacanotacredito() {
		return secuenciacanotacredito;
	}

	public void setSecuenciacanotacredito(Integer secuenciacanotacredito) {
		this.secuenciacanotacredito = secuenciacanotacredito;
	}

	public Integer getSecuenciacaguiaremision() {
		return secuenciacaguiaremision;
	}

	public void setSecuenciacaguiaremision(Integer secuenciacaguiaremision) {
		this.secuenciacaguiaremision = secuenciacaguiaremision;
	}

	public Integer getSecuenciacaretencion() {
		return secuenciacaretencion;
	}

	public void setSecuenciacaretencion(Integer secuenciacaretencion) {
		this.secuenciacaretencion = secuenciacaretencion;
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
		if (!(obj instanceof Entidad)) {
			return false;
		}
		Entidad other = (Entidad) obj;
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

	@Override
	public String toString() {
		String result = getClass().getSimpleName() + " ";
		if (id != null)
			result += "id: " + id;
		result += ", version: " + version;
		if (razonSocial != null && !razonSocial.trim().isEmpty())
			result += ", razonSocial: " + razonSocial;
		if (direccion != null && !direccion.trim().isEmpty())
			result += ", direccion: " + direccion;
		return result;
	}

	public boolean isFacturaEnPruebas() {
		return facturaEnPruebas;
	}

	public void setFacturaEnPruebas(boolean facturaEnPruebas) {
		this.facturaEnPruebas = facturaEnPruebas;
	}

	public boolean isNotaCreditoEnPruebas() {
		return notaCreditoEnPruebas;
	}

	public void setNotaCreditoEnPruebas(boolean notaCreditoEnPruebas) {
		this.notaCreditoEnPruebas = notaCreditoEnPruebas;
	}

	public boolean isNotaDebitioEnPruebas() {
		return notaDebitioEnPruebas;
	}

	public void setNotaDebitioEnPruebas(boolean notaDebitioEnPruebas) {
		this.notaDebitioEnPruebas = notaDebitioEnPruebas;
	}

	public boolean isGuiaRemisionEnPruebas() {
		return guiaRemisionEnPruebas;
	}

	public void setGuiaRemisionEnPruebas(boolean guiaRemisionEnPruebas) {
		this.guiaRemisionEnPruebas = guiaRemisionEnPruebas;
	}

	public boolean isComprobanteRetencionEnPruebas() {
		return comprobanteRetencionEnPruebas;
	}

	public void setComprobanteRetencionEnPruebas(
			boolean comprobanteRetencionEnPruebas) {
		this.comprobanteRetencionEnPruebas = comprobanteRetencionEnPruebas;
	}
	public boolean isObligadoContabilidad() {
		return obligadoContabilidad;
	}
	public void setObligadoContabilidad(boolean obligadoContabilidad) {
		this.obligadoContabilidad = obligadoContabilidad;
	}
	public boolean isContribuyenteEspecial() {
		return contribuyenteEspecial;
	}
	public void setContribuyenteEspecial(boolean contribuyenteEspecial) {
		this.contribuyenteEspecial = contribuyenteEspecial;
	}
	public String getResolucionContibuyenteEspecial() {
		return resolucionContibuyenteEspecial;
	}
	public void setResolucionContibuyenteEspecial(
			String resolucionContibuyenteEspecial) {
		this.resolucionContibuyenteEspecial = resolucionContibuyenteEspecial;
	}

	
	
}