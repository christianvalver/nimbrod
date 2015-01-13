package ec.com.vipsoft.ce.backend.service;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

import ec.com.vipsoft.ce.backend.model.Entidad;
import ec.com.vipsoft.ce.backend.model.Sucursal;
import ec.com.vipsoft.erp.gui.bindingbeans.FacturaBiding;
import ec.com.vipsoft.erp.gui.bindingbeans.FacturaDetalleBinding;
import ec.com.vipsoft.jaxb.factura18.Factura;
import ec.com.vipsoft.jaxb.factura18.Factura.Detalles.Detalle.Impuestos;
import ec.com.vipsoft.jaxb.factura18.Factura.InfoFactura;
import ec.com.vipsoft.jaxb.factura18.Factura.InfoFactura.TotalConImpuestos;
import ec.com.vipsoft.jaxb.factura18.Impuesto;
import ec.com.vipsoft.jaxb.factura18.InfoTributaria;
import ec.com.vipsoft.jaxb.factura18.ObjectFactory;
import ec.com.vipsoft.jaxb.factura18.ObligadoContabilidad;

@Stateless
@WebService
public class GeneradorFacturaXML {
	
	
	@PersistenceContext
	EntityManager em;
	@EJB	
	private GeneradorClaveAccesoPorEntidad generadorClaveAcceso;
	
	
	public String generarFacturaEnXml(String rucEntidad,FacturaBiding factura){
		StringWriter sw=new StringWriter();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf2=new SimpleDateFormat("dd/MM/yyyy");		
		Query q=em.createQuery("select e from Entidad e where e.ruc=?1");	
		q.setParameter(1, rucEntidad);		  
		List<Entidad>listadoEntidad=q.getResultList();		  
		if(listadoEntidad.isEmpty()){			
		}else{			
			//consultar el horario para ver si camellamos con contingencia								
			Entidad entidad=em.find(Entidad.class, listadoEntidad.get(0).getId());
			ObjectFactory factoria=new ObjectFactory();
			Factura facturaRetorno=factoria.createFactura();
			facturaRetorno.setId("comprobante");
			facturaRetorno.setVersion("1.1.0");			
			InfoTributaria infoTributaria = factoria.createInfoTributaria();
			if(entidad.isFacturaEnPruebas()){
				infoTributaria.setAmbiente("1");
			}else{
				infoTributaria.setAmbiente("2");
			}
			StringTokenizer st=new StringTokenizer(factura.getNumeroComprobante(),"-");
			String establecimiento=st.nextToken();
			String pumtoEmsion=st.nextToken();
			String numeracion=st.nextToken();
			infoTributaria.setClaveAcceso(generadorClaveAcceso.generarClaveAccesoFactura(rucEntidad,Integer.valueOf(establecimiento), Integer.valueOf(pumtoEmsion)));			
			infoTributaria.setCodDoc("01");			
			infoTributaria.setDirMatriz(entidad.getDireccion());
			infoTributaria.setNombreComercial(entidad.getNombreComercial());
			infoTributaria.setRazonSocial(entidad.getRazonSocial());
			infoTributaria.setRuc(rucEntidad);
			infoTributaria.setTipoEmision("1");
			infoTributaria.setEstab(establecimiento);
			infoTributaria.setPtoEmi(pumtoEmsion);
			infoTributaria.setSecuencial(numeracion);  //<------   calcularlo para evitar errores.			
			facturaRetorno.setInfoTributaria(infoTributaria);
			
			
			InfoFactura infoFactura = factoria.createFacturaInfoFactura();
			TotalConImpuestos totalConImpuestos = factoria.createFacturaInfoFacturaTotalConImpuestos();
			infoFactura.setTotalConImpuestos(totalConImpuestos);
			facturaRetorno.setInfoFactura(infoFactura);
			
			facturaRetorno.getInfoFactura().setImporteTotal(factura.getTotalFactura());
			facturaRetorno.getInfoFactura().setPropina(new BigDecimal("0.00"));
			
			facturaRetorno.setInfoFactura(infoFactura);
			facturaRetorno.getInfoFactura().setDireccionComprador(factura.getDireccion());

			  Query qsucursal=em.createQuery("select s from Sucursal s where s.entidad.id=?1 and s.numeroSucursal=?2");
			   qsucursal.setParameter(1, entidad.getId());
			   qsucursal.setParameter(2, Integer.valueOf(establecimiento));
			   List<Sucursal>listaSucursal=qsucursal.getResultList();
			   if(!listaSucursal.isEmpty()){
				   Sucursal _sucursal=em.find(Sucursal.class,listaSucursal.get(0).getId());
				   facturaRetorno.getInfoFactura().setDirEstablecimiento(_sucursal.getDireccion());				   
			   }
			   if(entidad.isObligadoContabilidad()){
					facturaRetorno.getInfoFactura().setObligadoContabilidad(ObligadoContabilidad.SI);	
				}else{
					facturaRetorno.getInfoFactura().setObligadoContabilidad(ObligadoContabilidad.NO);
				}
			   
			   
			   if(!establecimiento.equalsIgnoreCase("001")){
					facturaRetorno.getInfoFactura().setDirEstablecimiento(entidad.getDireccion());
				}
				if(entidad.isContribuyenteEspecial()){
					facturaRetorno.getInfoFactura().setContribuyenteEspecial(entidad.getResolucionContibuyenteEspecial());
				}
				facturaRetorno.getInfoFactura().setTipoIdentificacionComprador(factura.getCodigoTipoIdentificacion());
				facturaRetorno.getInfoFactura().setRazonSocialComprador(factura.getRazonSocial());
				facturaRetorno.getInfoFactura().setIdentificacionComprador(factura.getRuc());
				facturaRetorno.getInfoFactura().setDireccionComprador(factura.getDireccion());
				facturaRetorno.getInfoFactura().setTotalSinImpuestos(factura.getSubtotalIva0());
				facturaRetorno.getInfoFactura().setTotalDescuento(factura.getDescuento());

			
				List<Factura.InfoFactura.TotalConImpuestos.TotalImpuesto>totalConImpuesto=new ArrayList<Factura.InfoFactura.TotalConImpuestos.TotalImpuesto>();
				
				if(factura.getSubtotalIva0().doubleValue()>0){
					Factura.InfoFactura.TotalConImpuestos.TotalImpuesto iva0=new Factura.InfoFactura.TotalConImpuestos.TotalImpuesto();
					iva0.setBaseImponible(factura.getSubtotalIva0());
					iva0.setCodigo("2");
					iva0.setCodigoPorcentaje("0");
					iva0.setTarifa(new BigDecimal("0"));
					iva0.setValor(new BigDecimal("0.00"));					
					facturaRetorno.getInfoFactura().getTotalConImpuestos().getTotalImpuesto().add(iva0);
				}
				if(factura.getSubtotalIva12().doubleValue()>0){
					Factura.InfoFactura.TotalConImpuestos.TotalImpuesto iva12=new Factura.InfoFactura.TotalConImpuestos.TotalImpuesto();
					iva12.setBaseImponible(factura.getSubtotalIva12());
					iva12.setCodigo("2");
					iva12.setCodigoPorcentaje("2");
					iva12.setTarifa(new BigDecimal("12.00"));
					iva12.setValor(factura.getIva12());
					facturaRetorno.getInfoFactura().getTotalConImpuestos().getTotalImpuesto().add(iva12);
				}
				
				if(factura.getIce().doubleValue()>0){
					Factura.InfoFactura.TotalConImpuestos.TotalImpuesto ice=new Factura.InfoFactura.TotalConImpuestos.TotalImpuesto();
					ice.setTarifa(factura.getIce());
					ice.setCodigo("3");
					facturaRetorno.getInfoFactura().getTotalConImpuestos().getTotalImpuesto().add(ice);
				}
//				if(factura.getExecntoiva().doubleValue()>0){
//					Factura.InfoFactura.TotalConImpuestos.TotalImpuesto excentoiva=new Factura.InfoFactura.TotalConImpuestos.TotalImpuesto();
//					excentoiva.setBaseImponible(_factura.getSubtotal12());
//					excentoiva.setCodigo("2");
//					excentoiva.setCodigoPorcentaje("7");
//					//excentoiva.setTarifa(new BigDecimal("12.00"));
//					excentoiva.setValor(_factura.getExecntoiva());
//					facturaRetorno.getInfoFactura().getTotalConImpuestos().getTotalImpuesto().add(excentoiva);
//				}
//				if(_factura.getNo_sujeto_impueesto().doubleValue()>0){				
//					ec.com.vipsoft.sri.jaxbinding.factura.Factura.InfoFactura.TotalConImpuestos.TotalImpuesto nosujetoAImpuesto=new ec.com.vipsoft.sri.jaxbinding.factura.Factura.InfoFactura.TotalConImpuestos.TotalImpuesto();
//					nosujetoAImpuesto.setCodigo("2");
//					nosujetoAImpuesto.setCodigoPorcentaje("6");
//					nosujetoAImpuesto.setValor(_factura.getNo_sujeto_impueesto());
//					facturaRetorno.getInfoFactura().getTotalConImpuestos().getTotalImpuesto().add(nosujetoAImpuesto);
//				}
				facturaRetorno.setDetalles(factoria.createFacturaDetalles());				
				for(FacturaDetalleBinding d:factura.getDetalles()){
					Factura.Detalles.Detalle detalle=new Factura.Detalles.Detalle();
					detalle.setCantidad(d.getCantidad().setScale(2, RoundingMode.HALF_DOWN));
					//detalle.setCodigoPrincipal(d.getCodigoICE());
					//detalle.setCodigoAuxiliar(d.getCodigoInterno());
					detalle.setCodigoPrincipal(d.getCodigo());			
					detalle.setDescripcion(d.getDescripcion());
					detalle.setDescuento(d.getDescuento().setScale(2, RoundingMode.HALF_DOWN));
					detalle.setPrecioUnitario(d.getValorUnitario().setScale(2, RoundingMode.HALF_DOWN));
					detalle.setPrecioTotalSinImpuesto(d.getValorTotal().setScale(2, RoundingMode.HALF_DOWN));
				    if(!d.getCodigoIva().isEmpty()){
				    	Impuesto impuesto=new Impuesto();
				    	
				    		impuesto.setBaseImponible(d.calculaBaeImponible());
				    		impuesto.setCodigo("2");
				    		impuesto.setCodigoPorcentaje(d.getCodigoIva().trim());
				    		impuesto.setTarifa(new BigDecimal("12"));
				    		impuesto.setValor(d.getIva().setScale(2, RoundingMode.HALF_DOWN));				    		
				    		Impuestos impuestos=new Impuestos();
				    		detalle.setImpuestos(impuestos);
				    		detalle.getImpuestos().getImpuesto().add(impuesto);
				    		//detalle.getImpuestos().getImpuesto().add(e)
				    }
				    facturaRetorno.getDetalles().getDetalle().add(detalle);				 
				}				   				    				
				facturaRetorno.getInfoFactura().setFechaEmision(sdf2.format(factura.getFechaFactura()));
				JAXBContext context;
				try {
					context = JAXBContext.newInstance(Factura.class);
					Marshaller m = context.createMarshaller();
		            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		            m.marshal(facturaRetorno,sw);
				} catch (JAXBException e2) {
					e2.printStackTrace();
				}	            		        		        		
		}
		System.out.println(sw.toString());
		return sw.toString();		
	}
}
