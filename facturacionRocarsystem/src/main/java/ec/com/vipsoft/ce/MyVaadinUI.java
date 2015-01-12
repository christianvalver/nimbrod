package ec.com.vipsoft.ce;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import ec.com.vipsoft.erp.gui.bindingbeans.BienEconomicoBiding;
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
    	
    	try {
    		
			Class.forName("org.postgresql.Driver");
			
			final VerticalLayout layout = new VerticalLayout();
	        layout.setMargin(true);
	        setContent(layout);
	        ComponenteLayedOutBaseFactura f=new ComponenteLayedOutBaseFactura(true,false){
	        	@Override
	        	protected void eventoRegistrar() {
	        		System.out.println("Hola "+facturaBiding.getDetalles().size());
	        		
	        	}
	        	@Override
	        	public void iniciarDatos() {
	        		try {
	        			Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/rocarsystem","chrisvv","palita");
						Statement stm=con.createStatement();
						ResultSet rst=stm.executeQuery("select codigo,descripcion from bieneconomico order by descripcion");
						while(rst.next()){
							fuenteDatosCatalogoBienEconomicos.addBean(new BienEconomicoBiding(rst.getString("codigo"),rst.getString("descripcion")));
						}
						rst.close();
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	        	}
	        	
	        };
	        
	        layout.addComponent(f);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
                         
    }
}
