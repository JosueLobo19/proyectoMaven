package com.microservice.user.models.dto;

import com.microservice.user.models.entity.Empresa;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AreaDTO {

    private long id;

    private String descripcion;

    private String estado;

    private long idEmpresa;
}
