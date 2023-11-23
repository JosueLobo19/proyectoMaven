package com.microserviceproyecto.models.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tipo_fase")
public class TipoFase implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_fase")
    private long id;

    @Column(length = 100)
    private String descripcion;

    @Column(length = 18)
    private String estado;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_registro")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaRegistro;

    @Column(name = "user_registro")
    private String userRegistro;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_upd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaActualizacion;

    @Column(name = "user_upd")
    private String userActualizacion;

    @JsonBackReference
    @OneToMany(mappedBy="tipo_fase", cascade= CascadeType.ALL,orphanRemoval = true)
    private Set<Requisito> requisito=new HashSet<>();

    @JsonBackReference
    @OneToMany(mappedBy="tipo_fase", cascade= CascadeType.ALL,orphanRemoval = true)
    private Set<Actividad> actividad=new HashSet<>();
}
