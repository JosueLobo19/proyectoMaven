package com.microservices.authuserrol.models.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

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

    @JsonBackReference
    @OneToMany(mappedBy="persona", cascade= CascadeType.ALL,orphanRemoval = true)
    private Set<Usuario> usuario=new HashSet<>();


}
