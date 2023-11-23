package com.microserviceproyecto.models.Service;

import com.microserviceproyecto.models.Dto.ActividadDTO;
import com.microserviceproyecto.models.Dto.FaseDTO;

import java.util.List;

public interface FaseService {
    FaseDTO crearAFase(FaseDTO faseDTO);
    List<FaseDTO> listadoFase();
    FaseDTO obtenerFasePorID(long id);
    FaseDTO actualizarFase(FaseDTO faseDTO, long id);
    void eliminarFase(long id);
}
