package com.microservice.user.models.dto;

import com.microservice.user.models.entity.Empresa;
import com.microservice.user.models.entity.Usuario;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Set;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonaDTO {
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


    @Column(length = 18)
    private String cip;

    @Column(length = 50)
    private String cargo;

    private Boolean estado;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaRegistro;

    private String userRegistro;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaActualizacion;

    private String userActualizacion;

   // private Set<Usuario> usuario;

    private long idEmpresa;

}
