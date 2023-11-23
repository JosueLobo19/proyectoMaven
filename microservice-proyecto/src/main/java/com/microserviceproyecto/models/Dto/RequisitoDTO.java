package com.microserviceproyecto.models.Dto;

import com.microserviceproyecto.models.Entity.Proyecto;
import com.microserviceproyecto.models.Entity.TipoFase;
import jakarta.persistence.JoinColumn;
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
public class RequisitoDTO {
    private long id;

    private String descripcion;

    private String estado;

    private long cantidad;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaRegistro;

    private String userRegistro;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaActualizacion;

    private String userActualizacion;

    private long idTipoFase;

}
