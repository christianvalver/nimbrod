package ec.com.vipsoft.erp.gui.componentesbasicos;

import java.util.Date;

import com.vaadin.data.fieldgroup.PropertyId;
import com.vaadin.ui.DateField;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import ec.com.vipsoft.erp.gui.tablas.TablaBienEconomico;
import ec.com.vipsoft.erp.gui.tablas.TablaFacturaDetalle;

public class ComponenteBaseFactura extends VerticalLayout {

	private static final long serialVersionUID = -5401955638845168794L;

	@PropertyId("ruc")
	protected CampoRuc camporuc;
	@PropertyId("razonSocial")
	protected CampoRazonSocial campoRazonSocial;
	@PropertyId("direccion")
	protected CampoDireccion campoDireccion;
	@PropertyId("telefono")
	protected CampoTelefono campoTelefono;
	protected Label labelRuc;
	protected Label labelRazonSocial;
	protected Label labelbienEconomico;	
	@PropertyId("numeroComprobante")
	protected CampoNumeroComprobante campoNumeroComprobante;
	@PropertyId("fechaFactura")
	protected DateField campoFecha;
	
	protected Label labelDireccion;
	protected Label labelTelefono;
	protected BotonBuscar botonBuscarCliente;
	protected BotonRegistrar botonRegistrar;
	protected BotonCancelar botonCancelar;		
	protected Label labelNumeroFactura;
	protected TablaFacturaDetalle tablaFacturaDetalle;
	protected TablaBienEconomico tablaCatalogoProductos;
	protected CampoTextoBusqueda campoBusquedaProducto;
	@PropertyId("subtotalIva0")
	protected CampoDineroLectura subtotalIva0;
	@PropertyId("subtotalIva12")
	protected CampoDineroLectura subtotalIva12;
	@PropertyId("iva12")
	protected CampoDineroLectura iva12;
	@PropertyId("ice")
	protected CampoDineroLectura ice;
	@PropertyId("totalFactura")
	protected CampoDineroLectura total;
	protected Label labelSutotaliva0;
	protected Label labelSutotaliva12;
	protected Label labelIva12;
	protected Label labelICE;
	protected Label labelTotal;
	protected BotonBuscar botonBuscarDetalles;
	protected CampoDinero campoAsignarValorUnitario;
	protected BotonAnadir botonAnadirDetalle;
	protected Label labelValorUnitarioAnadirDetalle;
	protected Label labelAnadirDetalle;	
	protected Label labelDescripcionNuevoDetalle;
	protected BotonRegistrar botonSeleccionar;

	protected Label labelAnadirDetalleCantidad;

	protected CampoSpinnerEntero campoAnadirDetalleCantidad;		
		
	public ComponenteBaseFactura() {
		super();
		iniciarEtiquetas();
		iniciarCampos();
		iniciarBotones();
		iniciarTablas();
	}

	public void iniciarTablas() {
		tablaFacturaDetalle=new TablaFacturaDetalle();
		tablaCatalogoProductos=new TablaBienEconomico();
	}

	protected void iniciarBotones() {
		botonBuscarCliente = new BotonBuscar();
		botonRegistrar = new BotonRegistrar();
		botonCancelar = new BotonCancelar();
		botonBuscarDetalles=new BotonBuscar();
		botonAnadirDetalle=new BotonAnadir();
		botonSeleccionar=new BotonRegistrar();
	}

	protected void iniciarCampos() {
		camporuc = new CampoRuc();
		campoRazonSocial = new CampoRazonSocial();
		campoDireccion = new CampoDireccion();
		campoTelefono = new CampoTelefono();
		campoNumeroComprobante = new CampoNumeroComprobante();
		campoFecha = new DateField();
		campoFecha.setDescription("establece la fecha de la factura");
		campoFecha.setDateFormat("dd/MM/yyyy");
		campoFecha.setValue(new Date());
		campoFecha.setWidth("150px");
		campoBusquedaProducto=new CampoTextoBusqueda();
		subtotalIva0=new CampoDineroLectura();
		subtotalIva12=new CampoDineroLectura();
		iva12=new CampoDineroLectura();
		ice=new CampoDineroLectura();
		total=new CampoDineroLectura();
		campoAsignarValorUnitario=new CampoDinero();
		campoAnadirDetalleCantidad=new CampoSpinnerEntero();
	
	}

	protected void iniciarEtiquetas() {
		labelRuc = new Label("Ruc/ID  ");
		labelRazonSocial = new Label("Razón Social  ");
		labelDireccion = new Label("Dirección  ");
		labelTelefono = new Label("Teléfono  ");
		labelNumeroFactura=new Label("Fact. N° ");
		labelbienEconomico=new Label("Producto");
		labelSutotaliva0=new Label("Subtotal 0%");
		labelSutotaliva12=new Label("Subtotal 12%");
		labelIva12=new Label("IVA 12%");
		labelICE=new Label("ICE");
		labelTotal=new Label("Total");	
		labelValorUnitarioAnadirDetalle=new Label("V. Unitario");
		labelDescripcionNuevoDetalle=new Label("");
		labelAnadirDetalle=new Label("Añadir Detalle");
		labelAnadirDetalleCantidad=new Label("Cantidad");
		
	}

	public CampoRuc getCamporuc() {
		return camporuc;
	}

	public void setCamporuc(CampoRuc camporuc) {
		this.camporuc = camporuc;
	}

	public CampoRazonSocial getCampoRazonSocial() {
		return campoRazonSocial;
	}

	public void setCampoRazonSocial(CampoRazonSocial campoRazonSocial) {
		this.campoRazonSocial = campoRazonSocial;
	}

	public CampoDireccion getCampoDireccion() {
		return campoDireccion;
	}

	public void setCampoDireccion(CampoDireccion campoDireccion) {
		this.campoDireccion = campoDireccion;
	}

	public CampoTelefono getCampoTelefono() {
		return campoTelefono;
	}

	public void setCampoTelefono(CampoTelefono campoTelefono) {
		this.campoTelefono = campoTelefono;
	}

	public Label getLabelRuc() {
		return labelRuc;
	}

	public void setLabelRuc(Label labelRuc) {
		this.labelRuc = labelRuc;
	}

	public Label getLabelRazonSocial() {
		return labelRazonSocial;
	}

	public void setLabelRazonSocial(Label labelRazonSocial) {
		this.labelRazonSocial = labelRazonSocial;
	}

	public CampoNumeroComprobante getCampoNumeroComprobante() {
		return campoNumeroComprobante;
	}

	public void setCampoNumeroComprobante(
			CampoNumeroComprobante campoNumeroComprobante) {
		this.campoNumeroComprobante = campoNumeroComprobante;
	}

	public DateField getCampoFecha() {
		return campoFecha;
	}

	public void setCampoFecha(DateField campoFecha) {
		this.campoFecha = campoFecha;
	}

	public Label getLabelDireccion() {
		return labelDireccion;
	}
	public void setLabelDireccion(Label labelDireccion) {
		this.labelDireccion = labelDireccion;
	}
	public Label getLabelTelefono() {
		return labelTelefono;
	}
	public void setLabelTelefono(Label labelTelefono) {
		this.labelTelefono = labelTelefono;
	}
}
