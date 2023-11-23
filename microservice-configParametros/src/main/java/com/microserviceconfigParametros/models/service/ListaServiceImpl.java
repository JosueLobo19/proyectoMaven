package com.microserviceconfigParametros.models.service;

import com.microserviceconfigParametros.models.Repository.IListaRepository;
import com.microserviceconfigParametros.models.dto.ListaDTO;
import com.microserviceconfigParametros.models.entity.Lista;
import com.microserviceconfigParametros.models.errors.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListaServiceImpl implements ListaService{

    @Autowired
    private IListaRepository listaRepository;


    @Override
    public ListaDTO crearLista(ListaDTO listaDTO) {
        //convertion de dto a entidad
        Lista lista= mapearENTIDAD(listaDTO);


        Lista nuevaLista= listaRepository.save(lista);

        ListaDTO nuevaListaDTO= mapearDTO(nuevaLista);

        return nuevaListaDTO;
    }

    @Override
    public List<ListaDTO> listadoListas() {
        List<Lista> listadoListas=listaRepository.findAll();
        return listadoListas.stream().map(this::mapearDTO).collect(Collectors.toList());
    }

    @Override
    public ListaDTO obtenerListaPorID(long id) {
        Lista lista=listaRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Lista", "id", id));
        return mapearDTO(lista);
    }

    @Override
    public ListaDTO actualizarLista(ListaDTO listaDTO, long id) {
        Lista lista=listaRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Lista", "id", id));
        lista.setDescripcion(listaDTO.getDescripcion());
        lista.setEstado(listaDTO.getEstado());
        lista.setUserRegistro(listaDTO.getUserRegistro());
        lista.setFechaRegistro(listaDTO.getFechaRegistro());
        lista.setUserActualizacion(listaDTO.getUserActualizacion());
        lista.setFechaActualizacion(listaDTO.getFechaActualizacion());
        listaRepository.save(lista);
        return mapearDTO(lista);
    }

    @Override
    public void eliminarLista(long id) {
        Lista lista
                =listaRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("lista", "id", id));
        listaRepository.delete(lista);
    }


    private ListaDTO mapearDTO(Lista lista){
        ListaDTO listaDTO= new ListaDTO();
        listaDTO.setIdLista(lista.getIdLista());
        listaDTO.setDescripcion(lista.getDescripcion());
        listaDTO.setEstado(lista.getEstado());
        listaDTO.setUserRegistro(lista.getUserRegistro());
        listaDTO.setFechaRegistro(lista.getFechaRegistro());
        listaDTO.setUserActualizacion(lista.getUserActualizacion());
        listaDTO.setFechaActualizacion(lista.getFechaActualizacion());

        return listaDTO;
    }

    private Lista mapearENTIDAD(ListaDTO listaDTO){
        Lista lista=new Lista();
        lista.setDescripcion(listaDTO.getDescripcion());
        lista.setEstado(listaDTO.getEstado());
        lista.setUserRegistro(listaDTO.getUserRegistro());
        lista.setFechaRegistro(listaDTO.getFechaRegistro());
        lista.setUserActualizacion(listaDTO.getUserActualizacion());
        lista.setFechaActualizacion(listaDTO.getFechaActualizacion());
        return lista;
    }

}
