package com.microserviceplantillasreport.models.service;

import com.microserviceplantillasreport.models.dto.FormatoPlantillaDTO;

import java.util.List;

public interface IFormatoPlantillaService {
    FormatoPlantillaDTO crearFormatoPlantilla(FormatoPlantillaDTO formatoPlantillaDTO);
    List<FormatoPlantillaDTO> listadoFormatoPlantilla();
    FormatoPlantillaDTO obtenerFormatoPlantillaPorID(long id);
    FormatoPlantillaDTO actualizarFormatoPlantilla(FormatoPlantillaDTO formatoPlantillaDTO, long id);
    void eliminarFormatoPlantilla(long id);
}
