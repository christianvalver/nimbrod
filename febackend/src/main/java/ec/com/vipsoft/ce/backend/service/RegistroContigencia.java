/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.vipsoft.ce.backend.service;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.com.vipsoft.ce.backend.model.CalendarioIndisponibilidad;
import ec.com.vipsoft.ce.backend.model.Contingencia;
import ec.com.vipsoft.ce.backend.model.Entidad;


/**
 *
 * @author chrisvv
 */
@Stateless
@WebService
public class RegistroContigencia {

    @PersistenceContext
    private EntityManager em;
    public void registrarNuevoAutorizacionContingencia(String numeroEnTexto,Entidad entidad) {
        Contingencia nc=new Contingencia();
        nc.setId(numeroEnTexto.trim());
        nc.setUsado(false);
        nc.setFechaUso(null);
        nc.setEntidad(entidad);
        em.persist(nc);
    }
    
    

    public void registrarPeriodoIndisponible(String fechaInicio,String fechaFinal,Entidad e){
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy HH:mm");
        
        try {
            Date fechaF=sdf.parse(fechaFinal);
            Date fechaI=sdf.parse(fechaInicio);
            if(fechaF.after(fechaI)){
                 CalendarioIndisponibilidad ci=new CalendarioIndisponibilidad();
                 ci.setFechaFinal(fechaF);
                 ci.setFechaInicial(fechaI);
                 ci.setEntidad(e);
                 em.persist(ci);
            }
        } catch (ParseException ex) {
            Logger.getLogger(RegistroContigencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }


}
