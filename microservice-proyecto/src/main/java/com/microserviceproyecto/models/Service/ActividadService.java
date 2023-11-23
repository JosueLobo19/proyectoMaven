package com.microserviceproyecto.models.Service;

import com.microserviceproyecto.models.Dto.ActividadDTO;

import java.util.List;

public interface ActividadService {
    ActividadDTO crearActividad(ActividadDTO actividadDTO);
    List<ActividadDTO> listadoActividad();
    ActividadDTO obtenerActividadPorID(long id);
    ActividadDTO actualizarActividad(ActividadDTO actividadDTO, long id);
    void eliminarActividad(long id);

}
