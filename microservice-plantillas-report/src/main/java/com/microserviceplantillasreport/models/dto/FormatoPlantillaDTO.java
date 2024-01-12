package com.microserviceplantillasreport.models.dto;

import com.microserviceplantillasreport.models.entity.PlantillaDocumento;
import jakarta.persistence.*;
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
public class FormatoPlantillaDTO {

    private long id;

    private long numParte;

    private String descripcion;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaRegistro;

    private String userRegistro;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaActualizacion;

    private String userActualizacion;

    @JoinColumn(name = "id_plantilla_documento", nullable = false)
    private PlantillaDocumento plantillaDocumento;

    private long id_plantilla_documento;
}
