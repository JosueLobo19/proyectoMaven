package com.microservices.authuserrol.models.dtos;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDtos {


    private long idUser;

    @NotEmpty(message = "El nombre no debe ser vacio o nulo")
    private String userName;

    @NotEmpty(message = "El nombre no debe ser vacio o nulo")
    private String password;

    private String estado;

    private long idPersona ;

    private long idRol ;

}
