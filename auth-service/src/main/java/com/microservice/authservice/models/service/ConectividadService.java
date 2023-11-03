package com.microservice.authservice.models.service;

import com.microservice.authservice.models.dto.ConectividadDTO;

import java.util.List;

public interface ConectividadService {
    List<ConectividadDTO> obtenerListar();

}
