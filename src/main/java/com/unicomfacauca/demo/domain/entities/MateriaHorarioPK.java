/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicomfacauca.demo.domain.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author danny
 */
@Embeddable
public class MateriaHorarioPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "idmateria")
    private int idmateria;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idhorario_ini")
    private int idhorarioIni;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idhorario_fin")
    private int idhorarioFin;

    public MateriaHorarioPK() {
    }

    public MateriaHorarioPK(int idmateria, int idhorarioIni, int idhorarioFin) {
        this.idmateria = idmateria;
        this.idhorarioIni = idhorarioIni;
        this.idhorarioFin = idhorarioFin;
    }

    public int getIdmateria() {
        return idmateria;
    }

    public void setIdmateria(int idmateria) {
        this.idmateria = idmateria;
    }

    public int getIdhorarioIni() {
        return idhorarioIni;
    }

    public void setIdhorarioIni(int idhorarioIni) {
        this.idhorarioIni = idhorarioIni;
    }

    public int getIdhorarioFin() {
        return idhorarioFin;
    }

    public void setIdhorarioFin(int idhorarioFin) {
        this.idhorarioFin = idhorarioFin;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idmateria;
        hash += (int) idhorarioIni;
        hash += (int) idhorarioFin;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MateriaHorarioPK)) {
            return false;
        }
        MateriaHorarioPK other = (MateriaHorarioPK) object;
        if (this.idmateria != other.idmateria) {
            return false;
        }
        if (this.idhorarioIni != other.idhorarioIni) {
            return false;
        }
        if (this.idhorarioFin != other.idhorarioFin) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.unicomfacauca.demo.domain.entities.MateriaHorarioPK[ idmateria=" + idmateria + ", idhorarioIni=" + idhorarioIni + ", idhorarioFin=" + idhorarioFin + " ]";
    }
    
}
