package com.microservice.user.models.entity;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;


@Entity
@Table(name = "persona", uniqueConstraints = { @UniqueConstraint(columnNames = { "num_documento" }) })

public class Persona {

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



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Long getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(Long numDocumento) {
        this.numDocumento = numDocumento;
    }

    public String getCorreoElect() {
        return correoElect;
    }

    public void setCorreoElect(String correoElect) {
        this.correoElect = correoElect;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getTelFijo() {
        return telFijo;
    }

    public void setTelFijo(String telFijo) {
        this.telFijo = telFijo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getUbigeo() {
        return Ubigeo;
    }

    public void setUbigeo(String ubigeo) {
        Ubigeo = ubigeo;
    }

    public Set<Usuario> getUsuario() {
        return usuario;
    }

    public void setUsuario(Set<Usuario> usuario) {
        this.usuario = usuario;
    }

    public Persona() {
        super();
    }

    public Persona(Long id, String nombres, String apellidos, Long numDocumento,
                   String correoElect,  String celular, String telFijo, String direccion, String ubigeo) {
        super();
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.numDocumento = numDocumento;
        this.correoElect = correoElect;
        this.celular = celular;
        this.telFijo = telFijo;
        this.direccion = direccion;
        Ubigeo = ubigeo;
    }

}
