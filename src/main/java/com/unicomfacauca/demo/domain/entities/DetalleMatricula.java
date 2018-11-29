/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicomfacauca.demo.domain.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author danny
 */
@Entity
@Table(name = "detalle_matricula")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleMatricula.findAll", query = "SELECT d FROM DetalleMatricula d")
    , @NamedQuery(name = "DetalleMatricula.findByIdmatricula", query = "SELECT d FROM DetalleMatricula d WHERE d.detalleMatriculaPK.idmatricula = :idmatricula")
    , @NamedQuery(name = "DetalleMatricula.findByIdmateria", query = "SELECT d FROM DetalleMatricula d WHERE d.detalleMatriculaPK.idmateria = :idmateria")
    , @NamedQuery(name = "DetalleMatricula.findByNumeroCreditos", query = "SELECT d FROM DetalleMatricula d WHERE d.numeroCreditos = :numeroCreditos")})
public class DetalleMatricula implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetalleMatriculaPK detalleMatriculaPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_creditos")
    private int numeroCreditos;
    @JoinColumn(name = "idmatricula", referencedColumnName = "idmatricula", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Matricula matricula;
    @JoinColumn(name = "idmateria", referencedColumnName = "idmateria", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Materia materia;
    @JoinColumn(name = "idprograma", referencedColumnName = "idprograma")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Programa idprograma;

    public DetalleMatricula() {
    }

    public DetalleMatricula(DetalleMatriculaPK detalleMatriculaPK) {
        this.detalleMatriculaPK = detalleMatriculaPK;
    }

    public DetalleMatricula(DetalleMatriculaPK detalleMatriculaPK, int numeroCreditos) {
        this.detalleMatriculaPK = detalleMatriculaPK;
        this.numeroCreditos = numeroCreditos;
    }

    public DetalleMatricula(int idmatricula, int idmateria) {
        this.detalleMatriculaPK = new DetalleMatriculaPK(idmatricula, idmateria);
    }

    public DetalleMatriculaPK getDetalleMatriculaPK() {
        return detalleMatriculaPK;
    }

    public void setDetalleMatriculaPK(DetalleMatriculaPK detalleMatriculaPK) {
        this.detalleMatriculaPK = detalleMatriculaPK;
    }

    public int getNumeroCreditos() {
        return numeroCreditos;
    }

    public void setNumeroCreditos(int numeroCreditos) {
        this.numeroCreditos = numeroCreditos;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public Programa getIdprograma() {
        return idprograma;
    }

    public void setIdprograma(Programa idprograma) {
        this.idprograma = idprograma;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detalleMatriculaPK != null ? detalleMatriculaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleMatricula)) {
            return false;
        }
        DetalleMatricula other = (DetalleMatricula) object;
        if ((this.detalleMatriculaPK == null && other.detalleMatriculaPK != null) || (this.detalleMatriculaPK != null && !this.detalleMatriculaPK.equals(other.detalleMatriculaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.unicomfacauca.demo.domain.entities.DetalleMatricula[ detalleMatriculaPK=" + detalleMatriculaPK + " ]";
    }
    
}
