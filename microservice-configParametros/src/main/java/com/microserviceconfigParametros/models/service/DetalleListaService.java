package com.microserviceconfigParametros.models.service;

import com.microserviceconfigParametros.models.dto.DetalleListaDTO;

import java.util.List;

public interface DetalleListaService {

    DetalleListaDTO crearDetalleLista(DetalleListaDTO detalleListaDTO);

    List<DetalleListaDTO> listadoDetalleListas();
    DetalleListaDTO obtenerDetalleListasPorID(long id);

    List<DetalleListaDTO> obtenerDetalleListasPorIDLista(long id);

    List<DetalleListaDTO> obtenerDetalleListasPorDescripcionLista(String descripcion);

    DetalleListaDTO actualizarDetalleLista(DetalleListaDTO detalleListaDTO, long id);
    void eliminarDetalleLista(long id);
}
