package com.microserviceconfigParametros.models.dto;

import com.microserviceconfigParametros.models.entity.Lista;
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
public class DetalleListaDTO {

    private long idDetLista;

    private String descripcion;

    private String valor;

    private Boolean estado;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaRegistro;

    private String userRegistro;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaActualizacion;

    private String userActualizacion;

    @JoinColumn(name = "id_lista", nullable = false)
    private Lista lista;

    private long id_lista;

}
