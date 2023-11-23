package com.microserviceproyecto.models.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DocumentoDTO {

    private long id;

    private Boolean adjuntado;

    private Boolean generado;

    private String estado;

    private String rutaArchivo;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaRegistro;

    private String userRegistro;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaActualizacion;

    private String userActualizacion;

    private long idFase;

    private String archivoBase64;

    private long idEmpresa;

    private long idRequisito;

    private String nombreArchivo;
}