/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicomfacauca.demo.domain.entities.dto;

import com.unicomfacauca.demo.domain.entities.Horario;
import com.unicomfacauca.demo.domain.entities.Materia;

/**
 *
 * @author danny
 */
public class HorarioMatDTO {
    
    private Horario horarioIni;
    private Horario horarioFin;
    private Materia materia;

    public Horario getHorarioIni() {
        return horarioIni;
    }

    public void setHorarioIni(Horario horarioIni) {
        this.horarioIni = horarioIni;
    }

    public Horario getHorarioFin() {
        return horarioFin;
    }

    public void setHorarioFin(Horario horarioFin) {
        this.horarioFin = horarioFin;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    
}
