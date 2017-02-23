/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.Entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
 * @author arqsoft2017i
 */
@Entity
@Table(name = "PERFIL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Perfil.findAll", query = "SELECT p FROM Perfil p")
    , @NamedQuery(name = "Perfil.findByIdPerfil", query = "SELECT p FROM Perfil p WHERE p.idPerfil = :idPerfil")
    , @NamedQuery(name = "Perfil.findByDescripcionPerfil", query = "SELECT p FROM Perfil p WHERE p.descripcionPerfil = :descripcionPerfil")
    , @NamedQuery(name = "Perfil.findByFechaRegistroPerfil", query = "SELECT p FROM Perfil p WHERE p.fechaRegistroPerfil = :fechaRegistroPerfil")})
public class Perfil implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PERFIL")
    private Integer idPerfil;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1024)
    @Column(name = "DESCRIPCION_PERFIL")
    private String descripcionPerfil;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_REGISTRO_PERFIL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistroPerfil;
    @ManyToMany(mappedBy = "perfilCollection")
    private Collection<Usuario> usuarioCollection;
    @JoinTable(name = "PERFIL_FUNCIONALIDAD", joinColumns = {
        @JoinColumn(name = "ID_PERFIL", referencedColumnName = "ID_PERFIL")}, inverseJoinColumns = {
        @JoinColumn(name = "ID_FUNCIONALIDAD", referencedColumnName = "ID_FUNCIONALIDAD")})
    @ManyToMany
    private Collection<Funcionalidad> funcionalidadCollection;

    public Perfil() {
    }

    public Perfil(Integer idPerfil) {
        this.idPerfil = idPerfil;
    }

    public Perfil(Integer idPerfil, String descripcionPerfil, Date fechaRegistroPerfil) {
        this.idPerfil = idPerfil;
        this.descripcionPerfil = descripcionPerfil;
        this.fechaRegistroPerfil = fechaRegistroPerfil;
    }

    public Integer getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(Integer idPerfil) {
        this.idPerfil = idPerfil;
    }

    public String getDescripcionPerfil() {
        return descripcionPerfil;
    }

    public void setDescripcionPerfil(String descripcionPerfil) {
        this.descripcionPerfil = descripcionPerfil;
    }

    public Date getFechaRegistroPerfil() {
        return fechaRegistroPerfil;
    }

    public void setFechaRegistroPerfil(Date fechaRegistroPerfil) {
        this.fechaRegistroPerfil = fechaRegistroPerfil;
    }

    @XmlTransient
    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    @XmlTransient
    public Collection<Funcionalidad> getFuncionalidadCollection() {
        return funcionalidadCollection;
    }

    public void setFuncionalidadCollection(Collection<Funcionalidad> funcionalidadCollection) {
        this.funcionalidadCollection = funcionalidadCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPerfil != null ? idPerfil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Perfil)) {
            return false;
        }
        Perfil other = (Perfil) object;
        if ((this.idPerfil == null && other.idPerfil != null) || (this.idPerfil != null && !this.idPerfil.equals(other.idPerfil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DataAccess.Entity.Perfil[ idPerfil=" + idPerfil + " ]";
    }
    
}
