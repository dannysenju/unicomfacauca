/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicomfacauca.demo.domain.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author danny
 */
@Entity
@Table(name = "materia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Materia.findAll", query = "SELECT m FROM Materia m")
    , @NamedQuery(name = "Materia.findByIdmateria", query = "SELECT m FROM Materia m WHERE m.idmateria = :idmateria")
    , @NamedQuery(name = "Materia.findByNombre", query = "SELECT m FROM Materia m WHERE m.nombre = :nombre")
    , @NamedQuery(name = "Materia.findBySemestre", query = "SELECT m FROM Materia m WHERE m.semestre = :semestre")
    , @NamedQuery(name = "Materia.findByNumeroCreditos", query = "SELECT m FROM Materia m WHERE m.numeroCreditos = :numeroCreditos")
    , @NamedQuery(name = "Materia.findByIdprograma", query = "SELECT m FROM Materia m WHERE m.idprograma = :idprograma")})
public class Materia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "materia_seq")
    @SequenceGenerator(name = "materia_seq", sequenceName = "materia_seq",  initialValue = 40, allocationSize = 100)
    @NotNull
    @Column(name = "idmateria")
    private Integer idmateria;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "semestre")
    private int semestre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_creditos")
    private int numeroCreditos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idprograma")
    private int idprograma;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "materia")
    private List<DetalleMatricula> detalleMatriculaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "materia", fetch = FetchType.EAGER)
    private List<MateriaHorario> materiaHorarioList;

    public Materia() {
    }

    public Materia(Integer idmateria) {
        this.idmateria = idmateria;
    }

    public Materia(Integer idmateria, String nombre, int semestre, int numeroCreditos, int idprograma) {
        this.idmateria = idmateria;
        this.nombre = nombre;
        this.semestre = semestre;
        this.numeroCreditos = numeroCreditos;
        this.idprograma = idprograma;
    }

    public Integer getIdmateria() {
        return idmateria;
    }

    public void setIdmateria(Integer idmateria) {
        this.idmateria = idmateria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public int getNumeroCreditos() {
        return numeroCreditos;
    }

    public void setNumeroCreditos(int numeroCreditos) {
        this.numeroCreditos = numeroCreditos;
    }

    public int getIdprograma() {
        return idprograma;
    }

    public void setIdprograma(int idprograma) {
        this.idprograma = idprograma;
    }

    @XmlTransient
    public List<DetalleMatricula> getDetalleMatriculaList() {
        return detalleMatriculaList;
    }

    public void setDetalleMatriculaList(List<DetalleMatricula> detalleMatriculaList) {
        this.detalleMatriculaList = detalleMatriculaList;
    }

    @XmlTransient
    public List<MateriaHorario> getMateriaHorarioList() {
        return materiaHorarioList;
    }

    public void setMateriaHorarioList(List<MateriaHorario> materiaHorarioList) {
        this.materiaHorarioList = materiaHorarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmateria != null ? idmateria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Materia)) {
            return false;
        }
        Materia other = (Materia) object;
        if ((this.idmateria == null && other.idmateria != null) || (this.idmateria != null && !this.idmateria.equals(other.idmateria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.unicomfacauca.demo.domain.entities.Materia[ idmateria=" + idmateria + " ]";
    }
    
}
