package com.microserviceproyecto.models.Service;

import com.microserviceproyecto.models.Dto.RequisitoDTO;
import com.microserviceproyecto.models.Entity.Requisito;
import com.microserviceproyecto.models.Entity.TipoFase;
import com.microserviceproyecto.models.Error.ResourceNotFoundException;
import com.microserviceproyecto.models.Repository.IRequisitoRepository;

import com.microserviceproyecto.models.Repository.ITipoFaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RequisitoServiceImpl implements RequisitoService{

    @Autowired
    IRequisitoRepository requisitoRepository;

    @Autowired
    ITipoFaseRepository tipoFaseRepository;

    @Override
    public RequisitoDTO crearRequisito(RequisitoDTO requisitoDTO) {
        //convertion de dto a entidad
        Requisito requisito= mapearENTIDAD(requisitoDTO);

        Requisito nuevoRequisito= requisitoRepository.save(requisito);

        RequisitoDTO nuevoRequisitoDTO= mapearDTO(nuevoRequisito);

        return nuevoRequisitoDTO;
    }

    @Override
    public List<RequisitoDTO> listadoRequisito() {
        List<Requisito> listadoRequisitos=requisitoRepository.findAll();
        return listadoRequisitos.stream().map(this::mapearDTO).collect(Collectors.toList());
    }

    @Override
    public RequisitoDTO obtenerRequisitoPorID(long id) {
        Requisito requisito=requisitoRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Requisito", "id", id));
        return mapearDTO(requisito);
    }

    @Override
    public RequisitoDTO actualizarRequisito(RequisitoDTO requisitoDTO, long id) {
        Requisito requisito=requisitoRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Requisito", "id", id));
        return actualizar(requisito,requisitoDTO);
    }

    @Override
    public void eliminarRequisito(long id) {
        Requisito requisito
                =requisitoRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Requisito", "id", id));
        requisitoRepository.delete(requisito);
    }

    private RequisitoDTO mapearDTO(Requisito requisito){
        RequisitoDTO requisitoDTO= new RequisitoDTO();
        TipoFase tipoFase;
        requisitoDTO.setId(requisito.getId());
        requisitoDTO.setDescripcion(requisito.getDescripcion());
        requisitoDTO.setEstado(requisito.getEstado());
        requisitoDTO.setCantidad(requisito.getCantidad());
        requisitoDTO.setUserRegistro(requisito.getUserRegistro());
        requisitoDTO.setFechaRegistro(requisito.getFechaRegistro());
        requisitoDTO.setUserActualizacion(requisito.getUserActualizacion());
        requisitoDTO.setFechaActualizacion(requisito.getFechaActualizacion());
        tipoFase=requisito.getTipo_fase();
        requisitoDTO.setIdTipoFase(tipoFase.getId());
        return requisitoDTO;
    }

    private Requisito mapearENTIDAD(RequisitoDTO requisitoDTO){
        Requisito requisito=new Requisito();
        TipoFase tipoFase;
        requisito.setDescripcion(requisitoDTO.getDescripcion());
        requisito.setEstado(requisitoDTO.getEstado());
        requisito.setCantidad(requisitoDTO.getCantidad());
        requisito.setUserRegistro(requisitoDTO.getUserRegistro());
        requisito.setFechaRegistro(requisitoDTO.getFechaRegistro());
        requisito.setUserActualizacion(requisitoDTO.getUserActualizacion());
        requisito.setFechaActualizacion(requisitoDTO.getFechaActualizacion());
        tipoFase=tipoFaseRepository.findById(requisitoDTO.getIdTipoFase()).orElseThrow(()->new ResourceNotFoundException("Tipo de fase", "id_tipo_fase", requisitoDTO.getIdTipoFase()));
        requisito.setTipo_fase(tipoFase);
        return requisito;
    }

    private RequisitoDTO actualizar(Requisito requisito, RequisitoDTO requisitoDTO){
        TipoFase tipoFase;

        requisito.setDescripcion(requisitoDTO.getDescripcion());
        requisito.setEstado(requisitoDTO.getEstado());
        requisito.setCantidad(requisitoDTO.getCantidad());
        requisito.setUserRegistro(requisitoDTO.getUserRegistro());
        requisito.setFechaRegistro(requisitoDTO.getFechaRegistro());
        requisito.setUserActualizacion(requisitoDTO.getUserActualizacion());
        requisito.setFechaActualizacion(requisitoDTO.getFechaActualizacion());
        tipoFase=tipoFaseRepository.findById(requisitoDTO.getIdTipoFase()).orElseThrow(()->new ResourceNotFoundException("Tipo de fase", "id_tipo_fase", requisitoDTO.getIdTipoFase()));
        requisito.setTipo_fase(tipoFase);
        requisitoRepository.save(requisito);
        return mapearDTO(requisito);
    }

}
