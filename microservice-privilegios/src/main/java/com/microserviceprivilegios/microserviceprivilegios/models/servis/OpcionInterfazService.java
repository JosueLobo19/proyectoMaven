package com.microserviceprivilegios.microserviceprivilegios.models.servis;

import com.microserviceprivilegios.microserviceprivilegios.models.dto.PrivilegioInterfazDTO;

import java.util.List;

public interface OpcionInterfazService {

    PrivilegioInterfazDTO crearOpcInt(PrivilegioInterfazDTO privilegioInterfazDTO);

    List<PrivilegioInterfazDTO> listadoOpcInt();
    PrivilegioInterfazDTO obtenerOpcIntPorID(long id);
    PrivilegioInterfazDTO actualizarOpcInt(PrivilegioInterfazDTO privilegioInterfazDTO, long id);
    void eliminarOpcInt(long id);
}
