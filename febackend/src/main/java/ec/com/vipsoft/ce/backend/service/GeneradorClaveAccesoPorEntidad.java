package ec.com.vipsoft.ce.backend.service;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.com.vipsoft.ce.backend.model.Entidad;
import ec.com.vipsoft.ce.backend.model.PuntoEmision;
import ec.com.vipsoft.ce.backend.model.Sucursal;

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
  
   
   public String generarClaveAccesoRetencion(String ruc,Integer sucursal,Integer ptoEmision){
	   StringBuilder retorno=new StringBuilder();
	   Query q=em.createQuery("select e from Entidad e where e.ruc=?1");
	   q.setParameter(1, ruc);
	   List<Entidad>listadoEntidad=q.getResultList();
	   if(listadoEntidad.isEmpty()){
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
   
   public String generarClaveAccesoGuiaRemision(String ruc,Integer sucursal,Integer ptoEmision){
	   StringBuilder retorno=new StringBuilder();
	   Query q=em.createQuery("select e from Entidad e where e.ruc=?1");
	   q.setParameter(1, ruc);
	   List<Entidad>listadoEntidad=q.getResultList();
	   if(listadoEntidad.isEmpty()){
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
   public String generarClaveAccesoNotaCredito(String ruc,Integer sucursal,Integer ptoEmision){
	   StringBuilder retorno=new StringBuilder();
	   Query q=em.createQuery("select e from Entidad e where e.ruc=?1");
	   q.setParameter(1, ruc);
	   List<Entidad>listadoEntidad=q.getResultList();
	   if(listadoEntidad.isEmpty()){
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
   
   
   
   
   public String generarClaveAccesoNotaDebito(String ruc,Integer sucursal,Integer ptoEmision){
	   StringBuilder retorno=new StringBuilder();
	   Query q=em.createQuery("select e from Entidad e where e.ruc=?1");
	   q.setParameter(1, ruc);
	   List<Entidad>listadoEntidad=q.getResultList();
	   if(listadoEntidad.isEmpty()){
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
   public String generarClaveAccesoFactura(String ruc,Integer sucursal,Integer ptoEmision){
	   StringBuilder retorno=new StringBuilder();
	   Query q=em.createQuery("select e from Entidad e where e.ruc=?1");
	   q.setParameter(1, ruc);
	   List<Entidad>listadoEntidad=q.getResultList();
	   if(listadoEntidad.isEmpty()){
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
   public String regenerarClaveAccesoContingencia(String claveAccesoNormal){
	   return generadorReal.generarClaveAccesoContingencia(claveAccesoNormal);
   }
}