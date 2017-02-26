/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author snrivera
 */
@Entity
@Table(name = "funcionalidad", catalog = "Red", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Funcionalidad.findAll", query = "SELECT f FROM Funcionalidad f")
    , @NamedQuery(name = "Funcionalidad.findByIdFuncionalidad", query = "SELECT f FROM Funcionalidad f WHERE f.idFuncionalidad = :idFuncionalidad")
    , @NamedQuery(name = "Funcionalidad.findByDescripcionFuncionalidad", query = "SELECT f FROM Funcionalidad f WHERE f.descripcionFuncionalidad = :descripcionFuncionalidad")
    , @NamedQuery(name = "Funcionalidad.findByFechaRegFuncionalidad", query = "SELECT f FROM Funcionalidad f WHERE f.fechaRegFuncionalidad = :fechaRegFuncionalidad")})
public class Funcionalidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_FUNCIONALIDAD")
    private Integer idFuncionalidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1024)
    @Column(name = "DESCRIPCION_FUNCIONALIDAD")
    private String descripcionFuncionalidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_REG_FUNCIONALIDAD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegFuncionalidad;
    @ManyToMany(mappedBy = "funcionalidadCollection")
    private Collection<Perfil> perfilCollection;

    public Funcionalidad() {
    }

    public Funcionalidad(Integer idFuncionalidad) {
        this.idFuncionalidad = idFuncionalidad;
    }

    public Funcionalidad(Integer idFuncionalidad, String descripcionFuncionalidad, Date fechaRegFuncionalidad) {
        this.idFuncionalidad = idFuncionalidad;
        this.descripcionFuncionalidad = descripcionFuncionalidad;
        this.fechaRegFuncionalidad = fechaRegFuncionalidad;
    }

    public Integer getIdFuncionalidad() {
        return idFuncionalidad;
    }

    public void setIdFuncionalidad(Integer idFuncionalidad) {
        this.idFuncionalidad = idFuncionalidad;
    }

    public String getDescripcionFuncionalidad() {
        return descripcionFuncionalidad;
    }

    public void setDescripcionFuncionalidad(String descripcionFuncionalidad) {
        this.descripcionFuncionalidad = descripcionFuncionalidad;
    }

    public Date getFechaRegFuncionalidad() {
        return fechaRegFuncionalidad;
    }

    public void setFechaRegFuncionalidad(Date fechaRegFuncionalidad) {
        this.fechaRegFuncionalidad = fechaRegFuncionalidad;
    }

    @XmlTransient
    public Collection<Perfil> getPerfilCollection() {
        return perfilCollection;
    }

    public void setPerfilCollection(Collection<Perfil> perfilCollection) {
        this.perfilCollection = perfilCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFuncionalidad != null ? idFuncionalidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funcionalidad)) {
            return false;
        }
        Funcionalidad other = (Funcionalidad) object;
        if ((this.idFuncionalidad == null && other.idFuncionalidad != null) || (this.idFuncionalidad != null && !this.idFuncionalidad.equals(other.idFuncionalidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Funcionalidad[ idFuncionalidad=" + idFuncionalidad + " ]";
    }
    
}
