package ec.com.vipsoft.erp.gui.componentesbasicos;

import com.vaadin.data.util.BeanItemContainer;

import ec.com.vipsoft.erp.gui.bindingbeans.BienEconomicoBiding;
import ec.com.vipsoft.erp.gui.bindingbeans.FacturaDetalleBinding;

public class ComponenteBaseFacturaBiding extends ComponenteBaseFactura{

	private static final long serialVersionUID = 4563293643137130124L;
	private BienEconomicoBiding bienEconomicoBiding1;
	//protected FacturaBiding facturaBiding;
	private FacturaDetalleBinding facturaDetalleBinding1;

	public ComponenteBaseFacturaBiding() {
		super();
		//facturaBiding = new FacturaBiding();
		fuenteDatosFacturaDetalles=new BeanItemContainer<FacturaDetalleBinding>(FacturaDetalleBinding.class);
		fuenteDatosCatalogoBienEconomicos=new BeanItemContainer<BienEconomicoBiding>(BienEconomicoBiding.class);
		iniciarDatos();
		tablaCatalogoProductos.setContainerDataSource(fuenteDatosCatalogoBienEconomicos);
		tablaFacturaDetalle.setContainerDataSource(fuenteDatosFacturaDetalles);
		tablaCatalogoProductos.setColumnCollapsed("codigoIVA", true);
		tablaCatalogoProductos.setColumnCollapsed("codigoICE", true);
		//
	}
	public void iniciarDatos() {
		bienEconomicoBiding1 = new BienEconomicoBiding();
		bienEconomicoBiding1.setCodigo("001");
		bienEconomicoBiding1.setDescripcion("pepito");
		fuenteDatosCatalogoBienEconomicos.addBean(bienEconomicoBiding1);
		facturaDetalleBinding1 = new FacturaDetalleBinding();
		facturaDetalleBinding1.setCodigo("001");		
		fuenteDatosFacturaDetalles.addBean(facturaDetalleBinding1);
		
	}
	protected BeanItemContainer<FacturaDetalleBinding>fuenteDatosFacturaDetalles;
	protected BeanItemContainer<BienEconomicoBiding>fuenteDatosCatalogoBienEconomicos;
	

}
