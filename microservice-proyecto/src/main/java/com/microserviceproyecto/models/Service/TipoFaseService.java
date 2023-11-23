package com.microserviceproyecto.models.Service;

import com.microserviceproyecto.models.Dto.TipoFaseDTO;

import java.util.List;

public interface TipoFaseService {
    TipoFaseDTO crearTipoDeFase(TipoFaseDTO tipoFaseDTO);

    List<TipoFaseDTO> listadoTipoFases();
    TipoFaseDTO obtenerTipoFasesPorID(long id);
    TipoFaseDTO actualizarTipoFases(TipoFaseDTO tipoFaseDTO, long id);
    void eliminarTipoFases(long id);
}
