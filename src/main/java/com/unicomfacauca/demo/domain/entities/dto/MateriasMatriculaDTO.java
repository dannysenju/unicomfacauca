/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicomfacauca.demo.domain.entities.dto;

import com.unicomfacauca.demo.domain.entities.Matricula;

/**
 *
 * @author danny
 */
public class MateriasMatriculaDTO {

    private static final long serialVersionUID = 1L;

    private Matricula matricula;
    private HorarioMatDTO matDTo;

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    public HorarioMatDTO getMatDTo() {
        return matDTo;
    }

    public void setMatDTo(HorarioMatDTO matDTo) {
        this.matDTo = matDTo;
    }

    

}
