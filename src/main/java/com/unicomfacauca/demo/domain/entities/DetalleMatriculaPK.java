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
public class DetalleMatriculaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "idmatricula")
    private int idmatricula;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idmateria")
    private int idmateria;

    public DetalleMatriculaPK() {
    }

    public DetalleMatriculaPK(int idmatricula, int idmateria) {
        this.idmatricula = idmatricula;
        this.idmateria = idmateria;
    }

    public int getIdmatricula() {
        return idmatricula;
    }

    public void setIdmatricula(int idmatricula) {
        this.idmatricula = idmatricula;
    }

    public int getIdmateria() {
        return idmateria;
    }

    public void setIdmateria(int idmateria) {
        this.idmateria = idmateria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idmatricula;
        hash += (int) idmateria;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleMatriculaPK)) {
            return false;
        }
        DetalleMatriculaPK other = (DetalleMatriculaPK) object;
        if (this.idmatricula != other.idmatricula) {
            return false;
        }
        if (this.idmateria != other.idmateria) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.unicomfacauca.demo.domain.entities.DetalleMatriculaPK[ idmatricula=" + idmatricula + ", idmateria=" + idmateria + " ]";
    }
    
}
