package com.microservices.authuserrol.models.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "usuario_rol")
public class UsuarioRol implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user_rol")
    private long idUserRol;

    private Boolean estado;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_registro")
    private Date fechaRegistro;

    @Column(name ="user_registro",length = 18)
    private String userRegistro;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_upt")
    private Date fechaUpt;

    @Column(name ="user_upt",length = 18)
    private String userUpt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user", nullable = false)
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_rol", nullable = false)
    private Rol rol;

    public long getIdUserRol() {
        return idUserRol;
    }

    public void setIdUserRol(long idUserRol) {
        this.idUserRol = idUserRol;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getUserRegistro() {
        return userRegistro;
    }

    public void setUserRegistro(String userRegistro) {
        this.userRegistro = userRegistro;
    }

    public Date getFechaUpt() {
        return fechaUpt;
    }

    public void setFechaUpt(Date fechaUpt) {
        this.fechaUpt = fechaUpt;
    }

    public String getUserUpt() {
        return userUpt;
    }

    public void setUserUpt(String userUpt) {
        this.userUpt = userUpt;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public UsuarioRol() {
        super();
    }

}
