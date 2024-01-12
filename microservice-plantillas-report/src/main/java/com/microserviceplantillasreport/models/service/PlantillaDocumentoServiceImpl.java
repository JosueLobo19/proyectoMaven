package com.microserviceplantillasreport.models.service;

import com.microserviceplantillasreport.models.dto.PlantillaDocumentoDTO;
import com.microserviceplantillasreport.models.entity.PlantillaDocumento;
import com.microserviceplantillasreport.models.errors.ResourceNotFoundException;
import com.microserviceplantillasreport.models.repository.IPlantillaDocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlantillaDocumentoServiceImpl implements IPlantillaDocumentoService{

    @Autowired
    private IPlantillaDocumentoRepository plantillaDocumentoRepository;

    @Override
    public PlantillaDocumentoDTO crearPlantillaDocumento(PlantillaDocumentoDTO plantillaDocumentoDTO) {
        //convertion de dto a entidad
        PlantillaDocumento plantillaDocumento= mapearENTIDAD(plantillaDocumentoDTO);

        PlantillaDocumento nuevaPlantillaDocumento= plantillaDocumentoRepository.save(plantillaDocumento);

        PlantillaDocumentoDTO nuevaPlantillaDocumentoDTO= mapearDTO(nuevaPlantillaDocumento);

        return nuevaPlantillaDocumentoDTO;
    }

    @Override
    public List<PlantillaDocumentoDTO> listadoPlantillaDocumento() {
        List<PlantillaDocumento> listadoPlantillasDocumento=plantillaDocumentoRepository.findAll();
        return listadoPlantillasDocumento.stream().map(this::mapearDTO).collect(Collectors.toList());
    }

    @Override
    public PlantillaDocumentoDTO obtenerPlantillaDocumentoPorID(long id) {
        PlantillaDocumento plantillaDocumento=plantillaDocumentoRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("PlantillaDocumento", "id", id));
        return mapearDTO(plantillaDocumento);
    }

    @Override
    public PlantillaDocumentoDTO actualizarPlantillaDocumento(PlantillaDocumentoDTO plantillaDocumentoDTO, long id) {
        PlantillaDocumento plantillaDocumento=plantillaDocumentoRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("PlantillaDocumento", "id", id));
        return actualizar(plantillaDocumento,plantillaDocumentoDTO);
    }

    @Override
    public void eliminarPlantillaDocumento(long id) {
        PlantillaDocumento plantillaDocumento
                =plantillaDocumentoRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("PlantillaDocumento", "id", id));
        plantillaDocumentoRepository.delete(plantillaDocumento);
    }

    private PlantillaDocumentoDTO mapearDTO(PlantillaDocumento plantillaDocumento){
        PlantillaDocumentoDTO plantillaDocumentoDTO= new PlantillaDocumentoDTO();
        plantillaDocumentoDTO.setId(plantillaDocumento.getId());
        plantillaDocumentoDTO.setNombrePlantilla(plantillaDocumento.getNombrePlantilla());
        plantillaDocumentoDTO.setEstado(plantillaDocumento.getEstado());
        plantillaDocumentoDTO.setUserRegistro(plantillaDocumento.getUserRegistro());
        plantillaDocumentoDTO.setFechaRegistro(plantillaDocumento.getFechaRegistro());
        plantillaDocumentoDTO.setUserActualizacion(plantillaDocumento.getUserActualizacion());
        plantillaDocumentoDTO.setFechaActualizacion(plantillaDocumento.getFechaActualizacion());
        return plantillaDocumentoDTO;
    }

    private PlantillaDocumento mapearENTIDAD(PlantillaDocumentoDTO plantillaDocumentoDTO){
        PlantillaDocumento plantillaDocumento=new PlantillaDocumento();
        plantillaDocumento.setNombrePlantilla(plantillaDocumentoDTO.getNombrePlantilla());
        plantillaDocumento.setEstado(plantillaDocumentoDTO.getEstado());
        plantillaDocumento.setUserRegistro(plantillaDocumentoDTO.getUserRegistro());
        plantillaDocumento.setFechaRegistro(plantillaDocumentoDTO.getFechaRegistro());
        plantillaDocumento.setUserActualizacion(plantillaDocumentoDTO.getUserActualizacion());
        plantillaDocumento.setFechaActualizacion(plantillaDocumentoDTO.getFechaActualizacion());
        return plantillaDocumento;
    }

    private PlantillaDocumentoDTO actualizar(PlantillaDocumento plantillaDocumento, PlantillaDocumentoDTO plantillaDocumentoDTO){

        plantillaDocumento.setNombrePlantilla(plantillaDocumentoDTO.getNombrePlantilla());
        plantillaDocumento.setEstado(plantillaDocumentoDTO.getEstado());
        plantillaDocumento.setUserRegistro(plantillaDocumentoDTO.getUserRegistro());
        plantillaDocumento.setFechaRegistro(plantillaDocumentoDTO.getFechaRegistro());
        plantillaDocumento.setUserActualizacion(plantillaDocumentoDTO.getUserActualizacion());
        plantillaDocumento.setFechaActualizacion(plantillaDocumentoDTO.getFechaActualizacion());
        plantillaDocumentoRepository.save(plantillaDocumento);
        return mapearDTO(plantillaDocumento);
    }

}
