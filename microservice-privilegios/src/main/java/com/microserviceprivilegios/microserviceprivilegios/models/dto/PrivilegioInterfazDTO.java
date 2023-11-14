package com.microserviceprivilegios.microserviceprivilegios.models.dto;

import com.microserviceprivilegios.microserviceprivilegios.models.entity.PrivilegioRol;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PrivilegioInterfazDTO {
    private long idOpcInt;

    private String descripcion;

    private Boolean estado;

    private long nivel;

    private long idPadre;


    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaRegistro;

    private String userRegistro;


    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaActualizacion;

    private String userActualizacion;
}
