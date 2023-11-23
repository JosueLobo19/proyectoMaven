package com.microserviceproyecto.models.Service;

import com.microserviceproyecto.models.Dto.TipoFaseDTO;
import com.microserviceproyecto.models.Entity.TipoFase;
import com.microserviceproyecto.models.Error.ResourceNotFoundException;
import com.microserviceproyecto.models.Repository.ITipoFaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TipoFaseServiceImpl implements TipoFaseService{

    @Autowired
    private ITipoFaseRepository tipoFaseRepository;

    @Override
    public TipoFaseDTO crearTipoDeFase(TipoFaseDTO tipoFaseDTO) {
        //convertion de dto a entidad
        TipoFase tipoFase= mapearENTIDAD(tipoFaseDTO);

        TipoFase nuevoTipoFase= tipoFaseRepository.save(tipoFase);

        TipoFaseDTO nuevoTipoFaseDTO= mapearDTO(nuevoTipoFase);

        return nuevoTipoFaseDTO;
    }

    @Override
    public List<TipoFaseDTO> listadoTipoFases() {
        List<TipoFase> listadoTipoFases=tipoFaseRepository.findAll();
        return listadoTipoFases.stream().map(this::mapearDTO).collect(Collectors.toList());
    }

    @Override
    public TipoFaseDTO obtenerTipoFasesPorID(long id) {
        TipoFase tipoFase=tipoFaseRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Tipo de fase", "id", id));
        return mapearDTO(tipoFase);
    }

    @Override
    public TipoFaseDTO actualizarTipoFases(TipoFaseDTO tipoFaseDTO, long id) {
        TipoFase tipoFase=tipoFaseRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Tipo de fase", "id", id));
        return actualizar(tipoFase,tipoFaseDTO);
    }

    @Override
    public void eliminarTipoFases(long id) {
        TipoFase tipoFase
                =tipoFaseRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Tipo de fase", "id", id));
        tipoFaseRepository.delete(tipoFase);

    }

    private TipoFaseDTO mapearDTO(TipoFase tipoFase){
        TipoFaseDTO tipoFaseDTO= new TipoFaseDTO();
        tipoFaseDTO.setId(tipoFase.getId());
        tipoFaseDTO.setDescripcion(tipoFase.getDescripcion());
        tipoFaseDTO.setEstado(tipoFase.getEstado());
        tipoFaseDTO.setUserRegistro(tipoFase.getUserRegistro());
        tipoFaseDTO.setFechaRegistro(tipoFase.getFechaRegistro());
        tipoFaseDTO.setUserActualizacion(tipoFase.getUserActualizacion());
        tipoFaseDTO.setFechaActualizacion(tipoFase.getFechaActualizacion());

        return tipoFaseDTO;
    }



    private TipoFase mapearENTIDAD(TipoFaseDTO tipoFaseDTO){
        TipoFase tipoFase=new TipoFase();
        tipoFase.setDescripcion(tipoFaseDTO.getDescripcion());
        tipoFase.setEstado(tipoFaseDTO.getEstado());
        tipoFase.setUserRegistro(tipoFaseDTO.getUserRegistro());
        tipoFase.setFechaRegistro(tipoFaseDTO.getFechaRegistro());
        tipoFase.setUserActualizacion(tipoFaseDTO.getUserActualizacion());
        tipoFase.setFechaActualizacion(tipoFaseDTO.getFechaActualizacion());

        return tipoFase;
    }

    private TipoFaseDTO actualizar(TipoFase tipoFase, TipoFaseDTO tipoFaseDTO){

        tipoFase.setDescripcion(tipoFaseDTO.getDescripcion());
        tipoFase.setEstado(tipoFaseDTO.getEstado());
        tipoFase.setUserRegistro(tipoFaseDTO.getUserRegistro());
        tipoFase.setFechaRegistro(tipoFaseDTO.getFechaRegistro());
        tipoFase.setUserActualizacion(tipoFaseDTO.getUserActualizacion());
        tipoFase.setFechaActualizacion(tipoFaseDTO.getFechaActualizacion());
        tipoFaseRepository.save(tipoFase);
        return mapearDTO(tipoFase);
    }
}
