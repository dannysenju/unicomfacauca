/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicomfacauca.demo.service;

import com.unicomfacauca.demo.domain.entities.Estudiante;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author danny
 */
@Stateless
public class EstudianteEJB {

    @PersistenceContext
    private EntityManager em;

    public List<Estudiante> getAllAvailableStudents() {
        return em.createNamedQuery("Estudiante.findAll", Estudiante.class).getResultList();
    }

}
