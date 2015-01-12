/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.vipsoft.ce.backend.service;


import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.com.vipsoft.ce.backend.model.CalendarioIndisponibilidad;
import ec.com.vipsoft.ce.backend.model.Contingencia;
import ec.com.vipsoft.ce.backend.model.Entidad;

/**
 *
 * @author chrisvv
 */
@Stateless
public class AdministradorContingencia {
    @PersistenceContext
    EntityManager em;
    @Schedule(dayOfMonth = "*",dayOfWeek = "*", hour = "*",minute = "*",year = "*",second="0",persistent=true)
    public void verificarFinIndisponibilidadRegistrada(){
        LOG.info("verificando indisponiblidad registrada");
        Query q=em.createQuery("select c from CalendarioIndisponibilidad c where c.terminado=1");
        
        List<CalendarioIndisponibilidad>listado=q.getResultList();
        if(!listado.isEmpty()){
            for(CalendarioIndisponibilidad c:listado){                
                Date ahora=new Date();
                if((c.getFechaInicial().before(ahora))&&(c.getFechaFinal().before(ahora))){
                    CalendarioIndisponibilidad d=em.find(CalendarioIndisponibilidad.class,c.getId());
                    d.setTerminado(1);
                }
            }
            
        }                
    }
    private static final Logger LOG = Logger.getLogger(AdministradorContingencia.class.getName());
    public boolean estamosEnContingenciaProgramada() {
        boolean retorno = false;
        Query q = em.createQuery("select c from CalendarioIndisponibilidad c where c.terminado=false");
        List<CalendarioIndisponibilidad> listado = q.getResultList();
        if (!listado.isEmpty()) {
            for (CalendarioIndisponibilidad c : listado) {
                Date ahora = new Date();
                if ((c.getFechaInicial().before(ahora)) && (c.getFechaFinal().after(ahora))) {
                    retorno=true;
                }
            }
        }
        return retorno;
    }
    public String siguienteAutoriziacionContigencia(Entidad e){
        String retorno=null;
        Query q=em.createQuery("select c from Contigencia c where c.entidad.id=?1 and c.usado=?2");
        q.setMaxResults(1);
        q.setParameter(1, e.getId());
        q.setParameter(2, Boolean.FALSE);
        List<Contingencia>listaAutorizacionContingencia=q.getResultList();        
        return retorno;
    }
}
