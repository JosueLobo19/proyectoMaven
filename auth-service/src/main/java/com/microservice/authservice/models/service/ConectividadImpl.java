package com.microservice.authservice.models.service;

import com.microservice.authservice.models.dao.IConectividadDAO;
import com.microservice.authservice.models.dto.ConectividadDTO;
import com.microservice.authservice.models.entity.Conectividad;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConectividadImpl implements  ConectividadService{

    IConectividadDAO conectividadDAO;
    @Override
    public List<ConectividadDTO> obtenerListar() {
        System.out.println("primera parte");
        List<Conectividad> listaConectados=conectividadDAO.findAll();
        System.out.println("segunda parte");

        return listaConectados.stream().map(conectividad -> mapearDTO(conectividad)).collect(Collectors.toList());
    }

    //convierte entidad a DTO
    private ConectividadDTO mapearDTO(Conectividad conectividad) {
        ConectividadDTO conectividadDTO= new ConectividadDTO();
        conectividadDTO.setId(conectividad.getId());
        conectividadDTO.setDescripcion(conectividad.getDescripcion());

        return conectividadDTO;
    }
    //convierte DTO a entidad
    private Conectividad mapearEntidad(ConectividadDTO conectividadDTO) {
        Conectividad conectividad= new Conectividad();
        conectividad.setDescripcion(conectividadDTO.getDescripcion());
        return conectividad;
    }


}
