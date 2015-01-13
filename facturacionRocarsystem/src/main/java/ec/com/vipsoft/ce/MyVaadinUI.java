package ec.com.vipsoft.ce;

 import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.GregorianCalendar;

import javax.servlet.annotation.WebServlet;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import ec.com.vipsoft.ce.backend.service.FacturaBiding;
import ec.com.vipsoft.ce.backend.service.FacturaDetalleBinding;
import ec.com.vipsoft.ce.backend.service.GeneradorFacturaXML;
import ec.com.vipsoft.ce.backend.service.GeneradorFacturaXMLService;
import ec.com.vipsoft.erp.gui.bindingbeans.BienEconomicoBiding;
import ec.com.vipsoft.erp.gui.componentesbasicos.ComponenteLayedOutBaseFactura;

@Theme("mytheme")
@SuppressWarnings("serial")
public class MyVaadinUI extends UI
{
    GeneradorFacturaXMLService service1 = new GeneradorFacturaXMLService();    
    GeneradorFacturaXML port1 = service1.getGeneradorFacturaXMLPort();
    String ruc=new String("1719739477001"); 

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
	        		FacturaBiding nuevaFactura=new FacturaBiding();
	        		GregorianCalendar c = new GregorianCalendar();
	        		c.setTime(facturaBiding.getFechaFactura());
	        		XMLGregorianCalendar date2;
					try {
						date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
						nuevaFactura.setFechaFactura(date2);					
					} catch (DatatypeConfigurationException e) {						
						e.printStackTrace();
					}
	        		nuevaFactura.setContribuyenteEspecial(facturaBiding.getContribuyenteEspecial());
	        		nuevaFactura.setDescuento(facturaBiding.getDescuento());
	        		nuevaFactura.setDireccion(facturaBiding.getDireccion());
	        		nuevaFactura.setDireccionMatriz(facturaBiding.getDireccion());
	        		nuevaFactura.setIce(facturaBiding.getIce());
	        		nuevaFactura.setIva12(facturaBiding.getIva12());
	        		nuevaFactura.setNumeroComprobante(facturaBiding.getNumeroComprobante());
	        		nuevaFactura.setRazonSocial(facturaBiding.getRazonSocial());
	        		nuevaFactura.setRazonSocialEmisor(facturaBiding.getRazonSocialEmisor());
	        		nuevaFactura.setResolucionContribuyenteEspecial(facturaBiding.getResolucionContribuyenteEspecial());
	        		nuevaFactura.setRuc(facturaBiding.getRuc());
	        		nuevaFactura.setRucEmisor(facturaBiding.getRucEmisor());
	        		nuevaFactura.setSecuenciaFactura(facturaBiding.getSecuenciaFactura());
	        		nuevaFactura.setSubtotalIva0(facturaBiding.getSubtotalIva0());
	        		nuevaFactura.setSubtotalIva12(facturaBiding.getSubtotalIva12());
	        		nuevaFactura.setTotalFactura(facturaBiding.getTotalFactura());
	        		for(ec.com.vipsoft.erp.gui.bindingbeans.FacturaDetalleBinding d:facturaBiding.getDetalles()){
	        			FacturaDetalleBinding nuevoDetalle=new FacturaDetalleBinding();
	        			nuevoDetalle.setCantidad(d.getCantidad());
	        			nuevoDetalle.setCodigo(d.getCodigo());
	        			nuevoDetalle.setCodigoIce(d.getCodigoIce());
	        			nuevoDetalle.setCodigoIva(d.getCodigoIva());
	        			nuevoDetalle.setDescripcion(d.getDescripcion());
	        			nuevoDetalle.setDescuento(d.getDescuento());
	        			nuevoDetalle.setIce(d.getIce());
	        			nuevoDetalle.setIva(d.getIva());
	        			nuevoDetalle.setValorTotal(d.getValorTotal());
	        			nuevoDetalle.setValorUnitario(d.getValorUnitario());
	        			nuevaFactura.getDetalles().add(nuevoDetalle);
	        		}	        			       
	        		String enxml=port1.generarFacturaEnXml(ruc,nuevaFactura);
	        		System.out.println(enxml);
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
						e.printStackTrace();
					}
	        	}	        	
	        };	        
	        layout.addComponent(f);
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		}    	                        
    }
}
