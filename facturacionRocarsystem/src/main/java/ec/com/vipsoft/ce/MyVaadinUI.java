package ec.com.vipsoft.ce;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import ec.com.vipsoft.erp.gui.componentesbasicos.ComponenteLayedOutBaseFactura;

@Theme("mytheme")
@SuppressWarnings("serial")
public class MyVaadinUI extends UI
{

    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = MyVaadinUI.class, widgetset = "ec.com.vipsoft.ce.AppWidgetSet")
    public static class Servlet extends VaadinServlet {
    }



	
	

    @Override
    protected void init(VaadinRequest request) {
        final VerticalLayout layout = new VerticalLayout();
        layout.setMargin(true);
        setContent(layout);
        ComponenteLayedOutBaseFactura f=new ComponenteLayedOutBaseFactura(true,false);
        layout.addComponent(f);            
      //  layout.addComponent(button);
    }
}
