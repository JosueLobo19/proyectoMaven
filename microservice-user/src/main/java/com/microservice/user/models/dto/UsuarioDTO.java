package com.microservice.user.models.dto;

import jakarta.validation.constraints.NotEmpty;

public class UsuarioDTO {
    private long idUser;

    @NotEmpty(message = "El nombre no debe ser vacio o nulo")
    private String username;

    @NotEmpty(message = "El nombre no debe ser vacio o nulo")
    private String password;

    private String estado;

    private long idPersona ;

    private long idRol ;


    public long getIdRol() {
        return idRol;
    }
    public void setIdRol(long idRol) {
        this.idRol = idRol;
    }
    public long getIdPersona() {
        return idPersona;
    }
    public void setIdPersona(long idPersona) {
        this.idPersona = idPersona;
    }
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
    public UsuarioDTO() {
        super();
    }
}
