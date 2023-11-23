package com.microserviceproyecto.models.Service;

import com.microserviceproyecto.models.Dto.ProyectoDTO;

import java.util.List;

public interface ProyectoService {
    ProyectoDTO crearProyecto(ProyectoDTO proyectoDTO);

    List<ProyectoDTO> listadoProyectos();
    ProyectoDTO obtenerPropyectoPorID(long id);
    ProyectoDTO actualizarProyecto(ProyectoDTO proyectoDTO, long id);
    void eliminarProyecto(long id);
}
