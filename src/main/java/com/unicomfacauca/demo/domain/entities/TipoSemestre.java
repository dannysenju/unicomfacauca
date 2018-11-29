/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicomfacauca.demo.domain.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "tipo_semestre")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoSemestre.findAll", query = "SELECT t FROM TipoSemestre t")
    , @NamedQuery(name = "TipoSemestre.findByIdtipoSemestre", query = "SELECT t FROM TipoSemestre t WHERE t.idtipoSemestre = :idtipoSemestre")
    , @NamedQuery(name = "TipoSemestre.findByNumeroCreditos", query = "SELECT t FROM TipoSemestre t WHERE t.numeroCreditos = :numeroCreditos")
    , @NamedQuery(name = "TipoSemestre.findByActivo", query = "SELECT t FROM TipoSemestre t WHERE t.activo = :activo")})
public class TipoSemestre implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idtipo_semestre")
    private Integer idtipoSemestre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_creditos")
    private int numeroCreditos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "activo")
    private String activo;
    @OneToMany(mappedBy = "idtipoSemestre", fetch = FetchType.EAGER)
    private List<Programa> programaList;

    public TipoSemestre() {
    }

    public TipoSemestre(Integer idtipoSemestre) {
        this.idtipoSemestre = idtipoSemestre;
    }

    public TipoSemestre(Integer idtipoSemestre, int numeroCreditos, String activo) {
        this.idtipoSemestre = idtipoSemestre;
        this.numeroCreditos = numeroCreditos;
        this.activo = activo;
    }

    public Integer getIdtipoSemestre() {
        return idtipoSemestre;
    }

    public void setIdtipoSemestre(Integer idtipoSemestre) {
        this.idtipoSemestre = idtipoSemestre;
    }

    public int getNumeroCreditos() {
        return numeroCreditos;
    }

    public void setNumeroCreditos(int numeroCreditos) {
        this.numeroCreditos = numeroCreditos;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    @XmlTransient
    public List<Programa> getProgramaList() {
        return programaList;
    }

    public void setProgramaList(List<Programa> programaList) {
        this.programaList = programaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipoSemestre != null ? idtipoSemestre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoSemestre)) {
            return false;
        }
        TipoSemestre other = (TipoSemestre) object;
        if ((this.idtipoSemestre == null && other.idtipoSemestre != null) || (this.idtipoSemestre != null && !this.idtipoSemestre.equals(other.idtipoSemestre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.unicomfacauca.demo.domain.entities.TipoSemestre[ idtipoSemestre=" + idtipoSemestre + " ]";
    }
    
}
