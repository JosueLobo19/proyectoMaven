package com.microserviceprivilegios.microserviceprivilegios.models.servis;

import com.microserviceprivilegios.microserviceprivilegios.models.dto.PrivilegioRolDTO;

import java.util.List;

public interface PrivilegioRolService {
    PrivilegioRolDTO crearPrivRol(PrivilegioRolDTO privilegioRolDTO);

    List<PrivilegioRolDTO> listadoPrivRol();
    PrivilegioRolDTO obtenerPrivRolPorID(long id);
    PrivilegioRolDTO actualizarPrivRol(PrivilegioRolDTO privilegioRolDTO, long id);
    void eliminarPrivRol(long id);
}
