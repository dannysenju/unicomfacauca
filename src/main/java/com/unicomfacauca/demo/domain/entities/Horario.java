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
@Table(name = "horario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Horario.findAll", query = "SELECT h FROM Horario h")
    , @NamedQuery(name = "Horario.findByIdhorario", query = "SELECT h FROM Horario h WHERE h.idhorario = :idhorario")
    , @NamedQuery(name = "Horario.findByBloqueHorario", query = "SELECT h FROM Horario h WHERE h.bloqueHorario = :bloqueHorario")
    , @NamedQuery(name = "Horario.findByDiaSemana", query = "SELECT h FROM Horario h WHERE h.diaSemana = :diaSemana")})
public class Horario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "schedule_seq")
    @SequenceGenerator(name = "schedule_seq", sequenceName = "schedule_seq",  initialValue = 40, allocationSize = 100)
    @NotNull
    @Column(name = "idhorario")
    private Integer idhorario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "bloque_horario")
    private String bloqueHorario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "dia_semana")
    private String diaSemana;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "horario", fetch = FetchType.EAGER)
    private List<MateriaHorario> materiaHorarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "horario1", fetch = FetchType.EAGER)
    private List<MateriaHorario> materiaHorarioList1;

    public Horario() {
    }

    public Horario(Integer idhorario) {
        this.idhorario = idhorario;
    }

    public Horario(Integer idhorario, String bloqueHorario, String diaSemana) {
        this.idhorario = idhorario;
        this.bloqueHorario = bloqueHorario;
        this.diaSemana = diaSemana;
    }

    public Integer getIdhorario() {
        return idhorario;
    }

    public void setIdhorario(Integer idhorario) {
        this.idhorario = idhorario;
    }

    public String getBloqueHorario() {
        return bloqueHorario;
    }

    public void setBloqueHorario(String bloqueHorario) {
        this.bloqueHorario = bloqueHorario;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    @XmlTransient
    public List<MateriaHorario> getMateriaHorarioList() {
        return materiaHorarioList;
    }

    public void setMateriaHorarioList(List<MateriaHorario> materiaHorarioList) {
        this.materiaHorarioList = materiaHorarioList;
    }

    @XmlTransient
    public List<MateriaHorario> getMateriaHorarioList1() {
        return materiaHorarioList1;
    }

    public void setMateriaHorarioList1(List<MateriaHorario> materiaHorarioList1) {
        this.materiaHorarioList1 = materiaHorarioList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idhorario != null ? idhorario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Horario)) {
            return false;
        }
        Horario other = (Horario) object;
        if ((this.idhorario == null && other.idhorario != null) || (this.idhorario != null && !this.idhorario.equals(other.idhorario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.unicomfacauca.demo.domain.entities.Horario[ idhorario=" + idhorario + " ]";
    }
    
}
