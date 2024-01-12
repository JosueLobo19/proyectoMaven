package com.microserviceplantillasreport.models.service;

import com.microserviceplantillasreport.models.dto.PlantillaDocumentoDTO;

import java.util.List;

public interface IPlantillaDocumentoService {
    PlantillaDocumentoDTO crearPlantillaDocumento(PlantillaDocumentoDTO plantillaDocumentoDTO);
    List<PlantillaDocumentoDTO> listadoPlantillaDocumento();
    PlantillaDocumentoDTO obtenerPlantillaDocumentoPorID(long id);
    PlantillaDocumentoDTO actualizarPlantillaDocumento(PlantillaDocumentoDTO plantillaDocumentoDTO, long id);
    void eliminarPlantillaDocumento(long id);
}
