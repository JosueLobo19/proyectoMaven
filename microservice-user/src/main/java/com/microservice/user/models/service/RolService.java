package com.microservice.user.models.service;

import com.microservice.user.models.dto.RolDTO;

import java.util.List;

public interface RolService {

    RolDTO crearRol(RolDTO rolDTO);

    RolDTO obtenerRolPorID(long id);
    List<RolDTO> obtenerRolListar();
    RolDTO actualizarRol(RolDTO rolDTO, long id);
    void eliminarRol(long id);
}
