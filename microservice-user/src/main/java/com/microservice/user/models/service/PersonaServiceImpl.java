package com.microservice.user.models.service;

import com.microservice.user.models.dao.IEmpresaDao;
import com.microservice.user.models.dao.IPersonaDao;
import com.microservice.user.models.dto.PersonaDTO;
import com.microservice.user.models.entity.Empresa;
import com.microservice.user.models.entity.Persona;
import com.microservice.user.models.errors.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonaServiceImpl implements PersonaService{

    @Autowired
    private IPersonaDao personaDao;

    @Autowired
    private IEmpresaDao empresaDao;

    @Override
    public PersonaDTO crearPersona(PersonaDTO personaDTO) {
        //convertion de dto a entidad
        Persona persona= mapearEntidad(personaDTO);


        Persona nuevaPersona= personaDao.save(persona);

        PersonaDTO personaRespuesta= mapearDTO(nuevaPersona);

        return personaRespuesta;
    }

    @Override
    public List<PersonaDTO> listadoPersonas() {
        List<Persona> listaPersonas= personaDao.findAll();
        return listaPersonas.stream().map(this::mapearDTO).collect(Collectors.toList());
    }

    @Override
    public PersonaDTO obtenerPersonaPorID(long id) {
        Persona persona= personaDao.
                findById(id).orElseThrow(()->new ResourceNotFoundException("Persona", "id", id));
        return mapearDTO(persona);
    }

    @Override
    public PersonaDTO actualizarPersona(PersonaDTO personaDTO, long id) {
        Persona persona= personaDao.
                findById(id).orElseThrow(()->new ResourceNotFoundException("Persona", "id", id));
        persona.setNombres(personaDTO.getNombres());
        persona.setApellidos(personaDTO.getApellidos());
        persona.setNumDocumento(personaDTO.getNumDocumento());
        persona.setCorreoElect(personaDTO.getCorreoElect());
        persona.setCelular(personaDTO.getCelular());
        persona.setDireccion(personaDTO.getDireccion());
        persona.setUbigeo(personaDTO.getUbigeo());
        persona.setTelFijo(personaDTO.getTelFijo());
        persona.setDireccion(personaDTO.getDireccion());

        Persona personaActualizada= personaDao.save(persona);
        return mapearDTO(personaActualizada);
    }

    @Override
    public void eliminarPersona(long id) {
        Persona persona= personaDao.
                findById(id).orElseThrow(()->new ResourceNotFoundException("Persona", "id", id));
        personaDao.delete(persona);
    }


    //convierte entidad a DTO
    private PersonaDTO mapearDTO(Persona persona) {
        PersonaDTO personaDTO= new PersonaDTO();
        personaDTO.setIdPersona(persona.getId());
        personaDTO.setNombres(persona.getNombres());
        personaDTO.setApellidos(persona.getApellidos());
        personaDTO.setNumDocumento(persona.getNumDocumento());
        personaDTO.setCorreoElect(persona.getCorreoElect());
        personaDTO.setCelular(persona.getCelular());
        personaDTO.setUbigeo(persona.getUbigeo());
        personaDTO.setTelFijo(persona.getTelFijo());
        personaDTO.setDireccion(persona.getDireccion());
        personaDTO.setCip(persona.getCip());
        personaDTO.setCargo(persona.getCargo());
        personaDTO.setEstado(persona.getEstado());
        personaDTO.setFechaRegistro(persona.getFechaRegistro());
        personaDTO.setUserRegistro(persona.getUserRegistro());
        personaDTO.setFechaActualizacion(persona.getFechaActualizacion());
        personaDTO.setUserActualizacion(persona.getUserActualizacion());
        personaDTO.setIdEmpresa(persona.getEmpresa().getId());
        return personaDTO;
    }
    //convierte DTO a entidad
    private Persona mapearEntidad(PersonaDTO personaDTO) {
        Persona persona= new Persona();
        Empresa empresa=new Empresa();
        empresa = empresaDao.findById(personaDTO.getIdEmpresa()).
                orElseThrow(()->new ResourceNotFoundException("Empresa", "idEmpresa", personaDTO.getIdPersona()));
        persona.setNombres(personaDTO.getNombres());
        persona.setApellidos(personaDTO.getApellidos());
        persona.setNumDocumento(personaDTO.getNumDocumento());
        persona.setCorreoElect(personaDTO.getCorreoElect());
        persona.setCelular(personaDTO.getCelular());
        persona.setDireccion(personaDTO.getDireccion());
        persona.setUbigeo(personaDTO.getUbigeo());
        persona.setTelFijo(personaDTO.getTelFijo());
        persona.setCip(personaDTO.getCip());
        persona.setCargo(personaDTO.getCargo());
        persona.setEstado(personaDTO.getEstado());
        persona.setFechaRegistro(personaDTO.getFechaRegistro());
        persona.setUserRegistro(personaDTO.getUserRegistro());
        persona.setFechaActualizacion(personaDTO.getFechaActualizacion());
        persona.setUserActualizacion(personaDTO.getUserActualizacion());
        persona.setEmpresa(empresa);
        return persona;

    }
}
