package ec.com.vipsoft.erp.gui.componentesbasicos;

import com.vaadin.data.Container.Filterable;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.data.util.filter.SimpleStringFilter;
import com.vaadin.event.FieldEvents.TextChangeEvent;
import com.vaadin.event.FieldEvents.TextChangeListener;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Table.Align;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

import ec.com.vipsoft.erp.gui.bindingbeans.BienEconomicoBiding;
import ec.com.vipsoft.erp.gui.bindingbeans.FacturaBiding;
import ec.com.vipsoft.erp.gui.bindingbeans.FacturaDetalleBinding;

public class ComponenteBaseFacturaBiding extends ComponenteBaseFactura{

	private static final long serialVersionUID = 4563293643137130124L;
	private BienEconomicoBiding bienEconomicoBiding1;
	protected FacturaBiding facturaBiding;
	protected FacturaDetalleBinding facturaDetalleBinding1;
	protected BeanItem<FacturaBiding>beanITemFactura;
	protected FacturaDetalleBinding detalleFacturaBiding;
	protected BeanItem<FacturaDetalleBinding>beanItemFacturaDetalle;
	private VerticalLayout layoutCatalogo;
	private HorizontalLayout lch1;
	
	

	public ComponenteBaseFacturaBiding() {
		super();		
		establecerBindingFactura();
		layoutCatalogo=new VerticalLayout();
		lch1=new HorizontalLayout();
		lch1.setSpacing(true);
		lch1.addComponent(labelbienEconomico);
		lch1.addComponent(campoBusquedaProducto);
		layoutCatalogo.addComponent(lch1);
		layoutCatalogo.addComponent(tablaCatalogoProductos);
		//layoutCatalogo.setSpacing(true);
		//layoutCatalogo.setSizeFull();
		layoutCatalogo.setSpacing(true);
		fuenteDatosFacturaDetalles=new BeanItemContainer<FacturaDetalleBinding>(FacturaDetalleBinding.class);
		fuenteDatosCatalogoBienEconomicos=new BeanItemContainer<BienEconomicoBiding>(BienEconomicoBiding.class);
		iniciarDatos();
		tablaCatalogoProductos.setContainerDataSource(fuenteDatosCatalogoBienEconomicos);
		tablaFacturaDetalle.setContainerDataSource(fuenteDatosFacturaDetalles);
		tablaCatalogoProductos.setColumnCollapsed("codigoIVA", true);
		tablaCatalogoProductos.setColumnCollapsed("codigoICE", true);
		Object[] columnasVisibles=new String[]{"cantidad","codigo","descripcion","valorUnitario","descuento","valorTotal"};		
		tablaFacturaDetalle.setVisibleColumns(columnasVisibles);
		tablaFacturaDetalle.setColumnWidth("cantidad", 70);
		tablaFacturaDetalle.setColumnHeader("cantidad", "CANTIDAD");
		tablaFacturaDetalle.setColumnHeader("valorUnitario", "V.UNITARIO");
		tablaFacturaDetalle.setColumnHeader("valorTotal", "V.TOTAL");
		tablaFacturaDetalle.setColumnHeader("descripcion", "DESCRIPCIÓN");
		tablaFacturaDetalle.setColumnHeader("descuento", "DSCTO.");
		tablaFacturaDetalle.setColumnHeader("codigo", "CÓDIGO");
		tablaFacturaDetalle.setColumnWidth("codigo", 100);
		tablaFacturaDetalle.setColumnWidth("valorUnitario", 100);
		tablaFacturaDetalle.setColumnAlignment("valorUnitario",Align.RIGHT);
		tablaFacturaDetalle.setColumnWidth("descuento", 100);
		tablaFacturaDetalle.setColumnAlignment("descuento", Align.RIGHT);
		tablaFacturaDetalle.setColumnWidth("valorTotal", 150);
		tablaFacturaDetalle.setColumnAlignment("valorTotal", Align.RIGHT);
		
		establecerEventoBusqueda();
		establecerEventoCancelar();
		establecerEventoRegistrar();
		establecerEventoBotonBuscarDetalle();
		
		
		//
	}
	protected void establecerEventoBotonBuscarDetalle() {
		botonBuscarDetalles.addClickListener(new ClickListener() {
			private static final long serialVersionUID = 5640416676339470645L;			

			@Override
			public void buttonClick(ClickEvent event) {
				Window ventanapopup=new Window();				
				ventanapopup.setModal(true);
				ventanapopup.setWidth("400px");				
				layoutCatalogo.setMargin(true);				
				ventanapopup.setContent(layoutCatalogo);
				ventanapopup.center();
				//ventanapopup.set
				getUI().addWindow(ventanapopup);
				
				
			}
		});
	}
	protected void establecerBindingFactura() {
		facturaBiding=new FacturaBiding();
		facturaBiding.setDireccion("la calle");
		beanITemFactura=new BeanItem<FacturaBiding>(facturaBiding);
		FieldGroup binder=new FieldGroup();
		binder.setItemDataSource(beanITemFactura);
		binder.bindMemberFields(this);
	}
	public void limpiarPantalla(){
		fuenteDatosFacturaDetalles.removeAllItems();		
		campoBusquedaProducto.setValue("");
		campoDireccion.setValue("");
		campoRazonSocial.setValue("");
		camporuc.setValue("");
		String ceroEnString="0.00";
		subtotalIva0.setValue(ceroEnString);
		subtotalIva12.setValue(ceroEnString);
		iva12.setValue(ceroEnString);
		ice.setValue(ceroEnString);
		total.setValue(ceroEnString);
		cancelarAntesFinalizar();
	}
	public void cancelarAntesFinalizar(){
		
	}
	public void establecerEventoCancelar() {
		// TODO Auto-generated method stub
		botonCancelar.addClickListener(new ClickListener() {
			private static final long serialVersionUID = -8051028686378126248L;
			@Override
			public void buttonClick(ClickEvent event) {
				limpiarPantalla();		
			}
		});
		
		
	}
	public void establecerEventoRegistrar() {
		// TODO Auto-generated method stub
		
	}
	protected void establecerEventoBusqueda() {
		//si no es  enter filtrar 
		//si es enter y hay un match pasar
		//campoBusquedaProducto.addTextChangeListener(filtroFuenteDatosProducto);
		//SimpleStringFilter sfilter=new SimpleStringFilter(campoBusquedaProducto, filterString, ignoreCase, onlyMatchPrefix)
		
		campoBusquedaProducto.addTextChangeListener(new TextChangeListener() {
		    /**
			 * 
			 */
			private static final long serialVersionUID = 5128049403423426140L;
			SimpleStringFilter filter = null;

		    public void textChange(final TextChangeEvent event) {
		        final Filterable f = (Filterable)
	            tablaCatalogoProductos.getContainerDataSource();
		        
		        // Remove old filter
		        if (filter != null)
		            f.removeContainerFilter(filter);
		        
		        // Set new filter for the "Name" column
		        filter = new SimpleStringFilter("descripcion", event.getText(),
		                                        true, false);
		        f.addContainerFilter(filter);
		    }
		});
	}	

	public void iniciarDatos() {
		bienEconomicoBiding1 = new BienEconomicoBiding();
		bienEconomicoBiding1.setCodigo("001");
		bienEconomicoBiding1.setDescripcion("pepito");		
		fuenteDatosCatalogoBienEconomicos.addBean(bienEconomicoBiding1);
		fuenteDatosCatalogoBienEconomicos.addBean(new BienEconomicoBiding("002","juantio"));
		fuenteDatosCatalogoBienEconomicos.addBean(new BienEconomicoBiding("003","juanfrancisco"));
		facturaDetalleBinding1 = new FacturaDetalleBinding();
		facturaDetalleBinding1.setCodigo("001");		
		fuenteDatosFacturaDetalles.addBean(facturaDetalleBinding1);		
	}
	protected BeanItemContainer<FacturaDetalleBinding>fuenteDatosFacturaDetalles;
	protected BeanItemContainer<BienEconomicoBiding>fuenteDatosCatalogoBienEconomicos;
}
