package com.microserviceproyecto.models.Service;

import com.microserviceproyecto.models.Dto.FaseDTO;
import com.microserviceproyecto.models.Entity.Fase;
import com.microserviceproyecto.models.Entity.Proyecto;
import com.microserviceproyecto.models.Entity.TipoFase;
import com.microserviceproyecto.models.Error.ResourceNotFoundException;
import com.microserviceproyecto.models.Repository.IFaseRepository;
import com.microserviceproyecto.models.Repository.IProyectoRepository;
import com.microserviceproyecto.models.Repository.ITipoFaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FaseServiceImpl implements FaseService{

    @Autowired
    private IFaseRepository faseRepository;

    @Autowired
    private ITipoFaseRepository tipoFaseRepository;

    @Autowired
    private IProyectoRepository proyectoRepository;

    @Override
    public FaseDTO crearAFase(FaseDTO faseDTO) {
        //convertion de dto a entidad
        Fase fase= mapearENTIDAD(faseDTO);

        Fase nuevaFase= faseRepository.save(fase);

        FaseDTO nuevaFaseDTO= mapearDTO(nuevaFase);

        return nuevaFaseDTO;
    }

    @Override
    public List<FaseDTO> listadoFase() {
        List<Fase> listadoFases=faseRepository.findAll();
        return listadoFases.stream().map(this::mapearDTO).collect(Collectors.toList());
    }

    @Override
    public FaseDTO obtenerFasePorID(long id) {
        Fase fase=faseRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Fase", "id", id));
        return mapearDTO(fase);
    }

    @Override
    public FaseDTO actualizarFase(FaseDTO faseDTO, long id) {
        Fase fase
                =faseRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Fase", "id", id));
        return actualizar(fase,faseDTO);
    }

    @Override
    public void eliminarFase(long id) {
        Fase fase
                =faseRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Fase", "id", id));
        faseRepository.delete(fase);
    }


    private FaseDTO mapearDTO(Fase fase){
        FaseDTO faseDTO= new FaseDTO();
        faseDTO.setId(fase.getId());
        faseDTO.setDescripcion(fase.getDescripcion());
        faseDTO.setEstado(fase.getEstado());
        faseDTO.setFechaInicio(fase.getFechaInicio());
        faseDTO.setFechaFin(fase.getFechaFin());
        faseDTO.setUserRegistro(fase.getUserRegistro());
        faseDTO.setFechaRegistro(fase.getFechaRegistro());
        faseDTO.setUserActualizacion(fase.getUserActualizacion());
        faseDTO.setFechaActualizacion(fase.getFechaActualizacion());
        faseDTO.setIdTipoFase(fase.getTipo_fase().getId());
        faseDTO.setIdProyecto(fase.getProyecto().getId());
        return faseDTO;
    }

    private Fase mapearENTIDAD(FaseDTO faseDTO){
        Fase fase=new Fase();
        TipoFase tipoFase;
        Proyecto proyecto;
        fase.setDescripcion(faseDTO.getDescripcion());
        fase.setEstado(faseDTO.getEstado());
        fase.setFechaInicio(faseDTO.getFechaInicio());
        fase.setFechaFin(faseDTO.getFechaFin());
        fase.setUserRegistro(faseDTO.getUserRegistro());
        fase.setFechaRegistro(faseDTO.getFechaRegistro());
        fase.setUserActualizacion(faseDTO.getUserActualizacion());
        fase.setFechaActualizacion(faseDTO.getFechaActualizacion());
        tipoFase=tipoFaseRepository.findById(faseDTO.getIdTipoFase()).orElseThrow(()->new ResourceNotFoundException("Tipo de fase", "id_tipo_fase", faseDTO.getIdTipoFase()));
        proyecto=proyectoRepository.findById(faseDTO.getIdProyecto()).orElseThrow(()->new ResourceNotFoundException("Proyecto", "id_proyecto", faseDTO.getIdProyecto()));
        fase.setProyecto(proyecto);
        fase.setTipo_fase(tipoFase);
        return fase;
    }


    private FaseDTO actualizar(Fase fase, FaseDTO faseDTO){
        TipoFase tipoFase;
        Proyecto proyecto;

        fase.setDescripcion(faseDTO.getDescripcion());
        fase.setEstado(faseDTO.getEstado());
        fase.setFechaInicio(faseDTO.getFechaInicio());
        fase.setFechaFin(faseDTO.getFechaFin());
        fase.setUserRegistro(faseDTO.getUserRegistro());
        fase.setFechaRegistro(faseDTO.getFechaRegistro());
        fase.setUserActualizacion(faseDTO.getUserActualizacion());
        fase.setFechaActualizacion(faseDTO.getFechaActualizacion());
        tipoFase=tipoFaseRepository.findById(faseDTO.getIdTipoFase()).orElseThrow(()->new ResourceNotFoundException("Tipo de fase", "id_tipo_fase", faseDTO.getIdTipoFase()));
        proyecto=proyectoRepository.findById(faseDTO.getIdProyecto()).orElseThrow(()->new ResourceNotFoundException("Proyecto", "id_proyecto", faseDTO.getIdProyecto()));
        fase.setProyecto(proyecto);
        fase.setTipo_fase(tipoFase);
        faseRepository.save(fase);
        return mapearDTO(fase);
    }
}
