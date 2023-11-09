package com.microservice.user.models.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "persona", uniqueConstraints = { @UniqueConstraint(columnNames = { "num_documento" }) })

public class Persona implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona")
    private Long id;

    private String nombres;

    private String apellidos;

    @Column(name = "num_documento")
    private Long numDocumento;

    private String correoElect;

    private String celular;

    private String telFijo;
    private String direccion;

    private String Ubigeo;

    @Column(length = 18)
    private String cip;

    @Column(length = 50)
    private String cargo;

    private Boolean estado;

    @Column(name = "fecha_registro")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaRegistro;

    @Column(name = "user_registro")
    private String userRegistro;

    @Column(name = "fecha_upt")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaActualizacion;

    @Column(name = "user_upt")
    private String userActualizacion;

    @JsonBackReference
    @OneToMany(mappedBy="persona", cascade= CascadeType.ALL,orphanRemoval = true)
    private Set<Usuario> usuario=new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_empresa", nullable = false)
    private Empresa empresa;

}
