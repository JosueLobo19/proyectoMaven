package com.microservice.authservice.models.entity;
import java.util.HashSet;
import java.util.Set;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private long idUser;

    private String username;
    private String password;
    private String estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_persona", nullable = false)
    private Persona persona;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "usuario_rol", joinColumns = @JoinColumn(name = "id_user", referencedColumnName = "id_user"), inverseJoinColumns = @JoinColumn(name = "id_rol", referencedColumnName = "id_rol"))
    private Set<Rol> rol = new HashSet<>();



    public long getIdUser() {
        return idUser;
    }



    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }



    public String getUsername() {
        return username;
    }



    public void setUsername(String username) {
        this.username = username;
    }



    public String getPassword() {
        return password;
    }



    public void setPassword(String password) {
        this.password = password;
    }



    public String getEstado() {
        return estado;
    }



    public void setEstado(String estado) {
        this.estado = estado;
    }



    public Persona getPersona() {
        return persona;
    }



    public void setPersona(Persona persona) {
        this.persona = persona;
    }



    public Set<Rol> getRol() {
        return rol;
    }



    public void setRol(Set<Rol> rol) {
        this.rol = rol;
    }



    public Usuario() {
        super();
    }
}
