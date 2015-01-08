package ec.com.vipsoft.ce.backend.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

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
	@EJB
	AdministradorContingencia administracionContingencia;
   private static final long serialVersionUID = -1L;
  
   
   public String generarClaveAccesoRetencion(@Pattern(regexp = "[0-9]{13,13}")String ruc,Integer sucursal,Integer ptoEmision){
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
					   String claveGenerada=generadorReal.generarClaveAccesoFactura(ruc, sucursal, ptoEmision,entidad.isFacturaEnPruebas(), _secuencia,entidad.siguienteCARetencion());
					   if(administracionContingencia.estamosEnContingenciaProgramada()){
						   retorno.append(generadorReal.generarClaveAccesoContingencia(claveGenerada));
					   }else{
						   retorno.append(claveGenerada);   
					   }
					   
					   break;
				   }
			   }
		   }else{
			   retorno.append("no tenemos registro de esa sucursal");
		   }  
	   }		  	  
	return retorno.toString();   
   }
   
   public String generarClaveAccesoGuiaRemision(@Pattern(regexp = "[0-9]{13,13}")String ruc,Integer sucursal,Integer ptoEmision){
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
					   String claveGenerada= generadorReal.generarClaveAccesoFactura(ruc, sucursal, ptoEmision,entidad.isFacturaEnPruebas(), _secuencia,entidad.siguienteCAGuiaRemision());
					   if(administracionContingencia.estamosEnContingenciaProgramada()){
						   retorno.append(generadorReal.generarClaveAccesoContingencia(claveGenerada));
					   }else{
						   retorno.append(claveGenerada);   
					   }
					   break;
				   }
			   }
		   }else{
			   retorno.append("no tenemos registro de esa sucursal");
		   }  
	   }		  	  
	return retorno.toString();   
   }
   public String generarClaveAccesoNotaCredito(@Pattern(regexp = "[0-9]{13,13}")String ruc,Integer sucursal,Integer ptoEmision){
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
					   String claveGenerada= generadorReal.generarClaveAccesoNotaCredito(ruc, sucursal, ptoEmision,entidad.isFacturaEnPruebas(), _secuencia,entidad.siguienteCANotaCredito());
					   if(administracionContingencia.estamosEnContingenciaProgramada()){
						   retorno.append(generadorReal.generarClaveAccesoContingencia(claveGenerada));
					   }else{
						   retorno.append(claveGenerada);   
					   }
					   break;
				   }
			   }
		   }else{
			   retorno.append("no tenemos registro de esa sucursal");
		   }  
	   }		  	  
	return retorno.toString();   
   }
   
   
   
   
   public String generarClaveAccesoNotaDebito(@Pattern(regexp = "[0-9]{13,13}")String ruc,Integer sucursal,Integer ptoEmision){
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
					   String claveGenerada=generadorReal.generarClaveAccesoNotaDebito(ruc, sucursal, ptoEmision,entidad.isNotaDebitioEnPruebas(), _secuencia,entidad.siguienteCANotaDebito());
					   if(administracionContingencia.estamosEnContingenciaProgramada()){
						   retorno.append(generadorReal.generarClaveAccesoContingencia(claveGenerada));
					   }else{
						   retorno.append(claveGenerada);   
					   }
					   break;
				   }
			   }
		   }else{
			   retorno.append("no tenemos registro de esa sucursal");
		   }  
	   }		  	  
	return retorno.toString();   
   }
   public String generarClaveAccesoFactura(@Pattern(regexp = "[0-9]{13,13}")String ruc,Integer sucursal,Integer ptoEmision){
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
					   String claveGenerada=generadorReal.generarClaveAccesoFactura(ruc, sucursal, ptoEmision,entidad.isFacturaEnPruebas(), _secuencia,entidad.siguienteCAFactura());
					   if(administracionContingencia.estamosEnContingenciaProgramada()){
						   retorno.append(generadorReal.generarClaveAccesoContingencia(claveGenerada));
					   }else{
						   retorno.append(claveGenerada);   
					   }
					   break;
				   }
			   }
		   }else{
			   retorno.append("no tenemos registro de esa sucursal");
		   }  
	   }		  	  
	return retorno.toString();   
   }
   public String regenerarClaveAccesoContingencia(@Pattern(regexp = "[0-9]{49,49}")String claveAccesoNormal){
	   return generadorReal.generarClaveAccesoContingencia(claveAccesoNormal);
   }
}