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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "USUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findByIdUsuario", query = "SELECT u FROM Usuario u WHERE u.idUsuario = :idUsuario")
    , @NamedQuery(name = "Usuario.findByNombreUsuario", query = "SELECT u FROM Usuario u WHERE u.nombreUsuario = :nombreUsuario")
    , @NamedQuery(name = "Usuario.findByApellidoUsuario", query = "SELECT u FROM Usuario u WHERE u.apellidoUsuario = :apellidoUsuario")
    , @NamedQuery(name = "Usuario.findByAliasUsuario", query = "SELECT u FROM Usuario u WHERE u.aliasUsuario = :aliasUsuario")
    , @NamedQuery(name = "Usuario.findByCorreoUsuario", query = "SELECT u FROM Usuario u WHERE u.correoUsuario = :correoUsuario")
    , @NamedQuery(name = "Usuario.findBySexoUsuario", query = "SELECT u FROM Usuario u WHERE u.sexoUsuario = :sexoUsuario")
    , @NamedQuery(name = "Usuario.findByTelefonoUsuario", query = "SELECT u FROM Usuario u WHERE u.telefonoUsuario = :telefonoUsuario")
    , @NamedQuery(name = "Usuario.findByFechaRegistroUsuario", query = "SELECT u FROM Usuario u WHERE u.fechaRegistroUsuario = :fechaRegistroUsuario")
    , @NamedQuery(name = "Usuario.findByFechaNacimientoUsuario", query = "SELECT u FROM Usuario u WHERE u.fechaNacimientoUsuario = :fechaNacimientoUsuario")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_USUARIO")
    private Integer idUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1024)
    @Column(name = "NOMBRE_USUARIO")
    private String nombreUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1024)
    @Column(name = "APELLIDO_USUARIO")
    private String apellidoUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1024)
    @Column(name = "ALIAS_USUARIO")
    private String aliasUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1024)
    @Column(name = "CORREO_USUARIO")
    private String correoUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1024)
    @Column(name = "SEXO_USUARIO")
    private String sexoUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1024)
    @Column(name = "TELEFONO_USUARIO")
    private String telefonoUsuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_REGISTRO_USUARIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistroUsuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_NACIMIENTO_USUARIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaNacimientoUsuario;
    @JoinTable(name = "USUARIO_PERFIL", joinColumns = {
        @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO")}, inverseJoinColumns = {
        @JoinColumn(name = "ID_PERFIL", referencedColumnName = "ID_PERFIL")})
    @ManyToMany
    private Collection<Perfil> perfilCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "usuario")
    private Autenticacion autenticacion;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "usuario")
    private VisibilidadInformacion visibilidadInformacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    private Collection<Amigos> amigosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario1")
    private Collection<Amigos> amigosCollection1;
    @OneToMany(mappedBy = "idUsuario")
    private Collection<Interes> interesCollection;

    public Usuario() {
    }

    public Usuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario(Integer idUsuario, String nombreUsuario, String apellidoUsuario, String aliasUsuario, String correoUsuario, String sexoUsuario, String telefonoUsuario, Date fechaRegistroUsuario, Date fechaNacimientoUsuario) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.apellidoUsuario = apellidoUsuario;
        this.aliasUsuario = aliasUsuario;
        this.correoUsuario = correoUsuario;
        this.sexoUsuario = sexoUsuario;
        this.telefonoUsuario = telefonoUsuario;
        this.fechaRegistroUsuario = fechaRegistroUsuario;
        this.fechaNacimientoUsuario = fechaNacimientoUsuario;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellidoUsuario() {
        return apellidoUsuario;
    }

    public void setApellidoUsuario(String apellidoUsuario) {
        this.apellidoUsuario = apellidoUsuario;
    }

    public String getAliasUsuario() {
        return aliasUsuario;
    }

    public void setAliasUsuario(String aliasUsuario) {
        this.aliasUsuario = aliasUsuario;
    }

    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    public String getSexoUsuario() {
        return sexoUsuario;
    }

    public void setSexoUsuario(String sexoUsuario) {
        this.sexoUsuario = sexoUsuario;
    }

    public String getTelefonoUsuario() {
        return telefonoUsuario;
    }

    public void setTelefonoUsuario(String telefonoUsuario) {
        this.telefonoUsuario = telefonoUsuario;
    }

    public Date getFechaRegistroUsuario() {
        return fechaRegistroUsuario;
    }

    public void setFechaRegistroUsuario(Date fechaRegistroUsuario) {
        this.fechaRegistroUsuario = fechaRegistroUsuario;
    }

    public Date getFechaNacimientoUsuario() {
        return fechaNacimientoUsuario;
    }

    public void setFechaNacimientoUsuario(Date fechaNacimientoUsuario) {
        this.fechaNacimientoUsuario = fechaNacimientoUsuario;
    }

    @XmlTransient
    public Collection<Perfil> getPerfilCollection() {
        return perfilCollection;
    }

    public void setPerfilCollection(Collection<Perfil> perfilCollection) {
        this.perfilCollection = perfilCollection;
    }

    public Autenticacion getAutenticacion() {
        return autenticacion;
    }

    public void setAutenticacion(Autenticacion autenticacion) {
        this.autenticacion = autenticacion;
    }

    public VisibilidadInformacion getVisibilidadInformacion() {
        return visibilidadInformacion;
    }

    public void setVisibilidadInformacion(VisibilidadInformacion visibilidadInformacion) {
        this.visibilidadInformacion = visibilidadInformacion;
    }

    @XmlTransient
    public Collection<Amigos> getAmigosCollection() {
        return amigosCollection;
    }

    public void setAmigosCollection(Collection<Amigos> amigosCollection) {
        this.amigosCollection = amigosCollection;
    }

    @XmlTransient
    public Collection<Amigos> getAmigosCollection1() {
        return amigosCollection1;
    }

    public void setAmigosCollection1(Collection<Amigos> amigosCollection1) {
        this.amigosCollection1 = amigosCollection1;
    }

    @XmlTransient
    public Collection<Interes> getInteresCollection() {
        return interesCollection;
    }

    public void setInteresCollection(Collection<Interes> interesCollection) {
        this.interesCollection = interesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DataAccess.Entity.Usuario[ idUsuario=" + idUsuario + " ]";
    }
    
}
