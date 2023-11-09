package com.microservice.user.models.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "empresa", uniqueConstraints =  { @UniqueConstraint(columnNames = { "ruc" }) })
public class Empresa implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empresa")
    private long id;

    private long ruc;

    @Column(length = 100)
    private String descripcion;

    @Column(length = 18)
    private String estado;

    @Column(name = "fecha_registro")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaRegistro;

    @Column(name = "user_registro",length = 18)
    private String userRegistro;

    @Column(name = "fecha_upd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate  fechaActualizacion;

    @Column(name = "user_upd",length = 18)
    private String userActualizacion;

    @JsonBackReference
    @OneToMany(mappedBy="empresa", cascade= CascadeType.ALL,orphanRemoval = true)
    private Set<Persona> persona=new HashSet<>();

    @JsonBackReference
    @OneToMany(mappedBy="empresa", cascade= CascadeType.ALL,orphanRemoval = true)
    private Set<Area> area=new HashSet<>();
}
