/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author arqsoft2017i
 */
@Embeddable
public class AmigosPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "USU_ID_USUARIO")
    private String usuIdUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "ID_USUARIO")
    private String idUsuario;

    public AmigosPK() {
    }

    public AmigosPK(String usuIdUsuario, String idUsuario) {
        this.usuIdUsuario = usuIdUsuario;
        this.idUsuario = idUsuario;
    }

    public String getUsuIdUsuario() {
        return usuIdUsuario;
    }

    public void setUsuIdUsuario(String usuIdUsuario) {
        this.usuIdUsuario = usuIdUsuario;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuIdUsuario != null ? usuIdUsuario.hashCode() : 0);
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AmigosPK)) {
            return false;
        }
        AmigosPK other = (AmigosPK) object;
        if ((this.usuIdUsuario == null && other.usuIdUsuario != null) || (this.usuIdUsuario != null && !this.usuIdUsuario.equals(other.usuIdUsuario))) {
            return false;
        }
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.AmigosPK[ usuIdUsuario=" + usuIdUsuario + ", idUsuario=" + idUsuario + " ]";
    }
    
}
