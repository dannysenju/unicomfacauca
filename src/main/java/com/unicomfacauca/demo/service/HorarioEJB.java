/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicomfacauca.demo.service;

import com.unicomfacauca.demo.domain.entities.Horario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author danny
 */
@Stateless
public class HorarioEJB {

    @PersistenceContext
    private EntityManager em;

    public List<Horario> getAllAvailableSchedule() {
        return em.createNamedQuery("\"Horario.findAll", Horario.class).getResultList();
    }

}
