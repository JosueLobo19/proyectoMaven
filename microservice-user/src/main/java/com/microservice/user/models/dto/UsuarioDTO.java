package com.microservice.user.models.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {
    private long idUser;

    @NotEmpty(message = "El nombre no debe ser vacio o nulo")
    private String username;

    @NotEmpty(message = "El nombre no debe ser vacio o nulo")
    private String password;

    private String estado;

    private long idPersona ;

    private long idRol ;


}
