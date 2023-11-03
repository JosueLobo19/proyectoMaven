package com.microservice.authservice.models.entity;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name = "rol")
public class Rol{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol")
    private long idRol;

    @Column(name = "rol",length = 50)
    private String nombre;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_registro")
    private Date fechaRegistro;

    private Boolean estado;

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



    public Rol() {
        super();
    }

}