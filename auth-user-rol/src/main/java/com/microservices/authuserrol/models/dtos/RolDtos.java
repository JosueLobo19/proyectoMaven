package com.microservices.authuserrol.models.dtos;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;


public class RolDtos {
    private long idRol;

    private String nombre;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaRegistro;

    private Boolean estado;


   // private Set<UsuarioRol> usuarioRol=new HashSet<>();


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


    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }


    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }


    public Boolean getEstado() {
        return estado;
    }


    public void setEstado(Boolean estado) {
        this.estado = estado;
    }


    public RolDtos() {
        super();
    }
}
