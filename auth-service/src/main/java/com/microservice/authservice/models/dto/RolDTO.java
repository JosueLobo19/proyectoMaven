package com.microservice.authservice.models.dto;

import com.microservice.authservice.models.entity.UsuarioRol;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
public class RolDTO {
    private long idRol;

    private String nombre;

    private Date fechaRegistro;

    private Boolean estado;


    private Set<UsuarioRol> usuarioRol=new HashSet<>();


    public long getIdRol() {
        return idRol;
    }


    public void setIdRol(long idRol) {
        this.idRol = idRol;
    }





    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public Date getFechaRegistro() {
        return fechaRegistro;
    }


    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }


    public Boolean getEstado() {
        return estado;
    }


    public void setEstado(Boolean estado) {
        this.estado = estado;
    }


    public Set<UsuarioRol> getUsuarioRol() {
        return usuarioRol;
    }


    public void setUsuarioRol(Set<UsuarioRol> usuarioRol) {
        this.usuarioRol = usuarioRol;
    }


    public RolDTO() {
        super();
    }

}
