package com.microservice.user.models.service;

import com.microservice.user.models.dto.PersonaDTO;

import java.util.List;

public interface PersonaService {
    PersonaDTO crearPersona(PersonaDTO personaDTO);

    List<PersonaDTO> listadoPersonas();
    PersonaDTO obtenerPersonaPorID(long id);
    PersonaDTO actualizarPersona(PersonaDTO personaDTO, long id);
    void eliminarPersona(long id);
}
