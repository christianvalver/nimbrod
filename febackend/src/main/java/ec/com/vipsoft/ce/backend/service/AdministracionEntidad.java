package ec.com.vipsoft.ce.backend.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.com.vipsoft.ce.backend.model.Entidad;
import ec.com.vipsoft.ce.backend.model.PuntoEmision;
import ec.com.vipsoft.ce.backend.model.Sucursal;

@Stateless
@WebService
public class AdministracionEntidad {
	@PersistenceContext
	EntityManager em;
	
	public void registrarEntidad(String password,Entidad entidad){
		String elpassword=new String("mariateniauncorderito");
		if(password.equalsIgnoreCase(elpassword)){
			em.persist(entidad);			
		}
	}
	public void establecerSucursal(String password,String rucEntidad,Integer numeroSucursal,String direccion,Integer cuantosPuntosDeEmision){
		String elpassword=new String("mariateniauncorderito");
		if(password.equalsIgnoreCase(elpassword)){
			Query qentidad=em.createQuery("select e from Entidad e where e.ruc=?1");
			qentidad.setParameter(1, rucEntidad);
			List<Entidad>listaEntidad=qentidad.getResultList();
			if(!listaEntidad.isEmpty()){
				Entidad e=em.find(Entidad.class, listaEntidad.get(0).getId());
				Sucursal sucursal=new Sucursal();
				sucursal.setNumeroSucursal(numeroSucursal);
				sucursal.setEntidad(e);
				sucursal.setDireccion(direccion);
				for(int i=0;i<cuantosPuntosDeEmision;i++){
					sucursal.getPuntosEmision().add(new PuntoEmision());	
				}
				em.persist(sucursal);				
			}			
		}
	}

	public void establecerSecuenciaFactura(String rucEntidad,Integer numeroSucursal, Long numeroPuntoVenta,	Integer secuenciaFactura) {

		Query qentidad = em.createQuery("select e from Entidad e where e.ruc=?1");
		qentidad.setParameter(1, rucEntidad);
		List<Entidad> listaEntidad = qentidad.getResultList();
		if (!listaEntidad.isEmpty()) {
			Entidad e = em.find(Entidad.class, listaEntidad.get(0).getId());
			Query qsucursal = em.createQuery("select s from Sucursal s where s.entidad.id=?1 and s.numeroSucursal=?2");
			qsucursal.setParameter(1, e.getId());
			qsucursal.setParameter(2, numeroSucursal);
			List<Sucursal> listaSucursal = qsucursal.getResultList();
			if (!listaSucursal.isEmpty()) {
				Sucursal sucursal=em.find(Sucursal.class, listaSucursal.get(0).getId());
				for(PuntoEmision pe:sucursal.getPuntosEmision()){
					if(pe.getId().equals(numeroPuntoVenta)){
						pe.setSecuenciaFactura(secuenciaFactura);
					}
				}
			}			 
		}

	}				
}
