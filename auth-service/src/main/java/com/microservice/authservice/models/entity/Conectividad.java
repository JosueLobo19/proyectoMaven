package com.microservice.authservice.models.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Conectividad")
public class Conectividad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_conectividad")
    private Long id;
    private String descripcion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Conectividad() {
        super();
    }
}
