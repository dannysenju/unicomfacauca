/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicomfacauca.demo.service;

import com.unicomfacauca.demo.domain.entities.DetalleMatricula;
import com.unicomfacauca.demo.domain.entities.DetalleMatriculaPK;
import com.unicomfacauca.demo.domain.entities.Matricula;
import com.unicomfacauca.demo.domain.entities.dto.HorarioMatDTO;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author danny
 */
@Stateless
public class MatriculaEJB {

    @PersistenceContext
    private EntityManager em;

    public List<Matricula> getAllAvailableEnrollment() {
        return em.createNamedQuery("Matricula.findAll", Matricula.class).getResultList();
    }

    public boolean save(Matricula m, List<HorarioMatDTO> materias) {
        em.persist(m);
        Matricula mTest = getMatriculaByCode(m.getNumeroMatricula());
        for (HorarioMatDTO materia : materias) {
            DetalleMatriculaPK dpk = new DetalleMatriculaPK(mTest.getIdmatricula(), materia.getMateria().getIdmateria());
            DetalleMatricula dm = new DetalleMatricula();
            dm.setDetalleMatriculaPK(dpk);
            dm.setIdprograma(mTest.getIdestudiante().getIdprograma());
            dm.setMateria(materia.getMateria());
            dm.setMatricula(mTest);
            dm.setNumeroCreditos(materia.getMateria().getNumeroCreditos());
            em.persist(dm);
        }

        int countIns = 0;
        for (HorarioMatDTO materia : materias) {
            countIns += isCreateMatricula(mTest.getIdmatricula(), materia.getMateria().getIdmateria());
        }
        return countIns == materias.size();
    }

    public Matricula getMatriculaByCode(String num) {
        return em.createNamedQuery("Matricula.findByNumeroMatricula", Matricula.class).setParameter("numeroMatricula", num).getSingleResult();
    }

    public int isCreateMatricula(int idMatricula, int idMateria) {

        Query q = em.createQuery("Select COUNT(dm.detalleMatriculaPK.idmatricula) from DetalleMatricula dm where dm.detalleMatriculaPK.idmateria = :idmateria and dm.detalleMatriculaPK.idmatricula= :idmatricula ");

        q.setParameter("idmateria", idMateria);
        q.setParameter("idmatricula", idMatricula);

        return ((Number) q.getSingleResult()).intValue();
    }

}
