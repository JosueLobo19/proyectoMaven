package com.microservices.authuserrol.models.dtos;

import com.microservices.authuserrol.models.entity.Usuario;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonaDtos {

    private Long idPersona;

    private String nombres;

    private String apellidos;

    private Long numDocumento;

    @Email
    private String correoElect;

    private String celular;

    private String telFijo;
    private String direccion;

    private String Ubigeo;

    private Set<Usuario> usuario;

}
