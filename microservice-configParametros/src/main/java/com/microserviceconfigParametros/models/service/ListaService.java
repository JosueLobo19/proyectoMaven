package com.microserviceconfigParametros.models.service;

import com.microserviceconfigParametros.models.dto.ListaDTO;

import java.util.List;

public interface ListaService {
    ListaDTO crearLista(ListaDTO listaDTO);

    List<ListaDTO> listadoListas();
    ListaDTO obtenerListaPorID(long id);
    ListaDTO actualizarLista(ListaDTO listaDTO, long id);
    void eliminarLista(long id);
}
