package com.microservices.authuserrol.models.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "rol")
public class Rol implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol")
    private long idRol;

    @Column(name = "rol",length = 50)
    private String nombre;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_registro")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaRegistro;

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



    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }



    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }



    public Rol() {
        super();
    }


}
