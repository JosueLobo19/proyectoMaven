package com.microservice.user.models.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmpresaDTO {


    private long id;

    private long ruc;

    private String descripcion;

    private String estado;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate  fechaRegistro;

    private String userRegistro;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate  fechaActualizacion;

    private String userActualizacion;

    private long idPersona;

    private long idArea;
}
