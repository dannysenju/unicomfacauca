/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicomfacauca.demo.domain.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
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
    , @NamedQuery(name = "DetalleMatricula.findByIdmatricula", query = "SELECT d FROM DetalleMatricula d WHERE d.idmatricula = :idmatricula")
    , @NamedQuery(name = "DetalleMatricula.findByIdmateria", query = "SELECT d FROM DetalleMatricula d WHERE d.idmateria = :idmateria")
    , @NamedQuery(name = "DetalleMatricula.findByNumeroCreditos", query = "SELECT d FROM DetalleMatricula d WHERE d.numeroCreditos = :numeroCreditos")})
public class DetalleMatricula implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_creditos")
    private int numeroCreditos;
    @JoinColumn(name = "idprograma", referencedColumnName = "idprograma")
    @ManyToOne(optional = false)
    private Programa idprograma;
    @JoinColumn(name = "idmatricula", referencedColumnName = "idmatricula")
    @OneToOne(optional = false)
    private Matricula matricula;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idmatricula")
    private Integer idmatricula;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idmateria")
    private int idmateria;

    public DetalleMatricula() {
    }

    public DetalleMatricula(Integer idmatricula) {
        this.idmatricula = idmatricula;
    }

    public DetalleMatricula(Integer idmatricula, int idmateria, int numeroCreditos) {
        this.idmatricula = idmatricula;
        this.idmateria = idmateria;
        this.numeroCreditos = numeroCreditos;
    }

    public Integer getIdmatricula() {
        return idmatricula;
    }

    public void setIdmatricula(Integer idmatricula) {
        this.idmatricula = idmatricula;
    }

    public int getIdmateria() {
        return idmateria;
    }

    public void setIdmateria(int idmateria) {
        this.idmateria = idmateria;
    }

    public int getNumeroCreditos() {
        return numeroCreditos;
    }

    public void setNumeroCreditos(int numeroCreditos) {
        this.numeroCreditos = numeroCreditos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmatricula != null ? idmatricula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleMatricula)) {
            return false;
        }
        DetalleMatricula other = (DetalleMatricula) object;
        if ((this.idmatricula == null && other.idmatricula != null) || (this.idmatricula != null && !this.idmatricula.equals(other.idmatricula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.unicomfacauca.demo.domain.entities.DetalleMatricula[ idmatricula=" + idmatricula + " ]";
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    public Programa getIdprograma() {
        return idprograma;
    }

    public void setIdprograma(Programa idprograma) {
        this.idprograma = idprograma;
    }

}
