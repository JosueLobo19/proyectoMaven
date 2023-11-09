package com.microservice.user.models.service;

import com.microservice.user.models.dto.AreaDTO;

import java.util.List;

public interface AreaService {

    AreaDTO crearArea(AreaDTO areaDTO);

    List<AreaDTO> listadoArea();
    AreaDTO obtenerAreaPorID(long id);
    AreaDTO actualizarArea(AreaDTO areaDTO, long id);
    void eliminarArea(long id);
}
