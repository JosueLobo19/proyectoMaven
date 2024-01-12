package com.microserviceplantillasreport.models.service;

import com.microserviceplantillasreport.models.dto.FormatoPlantillaDTO;
import com.microserviceplantillasreport.models.dto.PlantillaDocumentoDTO;
import com.microserviceplantillasreport.models.entity.FormatoPlantilla;
import com.microserviceplantillasreport.models.entity.PlantillaDocumento;
import com.microserviceplantillasreport.models.errors.ResourceNotFoundException;
import com.microserviceplantillasreport.models.repository.IFormatoPlantillaRepository;
import com.microserviceplantillasreport.models.repository.IPlantillaDocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FormatoPlantillaServiceImpl implements IFormatoPlantillaService{

    @Autowired
    private IFormatoPlantillaRepository formatoPlantillaRepository;

    @Autowired
    private IPlantillaDocumentoRepository plantillaDocumentoRepository;

    @Override
    public FormatoPlantillaDTO crearFormatoPlantilla(FormatoPlantillaDTO formatoPlantillaDTO) {
        //convertion de dto a entidad
        System.out.println("entro al crear formato plantilla");
        FormatoPlantilla formatoPlantilla= mapearENTIDAD(formatoPlantillaDTO);
        System.out.println("paso al mapear entidad");
        System.out.println("la estructura del formato plantilla:"+formatoPlantilla);

        FormatoPlantilla nuevoFormatoPlantilla= formatoPlantillaRepository.save(formatoPlantilla);
        System.out.println("paso el guardar");

        FormatoPlantillaDTO nuevoFormatoPlantillaDTO= mapearDTO(nuevoFormatoPlantilla);
        System.out.println("paso el mapear DTO");

        return nuevoFormatoPlantillaDTO;
    }

    @Override
    public List<FormatoPlantillaDTO> listadoFormatoPlantilla() {
        List<FormatoPlantilla> listadoFormatoPlantilla=formatoPlantillaRepository.findAll();
        return listadoFormatoPlantilla.stream().map(this::mapearDTO).collect(Collectors.toList());
    }

    @Override
    public FormatoPlantillaDTO obtenerFormatoPlantillaPorID(long id) {
        FormatoPlantilla formatoPlantilla=formatoPlantillaRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("FormatoPlantilla", "id", id));
        return mapearDTO(formatoPlantilla);
    }

    @Override
    public FormatoPlantillaDTO actualizarFormatoPlantilla(FormatoPlantillaDTO formatoPlantillaDTO, long id) {
        FormatoPlantilla formatoPlantilla=formatoPlantillaRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("FormatoPlantilla", "id", id));
        return actualizar(formatoPlantilla,formatoPlantillaDTO);
    }

    @Override
    public void eliminarFormatoPlantilla(long id) {
        FormatoPlantilla formatoPlantilla
                =formatoPlantillaRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Formato Plantilla", "id", id));
        formatoPlantillaRepository.delete(formatoPlantilla);
    }

    private FormatoPlantillaDTO mapearDTO(FormatoPlantilla formatoPlantilla){
        PlantillaDocumento plantillaDocumento;
        FormatoPlantillaDTO formatoPlantillaDTO= new FormatoPlantillaDTO();
        formatoPlantillaDTO.setId(formatoPlantilla.getId());
        formatoPlantillaDTO.setNumParte(formatoPlantilla.getNumParte());
        formatoPlantillaDTO.setDescripcion(formatoPlantilla.getDescripcion());
        formatoPlantillaDTO.setUserRegistro(formatoPlantilla.getUserRegistro());
        formatoPlantillaDTO.setFechaRegistro(formatoPlantilla.getFechaRegistro());
        formatoPlantillaDTO.setUserActualizacion(formatoPlantilla.getUserActualizacion());
        formatoPlantillaDTO.setFechaActualizacion(formatoPlantilla.getFechaActualizacion());
        formatoPlantillaDTO.setId_plantilla_documento(formatoPlantilla.getPlantilla_documento().getId());
        plantillaDocumento=plantillaDocumentoRepository.findById(formatoPlantilla.getPlantilla_documento().getId()).orElseThrow(()->new ResourceNotFoundException("Plantilla Documento", "id_formato_plantilla",formatoPlantilla.getPlantilla_documento().getId()) );
        formatoPlantillaDTO.setPlantillaDocumento(plantillaDocumento);
        return formatoPlantillaDTO;
    }

    private FormatoPlantilla mapearENTIDAD(FormatoPlantillaDTO formatoPlantillaDTO){
        FormatoPlantilla formatoPlantilla=new FormatoPlantilla();
        PlantillaDocumento plantillaDocumento;
        plantillaDocumento=plantillaDocumentoRepository.findById(formatoPlantillaDTO.getId_plantilla_documento()).orElseThrow(()->new ResourceNotFoundException("Plantilla Documento", "id_formato_plantilla",formatoPlantillaDTO.getPlantillaDocumento().getId()) );
        formatoPlantilla.setNumParte(formatoPlantillaDTO.getNumParte());
        formatoPlantilla.setDescripcion(formatoPlantillaDTO.getDescripcion());
        formatoPlantilla.setUserRegistro(formatoPlantillaDTO.getUserRegistro());
        formatoPlantilla.setFechaRegistro(formatoPlantillaDTO.getFechaRegistro());
        formatoPlantilla.setUserActualizacion(formatoPlantillaDTO.getUserActualizacion());
        formatoPlantilla.setFechaActualizacion(formatoPlantillaDTO.getFechaActualizacion());
        formatoPlantilla.setPlantilla_documento(plantillaDocumento);
        return formatoPlantilla;
    }

    private FormatoPlantillaDTO actualizar(FormatoPlantilla formatoPlantilla, FormatoPlantillaDTO formatoPlantillaDTO){

        formatoPlantilla.setNumParte(formatoPlantillaDTO.getNumParte());
        formatoPlantilla.setDescripcion(formatoPlantillaDTO.getDescripcion());
        formatoPlantilla.setUserRegistro(formatoPlantillaDTO.getUserRegistro());
        formatoPlantilla.setFechaRegistro(formatoPlantillaDTO.getFechaRegistro());
        formatoPlantilla.setUserActualizacion(formatoPlantillaDTO.getUserActualizacion());
        formatoPlantilla.setFechaActualizacion(formatoPlantillaDTO.getFechaActualizacion());
        formatoPlantillaRepository.save(formatoPlantilla);
        return mapearDTO(formatoPlantilla);
    }

}
