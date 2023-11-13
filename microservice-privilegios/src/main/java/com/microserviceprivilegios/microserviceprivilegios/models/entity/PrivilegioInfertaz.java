package com.microserviceprivilegios.microserviceprivilegios.models.entity;

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

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "opciones_interfaz")
public class PrivilegioInfertaz implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_opcion_interfaz")
    private long idOpcInt;

    private String descripcion;

    private Boolean estado;

    private long nivel;

    @Column(name = "id_padre")
    private long idPadre;

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

    @Column(name = "user_upt")
    private String userActualizacion;

    @JsonBackReference
    @OneToMany(mappedBy="opciones_interfaz", cascade= CascadeType.ALL,orphanRemoval = true)
    private Set<PrivilegioRol> privilegioRol=new HashSet<>();



}
