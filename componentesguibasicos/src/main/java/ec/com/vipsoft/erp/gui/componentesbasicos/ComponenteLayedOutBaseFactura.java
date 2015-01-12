package ec.com.vipsoft.erp.gui.componentesbasicos;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class ComponenteLayedOutBaseFactura extends ComponenteBaseFacturaBiding {

	private static final long serialVersionUID = -1224282184571903459L;

	public ComponenteLayedOutBaseFactura(boolean linea1full,boolean usarBotonBusquedaCliente) {
		super();
		setSpacing(true);
		iniciarLayout(linea1full,usarBotonBusquedaCliente);
	}
	protected HorizontalLayout linea1;
	protected HorizontalLayout linea2;
	public void iniciarLayout(boolean linea1f,boolean usarBotonBusquedaCliente) {
		
		linea1=new HorizontalLayout();
		if(linea1f){
	//		linea1.setWidth("100%");
			linea1.setSpacing(true);
		}
		linea2=new HorizontalLayout();
		if(usarBotonBusquedaCliente)
			linea1.addComponent(botonBuscarCliente);
		linea1.addComponent(labelRuc);
		linea1.addComponent(camporuc);
		linea1.addComponent(labelRazonSocial);
		linea1.addComponent(campoRazonSocial);
		linea1.addComponent(labelDireccion);
		linea1.addComponent(campoDireccion);
		linea1.addComponent(labelNumeroFactura);
		linea1.addComponent(campoNumeroComprobante);
		linea1.addComponent(campoFecha);
		//linea1.addComponent(botonRegistrar);
		
		linea2=new HorizontalLayout();
		linea2.setSizeFull();		
		
		
		//lch1.setMargin(true);
		
		
		HorizontalLayout layoutSubtotales=new HorizontalLayout();
		//layoutSubtotales.setWidth("100%");
		layoutSubtotales.setSpacing(true);		
		layoutSubtotales.addComponent(labelSutotaliva0);
		layoutSubtotales.addComponent(subtotalIva0);
		layoutSubtotales.addComponent(labelSutotaliva12);
		layoutSubtotales.addComponent(subtotalIva12);
		layoutSubtotales.addComponent(labelIva12);
		layoutSubtotales.addComponent(iva12);
		layoutSubtotales.addComponent(labelICE);
		layoutSubtotales.addComponent(ice);
		layoutSubtotales.addComponent(labelTotal);
		layoutSubtotales.addComponent(total);
		
		VerticalLayout layoutDerecho=new VerticalLayout();
		layoutDerecho.setSpacing(true);
		layoutDerecho.setMargin(true);
		HorizontalLayout layoutBotones=new HorizontalLayout();
		
		layoutBotones.setSpacing(true);
		layoutBotones.addComponent(botonBuscarDetalles);
		labelDescripcionNuevoDetalle.setWidth("300px");
		labelDescripcionNuevoDetalle.setStyleName("h3");
		layoutBotones.addComponent(labelDescripcionNuevoDetalle);		
		layoutBotones.addComponent(labelAnadirDetalleCantidad);
		layoutBotones.addComponent(campoAnadirDetalleCantidad);
		layoutBotones.addComponent(labelValorUnitarioAnadirDetalle);
		layoutBotones.addComponent(campoAsignarValorUnitario);
		layoutBotones.addComponent(botonAnadirDetalle);
		Label lespacio=new Label("");
		lespacio.setWidth("80px");
		layoutBotones.addComponent(lespacio);
		layoutBotones.addComponent(botonRegistrar);
		layoutBotones.addComponent(botonCancelar);
		layoutDerecho.addComponent(layoutBotones);
		layoutDerecho.addComponent(tablaFacturaDetalle);
		layoutDerecho.addComponent(layoutSubtotales);
		layoutDerecho.setComponentAlignment(layoutSubtotales, Alignment.MIDDLE_RIGHT);
		layoutDerecho.setComponentAlignment(layoutBotones,Alignment.MIDDLE_CENTER);
		//linea2.addComponent(layoutCatalogo);
		linea2.addComponent(layoutDerecho);
		//linea2.setExpandRatio(layoutCatalogo, 2);
		//linea2.setExpandRatio(layoutDerecho,7);
		
		//linea2.setWidth("100%");
		addComponent(linea1);
		addComponent(linea2);
		
	}
	

}
