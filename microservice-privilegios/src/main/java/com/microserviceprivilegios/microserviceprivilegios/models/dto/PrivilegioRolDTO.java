package com.microserviceprivilegios.microserviceprivilegios.models.dto;

import com.microserviceprivilegios.microserviceprivilegios.models.entity.PrivilegioInfertaz;
import com.microserviceprivilegios.microserviceprivilegios.models.entity.Rol;
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
public class PrivilegioRolDTO {
    private long idPrivRol;

    private String descripcion;

    private Boolean estado;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaRegistro;

    private String userRegistro;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaActualizacion;

    private String userActualizacion;

    private PrivilegioInfertaz opciones_interfaz;

    private Rol rol;

    private long idRol;

    private long idOpcInt;
}
