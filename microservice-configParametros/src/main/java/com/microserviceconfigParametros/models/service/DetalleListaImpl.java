package com.microserviceconfigParametros.models.service;

import com.microserviceconfigParametros.models.Repository.IDetallesListaRepository;
import com.microserviceconfigParametros.models.Repository.IListaRepository;
import com.microserviceconfigParametros.models.dto.DetalleListaDTO;
import com.microserviceconfigParametros.models.entity.DetalleLista;
import com.microserviceconfigParametros.models.entity.Lista;
import com.microserviceconfigParametros.models.errors.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DetalleListaImpl implements DetalleListaService{

    @Autowired
    private IDetallesListaRepository detallesListaRepository;

    @Autowired
    private IListaRepository listaRepository;

    @Override
    public DetalleListaDTO crearDetalleLista(DetalleListaDTO detalleListaDTO) {
        //convertion de dto a entidad
        DetalleLista detalleLista= mapearENTIDAD(detalleListaDTO);

        DetalleLista nuevoDetalleLista= detallesListaRepository.save(detalleLista);

        DetalleListaDTO nuevoDetalleListaDTO= mapearDTO(nuevoDetalleLista);

        return nuevoDetalleListaDTO;
    }

    @Override
    public List<DetalleListaDTO> listadoDetalleListas() {
        List<DetalleLista> listadoDetalleLista=detallesListaRepository.findAll();
        return listadoDetalleLista.stream().map(this::mapearDTO).collect(Collectors.toList());
    }

    @Override
    public DetalleListaDTO obtenerDetalleListasPorID(long id) {
        DetalleLista detalleLista=detallesListaRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("DetalleLista", "id", id));
        return mapearDTO(detalleLista);
    }

    @Override
    public List<DetalleListaDTO> obtenerDetalleListasPorIDLista(long id) {
        List<DetalleLista> detalleLista=detallesListaRepository.obtenerDetallePorIDLista(id);
        return detalleLista.stream().map(this::mapearDTO).collect(Collectors.toList());
    }

    @Override
    public List<DetalleListaDTO> obtenerDetalleListasPorDescripcionLista(String descripcion) {
        List<DetalleLista> detalleLista=detallesListaRepository.obtenerPorDescripcionLista(descripcion);
        return detalleLista.stream().map(this::mapearDTO).collect(Collectors.toList());
    }

    @Override
    public DetalleListaDTO actualizarDetalleLista(DetalleListaDTO detalleListaDTO, long id) {
        DetalleLista detalleLista=detallesListaRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("DetalleLista", "id", id));
        Lista lista;
        detalleLista.setDescripcion(detalleListaDTO.getDescripcion());
        detalleLista.setValor(detalleListaDTO.getValor());
        detalleLista.setEstado(detalleListaDTO.getEstado());
        detalleLista.setUserRegistro(detalleListaDTO.getUserRegistro());
        detalleLista.setFechaRegistro(detalleListaDTO.getFechaRegistro());
        detalleLista.setUserActualizacion(detalleListaDTO.getUserActualizacion());
        detalleLista.setFechaActualizacion(detalleListaDTO.getFechaActualizacion());
        lista=listaRepository.findById(detalleListaDTO.getId_lista()).orElseThrow(()->new ResourceNotFoundException("Lista", "id_lista", detalleListaDTO.getId_lista()));
        detalleLista.setLista(lista);
        detallesListaRepository.save(detalleLista);
        return mapearDTO(detalleLista);
    }

    @Override
    public void eliminarDetalleLista(long id) {
        DetalleLista detalleLista=detallesListaRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("DetalleLista", "id", id));

        detallesListaRepository.delete(detalleLista);
    }

    private DetalleListaDTO mapearDTO(DetalleLista detalleLista){
        DetalleListaDTO detalleListaDTO= new DetalleListaDTO();
        detalleListaDTO.setIdDetLista(detalleLista.getIdDetLista());
        detalleListaDTO.setDescripcion(detalleLista.getDescripcion());
        detalleListaDTO.setValor(detalleLista.getValor());
        detalleListaDTO.setEstado(detalleLista.getEstado());
        detalleListaDTO.setUserRegistro(detalleLista.getUserRegistro());
        detalleListaDTO.setFechaRegistro(detalleLista.getFechaRegistro());
        detalleListaDTO.setUserActualizacion(detalleLista.getUserActualizacion());
        detalleListaDTO.setFechaActualizacion(detalleLista.getFechaActualizacion());
        detalleListaDTO.setId_lista(detalleLista.getLista().getIdLista());
        detalleListaDTO.setLista(detalleLista.getLista());
        return detalleListaDTO;
    }

    private DetalleLista mapearENTIDAD(DetalleListaDTO detalleListaDTO){
        DetalleLista detalleLista=new DetalleLista();
        Lista lista;
        detalleLista.setDescripcion(detalleListaDTO.getDescripcion());
        detalleLista.setValor(detalleListaDTO.getValor());
        detalleLista.setEstado(detalleListaDTO.getEstado());
        detalleLista.setUserRegistro(detalleListaDTO.getUserRegistro());
        detalleLista.setFechaRegistro(detalleListaDTO.getFechaRegistro());
        detalleLista.setUserActualizacion(detalleListaDTO.getUserActualizacion());
        detalleLista.setFechaActualizacion(detalleListaDTO.getFechaActualizacion());
        lista=listaRepository.findById(detalleListaDTO.getId_lista()).orElseThrow(()->new ResourceNotFoundException("Lista", "id_lista", detalleListaDTO.getId_lista()));
        detalleLista.setLista(lista);
        return detalleLista;
    }

}
