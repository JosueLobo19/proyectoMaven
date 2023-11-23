package com.microserviceproyecto.models.Service;

import com.microserviceproyecto.models.Dto.RequisitoDTO;
import java.util.List;

public interface RequisitoService {
    RequisitoDTO crearRequisito(RequisitoDTO requisitoDTO);

    List<RequisitoDTO> listadoRequisito();
    RequisitoDTO obtenerRequisitoPorID(long id);
    RequisitoDTO actualizarRequisito(RequisitoDTO requisitoDTO, long id);
    void eliminarRequisito(long id);
}
