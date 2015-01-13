package ec.com.vipsoft.ce;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import ec.com.vipsoft.ce.wsclient.AdministracionEntidad;
import ec.com.vipsoft.ce.wsclient.AdministracionEntidadService;
import ec.com.vipsoft.ce.wsclient.Entidad;

@Theme("mytheme")
@SuppressWarnings("serial")
public class MyVaadinUI extends UI
{

	
    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = MyVaadinUI.class, widgetset = "ec.com.vipsoft.ce.AppWidgetSet")
    public static class Servlet extends VaadinServlet {
    }

	private TextField ruc;

    @Override
    protected void init(VaadinRequest request) {
        final VerticalLayout layout = new VerticalLayout();
        layout.setMargin(true);
        setContent(layout);
        ruc=new TextField();
        final TextField razonSocial = new TextField();
        final TextField nombreComercial = new TextField();
        
        
        
        
        Button button = new Button("Click Me");
        button.addClickListener(new Button.ClickListener() {
            public void buttonClick(ClickEvent event) {
            	AdministracionEntidadService servicio=new AdministracionEntidadService();
            	AdministracionEntidad port = servicio.getAdministracionEntidadPort();
            	Entidad entidad=new Entidad();
            	entidad.setRuc("1719739477001");
            	entidad.setRazonSocial("SISTEMAS DE SALUD ROCARSYSTEM S.A.");
            	entidad.setContribuyenteEspecial(true);
            	entidad.setResolucionContibuyenteEspecial("826 del 22/12/2009");
            	entidad.setDireccion("Urdesa Central Todos los Santos 201 y Circunvalación Sur");
            	entidad.setFacturaEnPruebas(true);
            	entidad.setComprobanteRetencionEnPruebas(true);
            	entidad.setGuiaRemisionEnPruebas(true);
            	entidad.setNotaCreditoEnPruebas(true);
            	entidad.setNotaDebitioEnPruebas(true);
            	port.registrarEntidad("mariateniauncorderito", entidad, 2);
            	
//            	port.crearEntidad(ruc.getValue(), razonSocial.getValue(), nombreComercial.getValue(), 2);
            	layout.addComponent(new Label("Thank you for clicking"));
            }
        });
        layout.addComponent(button);
        layout.addComponent(ruc);
        layout.addComponent(razonSocial);
        layout.addComponent(nombreComercial);
    }

}
