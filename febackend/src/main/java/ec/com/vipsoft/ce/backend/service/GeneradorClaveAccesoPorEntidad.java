package ec.com.vipsoft.ce.backend.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.constraints.Size;
import javax.ws.rs.Produces;

import ec.com.vipsoft.ce.backend.model.Entidad;
import ec.com.vipsoft.ce.backend.model.PuntoEmision;
import ec.com.vipsoft.ce.backend.model.Sucursal;

import java.io.Serializable;
import java.util.List;

@Stateless
@LocalBean
@WebService
public class GeneradorClaveAccesoPorEntidad implements Serializable
{
	
	@PersistenceContext
	EntityManager em;
	@EJB
	GeneradorClaveAcceso generadorReal;
   private static final long serialVersionUID = -1L;
  
   
   public String generarClaveAccesoRetencion(@Size(max=13,min=13)String ruc,Integer sucursal,Integer ptoEmision){
	   StringBuilder retorno=new StringBuilder();
	   Query q=em.createQuery("select e from Entidad e where e.ruc=?1");
	   q.setParameter(1, ruc);
	   List<Entidad>listadoEntidad=q.getResultList();
	   if(!listadoEntidad.isEmpty()){
		   retorno.append("entidad o ruc no registrado");
	   }else{
		   Entidad entidad=em.find(Entidad.class, listadoEntidad.get(0).getId());
		   Query qsucursal=em.createQuery("select s from Sucursal s where s.entidad.id=?1 and s.numeroSucursal=?2");
		   qsucursal.setParameter(1, entidad.getId());
		   qsucursal.setParameter(2, sucursal);
		   List<Sucursal>listaSucursal=qsucursal.getResultList();
		   if(!listaSucursal.isEmpty()){
			   Sucursal _sucursal=em.find(Sucursal.class,listaSucursal.get(0).getId());
			   for(PuntoEmision ptoe:_sucursal.getPuntosEmision()){
				   if(ptoe.getId().longValue()==(long)ptoEmision){
					   PuntoEmision _emision=em.find(PuntoEmision.class, ptoe.getId());
					   int _secuencia=_emision.siguienteSecuenciaRetencion();					   
					   retorno.append( generadorReal.generarClaveAccesoFactura(ruc, sucursal, ptoEmision,entidad.isFacturaEnPruebas(), _secuencia,entidad.siguienteCARetencion()));
					   break;
				   }
			   }
		   }else{
			   retorno.append("no tenemos registro de esa sucursal");
		   }  
	   }		  	  
	return retorno.toString();   
   }
   
