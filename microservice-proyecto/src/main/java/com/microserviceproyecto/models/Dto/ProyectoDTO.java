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
public class ProyectoDTO {
    private long id;

    private String codGenerado;

    private String finalidadProyecto;

    private String estado;

    private String supervisorGDPE;

    private long idEmpresaProyectista;

    private long idPersonaProyectista;

    private String nombreProyecto;

    private String departamento;

    private String provincia;

    private String distrito;

    private long ubigeo;

    private String localidad;

    private long idSistema;

    private float coordUtmX;

    private float coordUtmY;

    private String ubicacionProyecto;

    private long idPersonaInteresada;

    private long idTipoProyecto;

    private long idTipoFinanciamiento;

    private String detalleFinanciamiento;

    private long cantidadBeneficiarios;

    private float demPotencia;

    private long nivelTension;

    private long longitudProyecto;

    private long inversion;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaRegistro;

    private String userRegistro;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaActualizacion;

    private String userActualizacion;
}
