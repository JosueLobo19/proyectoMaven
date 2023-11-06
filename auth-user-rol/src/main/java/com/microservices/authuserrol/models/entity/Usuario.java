package com.microservices.authuserrol.models.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "usuario")
public class Usuario  implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private long idUser;
    @Column(name = "username")
    private String userName;
    private String password;
    private String estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_persona", nullable = false)
    //@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Persona persona;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "usuario_rol", joinColumns = @JoinColumn(name = "id_user", referencedColumnName = "id_user"), inverseJoinColumns = @JoinColumn(name = "id_rol", referencedColumnName = "id_rol"))
    //@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Set<Rol> rol = new HashSet<>();



    public long getIdUser() {
        return idUser;
    }



    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }



    public String getUsername() {
        return userName;
    }



    public void setUsername(String username) {
        this.userName = username;
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
