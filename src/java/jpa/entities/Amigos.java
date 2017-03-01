/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author arqsoft2017i
 */
@Entity
@Table(name = "AMIGOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Amigos.findAll", query = "SELECT a FROM Amigos a")
    , @NamedQuery(name = "Amigos.findByUsuIdUsuario", query = "SELECT a FROM Amigos a WHERE a.amigosPK.usuIdUsuario = :usuIdUsuario")
    , @NamedQuery(name = "Amigos.findByIdUsuario", query = "SELECT a FROM Amigos a WHERE a.amigosPK.idUsuario = :idUsuario")
    , @NamedQuery(name = "Amigos.findByEstatusRelacion", query = "SELECT a FROM Amigos a WHERE a.estatusRelacion = :estatusRelacion")})
public class Amigos implements Serializable {

    private static final long serialVersionUID = 2L;
    @EmbeddedId
    protected AmigosPK amigosPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTATUS_RELACION")
    private int estatusRelacion;
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;
    @JoinColumn(name = "USU_ID_USUARIO", referencedColumnName = "ID_USUARIO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario1;

    public Amigos() {
    }

    public Amigos(AmigosPK amigosPK) {
        this.amigosPK = amigosPK;
    }

    public Amigos(AmigosPK amigosPK, int estatusRelacion) {
        this.amigosPK = amigosPK;
        this.estatusRelacion = estatusRelacion;
    }

    public Amigos(String usuIdUsuario, String idUsuario) {
        this.amigosPK = new AmigosPK(usuIdUsuario, idUsuario);
    }

    public AmigosPK getAmigosPK() {
        return amigosPK;
    }

    public void setAmigosPK(AmigosPK amigosPK) {
        this.amigosPK = amigosPK;
    }

    public int getEstatusRelacion() {
        return estatusRelacion;
    }

    public void setEstatusRelacion(int estatusRelacion) {
        this.estatusRelacion = estatusRelacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario1() {
        return usuario1;
    }

    public void setUsuario1(Usuario usuario1) {
        this.usuario1 = usuario1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (amigosPK != null ? amigosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Amigos)) {
            return false;
        }
        Amigos other = (Amigos) object;
        if ((this.amigosPK == null && other.amigosPK != null) || (this.amigosPK != null && !this.amigosPK.equals(other.amigosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Amigos[ amigosPK=" + amigosPK + " ]";
    }
    
}
