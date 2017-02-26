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

/**
 *
 * @author snrivera
 */
@Embeddable
public class AmigosPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "USU_ID_USUARIO")
    private int usuIdUsuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_USUARIO")
    private int idUsuario;

    public AmigosPK() {
    }

    public AmigosPK(int usuIdUsuario, int idUsuario) {
        this.usuIdUsuario = usuIdUsuario;
        this.idUsuario = idUsuario;
    }

    public int getUsuIdUsuario() {
        return usuIdUsuario;
    }

    public void setUsuIdUsuario(int usuIdUsuario) {
        this.usuIdUsuario = usuIdUsuario;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) usuIdUsuario;
        hash += (int) idUsuario;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AmigosPK)) {
            return false;
        }
        AmigosPK other = (AmigosPK) object;
        if (this.usuIdUsuario != other.usuIdUsuario) {
            return false;
        }
        if (this.idUsuario != other.idUsuario) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.AmigosPK[ usuIdUsuario=" + usuIdUsuario + ", idUsuario=" + idUsuario + " ]";
    }
    
}
