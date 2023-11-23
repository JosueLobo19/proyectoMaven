package com.microserviceproyecto.models.Service;

import com.microserviceproyecto.models.Dto.ActividadDTO;
import com.microserviceproyecto.models.Dto.RequisitoDTO;
import com.microserviceproyecto.models.Entity.Actividad;
import com.microserviceproyecto.models.Entity.Requisito;
import com.microserviceproyecto.models.Entity.TipoFase;
import com.microserviceproyecto.models.Error.ResourceNotFoundException;
import com.microserviceproyecto.models.Repository.IActividadRepository;
import com.microserviceproyecto.models.Repository.ITipoFaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActividadServiceImpl implements ActividadService{

    @Autowired
    private IActividadRepository actividadRepository;

    @Autowired
    private ITipoFaseRepository tipoFaseRepository;

    @Override
    public ActividadDTO crearActividad(ActividadDTO actividadDTO) {
        //convertion de dto a entidad
        Actividad actividad= mapearENTIDAD(actividadDTO);

        Actividad nuevaActividad= actividadRepository.save(actividad);

        ActividadDTO nuevaActividadDTO= mapearDTO(nuevaActividad);

        return nuevaActividadDTO;
    }

    @Override
    public List<ActividadDTO> listadoActividad() {
        List<Actividad> listadoActividades=actividadRepository.findAll();
        return listadoActividades.stream().map(this::mapearDTO).collect(Collectors.toList());
    }

    @Override
    public ActividadDTO obtenerActividadPorID(long id) {
        Actividad actividad=actividadRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Actividad", "id", id));
        return mapearDTO(actividad);
    }

    @Override
    public ActividadDTO actualizarActividad(ActividadDTO actividadDTO, long id) {
        Actividad actividad=actividadRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Actividad", "id", id));
        return actualizar(actividad,actividadDTO);
    }

    @Override
    public void eliminarActividad(long id) {
        Actividad actividad
                =actividadRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Requisito", "id", id));
        actividadRepository.delete(actividad);
    }

    private ActividadDTO mapearDTO(Actividad actividad){
        ActividadDTO actividadDTO= new ActividadDTO();
        actividadDTO.setId(actividad.getId());
        actividadDTO.setDescripcion(actividad.getDescripcion());
        actividadDTO.setEstado(actividad.getEstado());
        actividadDTO.setPlazoTiempoDias(actividad.getPlazoTiempoDias());
        actividadDTO.setUserRegistro(actividad.getUserRegistro());
        actividadDTO.setFechaRegistro(actividad.getFechaRegistro());
        actividadDTO.setUserActualizacion(actividad.getUserActualizacion());
        actividadDTO.setFechaActualizacion(actividad.getFechaActualizacion());
        actividadDTO.setIdTipoFase(actividad.getTipo_fase().getId());
        return actividadDTO;
    }

    private Actividad mapearENTIDAD(ActividadDTO actividadDTO){
        Actividad actividad=new Actividad();
        TipoFase tipoFase;
        actividad.setDescripcion(actividadDTO.getDescripcion());
        actividad.setEstado(actividadDTO.getEstado());
        actividad.setPlazoTiempoDias(actividadDTO.getPlazoTiempoDias());
        actividad.setUserRegistro(actividadDTO.getUserRegistro());
        actividad.setFechaRegistro(actividadDTO.getFechaRegistro());
        actividad.setUserActualizacion(actividadDTO.getUserActualizacion());
        actividad.setFechaActualizacion(actividadDTO.getFechaActualizacion());
        tipoFase=tipoFaseRepository.findById(actividadDTO.getIdTipoFase()).orElseThrow(()->new ResourceNotFoundException("Tipo de fase", "id_tipo_fase", actividadDTO.getIdTipoFase()));
        actividad.setTipo_fase(tipoFase);
        return actividad;
    }

    private ActividadDTO actualizar(Actividad actividad, ActividadDTO actividadDTO){
        TipoFase tipoFase;

        actividad.setDescripcion(actividadDTO.getDescripcion());
        actividad.setEstado(actividadDTO.getEstado());
        actividad.setPlazoTiempoDias(actividadDTO.getPlazoTiempoDias());
        actividad.setUserRegistro(actividadDTO.getUserRegistro());
        actividad.setFechaRegistro(actividadDTO.getFechaRegistro());
        actividad.setUserActualizacion(actividadDTO.getUserActualizacion());
        actividad.setFechaActualizacion(actividadDTO.getFechaActualizacion());
        tipoFase=tipoFaseRepository.findById(actividadDTO.getIdTipoFase()).orElseThrow(()->new ResourceNotFoundException("Tipo de fase", "id_tipo_fase", actividadDTO.getIdTipoFase()));
        actividad.setTipo_fase(tipoFase);
        actividadRepository.save(actividad);
        return mapearDTO(actividad);
    }


}