   public String generarClaveAccesoGuiaRemision(@Size(max=13,min=13)String ruc,Integer sucursal,Integer ptoEmision){
	   StringBuilder retorno=new StringBuilder();
	   Query q=em.createQuery("select e from Entidad e where e.ruc=?1");
	   q.setParameter(1, ruc);
	   List<Entidad>listadoEntidad=q.getResultList();
	   if(!listadoEntidad.isEmpty()){
		   retorno.append("entidad o ruc no registrado");
	   }else{
		   Entidad entidad=em.find(Entidad.class, listadoEntidad.get(0).getId());
		   Query qsucursal=em.createQuery("select s from Sucursal s where s.entidad.id=?1 and s.numeroSucursal=?2");
		   qsucursal.setParameter(1, entidad.getId());
		   qsucursal.setParameter(2, sucursal);
		   List<Sucursal>listaSucursal=qsucursal.getResultList();
		   if(!listaSucursal.isEmpty()){
			   Sucursal _sucursal=em.find(Sucursal.class,listaSucursal.get(0).getId());
			   for(PuntoEmision ptoe:_sucursal.getPuntosEmision()){
				   if(ptoe.getId().longValue()==(long)ptoEmision){
					   PuntoEmision _emision=em.find(PuntoEmision.class, ptoe.getId());
					   int _secuencia=_emision.siguienteSecuenciaGuiaRemision();					   
					   retorno.append( generadorReal.generarClaveAccesoFactura(ruc, sucursal, ptoEmision,entidad.isFacturaEnPruebas(), _secuencia,entidad.siguienteCAGuiaRemision()));
					   break;
				   }
			   }
		   }else{
			   retorno.append("no tenemos registro de esa sucursal");
		   }  
	   }		  	  
	return retorno.toString();   
   }
   public String generarClaveAccesoNotaCredito(@Size(max=13,min=13)String ruc,Integer sucursal,Integer ptoEmision){
	   StringBuilder retorno=new StringBuilder();
	   Query q=em.createQuery("select e from Entidad e where e.ruc=?1");
	   q.setParameter(1, ruc);
	   List<Entidad>listadoEntidad=q.getResultList();
	   if(!listadoEntidad.isEmpty()){
		   retorno.append("entidad o ruc no registrado");
	   }else{
		   Entidad entidad=em.find(Entidad.class, listadoEntidad.get(0).getId());
		   Query qsucursal=em.createQuery("select s from Sucursal s where s.entidad.id=?1 and s.numeroSucursal=?2");
		   qsucursal.setParameter(1, entidad.getId());
		   qsucursal.setParameter(2, sucursal);
		   List<Sucursal>listaSucursal=qsucursal.getResultList();
		   if(!listaSucursal.isEmpty()){
			   Sucursal _sucursal=em.find(Sucursal.class,listaSucursal.get(0).getId());
			   for(PuntoEmision ptoe:_sucursal.getPuntosEmision()){
				   if(ptoe.getId().longValue()==(long)ptoEmision){
					   PuntoEmision _emision=em.find(PuntoEmision.class, ptoe.getId());
					   int _secuencia=_emision.siguienteSecuenciaNotaCredito();					   
					   retorno.append( generadorReal.generarClaveAccesoNotaCredito(ruc, sucursal, ptoEmision,entidad.isFacturaEnPruebas(), _secuencia,entidad.siguienteCANotaCredito()));
					   break;
				   }
			   }
		   }else{
			   retorno.append("no tenemos registro de esa sucursal");
		   }  
	   }		  	  
	return retorno.toString();   
   }
   
   
   
   
   public String generarClaveAccesoNotaDebito(@Size(max=13,min=13)String ruc,Integer sucursal,Integer ptoEmision){
	   StringBuilder retorno=new StringBuilder();
	   Query q=em.createQuery("select e from Entidad e where e.ruc=?1");
	   q.setParameter(1, ruc);
	   List<Entidad>listadoEntidad=q.getResultList();
	   if(!listadoEntidad.isEmpty()){
		   retorno.append("entidad o ruc no registrado");
	   }else{
		   Entidad entidad=em.find(Entidad.class, listadoEntidad.get(0).getId());
		   Query qsucursal=em.createQuery("select s from Sucursal s where s.entidad.id=?1 and s.numeroSucursal=?2");
		   qsucursal.setParameter(1, entidad.getId());
		   qsucursal.setParameter(2, sucursal);
		   List<Sucursal>listaSucursal=qsucursal.getResultList();
		   if(!listaSucursal.isEmpty()){
			   Sucursal _sucursal=em.find(Sucursal.class,listaSucursal.get(0).getId());
			   for(PuntoEmision ptoe:_sucursal.getPuntosEmision()){
				   if(ptoe.getId().longValue()==(long)ptoEmision){
					   PuntoEmision _emision=em.find(PuntoEmision.class, ptoe.getId());
					   int _secuencia=_emision.siguienteSecuenciaNotaDebito();					   
					   retorno.append( generadorReal.generarClaveAccesoNotaDebito(ruc, sucursal, ptoEmision,entidad.isNotaDebitioEnPruebas(), _secuencia,entidad.siguienteCANotaDebito()));
					   break;
				   }
			   }
		   }else{
			   retorno.append("no tenemos registro de esa sucursal");
		   }  
	   }		  	  
	return retorno.toString();   
   }
   public String generarClaveAccesoFactura(@Size(max=13,min=13)String ruc,Integer sucursal,Integer ptoEmision){
	   StringBuilder retorno=new StringBuilder();
	   Query q=em.createQuery("select e from Entidad e where e.ruc=?1");
	   q.setParameter(1, ruc);
	   List<Entidad>listadoEntidad=q.getResultList();
	   if(!listadoEntidad.isEmpty()){
		   retorno.append("entidad o ruc no registrado");
	   }else{
		   Entidad entidad=em.find(Entidad.class, listadoEntidad.get(0).getId());
		   Query qsucursal=em.createQuery("select s from Sucursal s where s.entidad.id=?1 and s.numeroSucursal=?2");
		   qsucursal.setParameter(1, entidad.getId());
		   qsucursal.setParameter(2, sucursal);
		   List<Sucursal>listaSucursal=qsucursal.getResultList();
		   if(!listaSucursal.isEmpty()){
			   Sucursal _sucursal=em.find(Sucursal.class,listaSucursal.get(0).getId());
			   for(PuntoEmision ptoe:_sucursal.getPuntosEmision()){
				   if(ptoe.getId().longValue()==(long)ptoEmision){
					   PuntoEmision _emision=em.find(PuntoEmision.class, ptoe.getId());
					   int _secuencia=_emision.siguienteSecuenciaFactura();					   
					   retorno.append( generadorReal.generarClaveAccesoFactura(ruc, sucursal, ptoEmision,entidad.isFacturaEnPruebas(), _secuencia,entidad.siguienteCAFactura()));
					   break;
				   }
			   }
		   }else{
			   retorno.append("no tenemos registro de esa sucursal");
		   }  
	   }		  	  
	return retorno.toString();   
   }
   public String regenerarClaveAccesoContingencia(String claveAccesoNormal){
	   return generadorReal.generarClaveAccesoContingencia(claveAccesoNormal);
   }
}