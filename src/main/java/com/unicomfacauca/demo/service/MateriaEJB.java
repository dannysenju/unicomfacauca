/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicomfacauca.demo.service;

import com.unicomfacauca.demo.domain.entities.Estudiante;
import com.unicomfacauca.demo.domain.entities.Materia;
import com.unicomfacauca.demo.domain.entities.Programa;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author danny
 */
@Stateless
public class MateriaEJB {

    @PersistenceContext
    private EntityManager em;

    public List<Materia> getAllAvailableCourses() {
        return em.createNamedQuery("Materia.findAll", Materia.class).getResultList();
    }

    public Materia getCourseByID(Integer id) {
        return em.createNamedQuery("Materia.findByIdmateria", Materia.class).setParameter("idmateria", id).getSingleResult();
    }
    public List<Materia> getAllCourseByProgram(Programa p) {
        return em.createQuery("select m from Materia m where m.idprograma = :programa", Materia.class).setParameter("programa", p).getResultList();
    }

}
