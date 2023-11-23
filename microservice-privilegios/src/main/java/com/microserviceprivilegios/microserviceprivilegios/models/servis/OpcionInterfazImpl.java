package com.microserviceprivilegios.microserviceprivilegios.models.servis;

import com.microserviceprivilegios.microserviceprivilegios.models.dto.PrivilegioInterfazDTO;
import com.microserviceprivilegios.microserviceprivilegios.models.entity.PrivilegioInfertaz;
import com.microserviceprivilegios.microserviceprivilegios.models.errors.ResourceNotFoundException;
import com.microserviceprivilegios.microserviceprivilegios.models.repository.IOpcionesInterfazRepository;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OpcionInterfazImpl implements OpcionInterfazService{

    @Autowired
    private IOpcionesInterfazRepository opcionesInterfazRepository;

    public PrivilegioInterfazDTO crearOpcInt(PrivilegioInterfazDTO privilegioInterfazDTO) {
        //convertion de dto a entidad
        PrivilegioInfertaz privilegioInfertaz= mapearENTIDAD(privilegioInterfazDTO);


        PrivilegioInfertaz nueviPrivilegioInterfaz= opcionesInterfazRepository.save(privilegioInfertaz);

        PrivilegioInterfazDTO nuevoPrivilegioInterfazDTO= mapearDTO(nueviPrivilegioInterfaz);

        return nuevoPrivilegioInterfazDTO;
    }

    @Override
    public List<PrivilegioInterfazDTO> listadoOpcInt() {
        List<PrivilegioInfertaz> listadoOpcionesInterfaz=opcionesInterfazRepository.findAll();
        return listadoOpcionesInterfaz.stream().map(this::mapearDTO).collect(Collectors.toList());
    }

    @Override
    public PrivilegioInterfazDTO obtenerOpcIntPorID(long id) {
        PrivilegioInfertaz opcionesInterfaz=opcionesInterfazRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("PrivilegioInfertaz", "id", id));
        return mapearDTO(opcionesInterfaz);
    }

    @Override
    public PrivilegioInterfazDTO actualizarOpcInt(PrivilegioInterfazDTO privilegioInterfazDTO, long id) {
        PrivilegioInfertaz privilegioInfertaz=opcionesInterfazRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("PrivilegioInfertaz", "id", id));
        privilegioInfertaz.setDescripcion(privilegioInterfazDTO.getDescripcion());
        privilegioInfertaz.setEstado(privilegioInterfazDTO.getEstado());
        privilegioInfertaz.setNivel(privilegioInterfazDTO.getNivel());
        privilegioInfertaz.setIdPadre(privilegioInterfazDTO.getIdPadre());
        privilegioInfertaz.setFechaRegistro(privilegioInterfazDTO.getFechaRegistro());
        privilegioInfertaz.setUserRegistro(privilegioInterfazDTO.getUserRegistro());
        privilegioInfertaz.setFechaActualizacion(privilegioInterfazDTO.getFechaActualizacion());
        privilegioInfertaz.setUserActualizacion(privilegioInterfazDTO.getUserActualizacion());
        opcionesInterfazRepository.save(privilegioInfertaz);
        return mapearDTO(privilegioInfertaz);
    }

    @Override
    public void eliminarOpcInt(long id) {
        PrivilegioInfertaz privilegioInfertaz=opcionesInterfazRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("PrivilegioInfertaz", "id", id));
        opcionesInterfazRepository.delete(privilegioInfertaz);
    }

    private PrivilegioInterfazDTO mapearDTO(PrivilegioInfertaz privilegioInfertaz){
        PrivilegioInterfazDTO privilegioInterfazDTO= new PrivilegioInterfazDTO();
        privilegioInterfazDTO.setIdOpcInt(privilegioInfertaz.getIdOpcInt());
        privilegioInterfazDTO.setDescripcion(privilegioInfertaz.getDescripcion());
        privilegioInterfazDTO.setEstado(privilegioInfertaz.getEstado());
        privilegioInterfazDTO.setNivel(privilegioInfertaz.getNivel());
        privilegioInterfazDTO.setIdPadre(privilegioInfertaz.getIdPadre());
        privilegioInterfazDTO.setFechaRegistro(privilegioInfertaz.getFechaRegistro());
        privilegioInterfazDTO.setUserRegistro(privilegioInfertaz.getUserRegistro());
        privilegioInterfazDTO.setFechaActualizacion(privilegioInfertaz.getFechaActualizacion());
        privilegioInterfazDTO.setUserActualizacion(privilegioInfertaz.getUserActualizacion());

        return privilegioInterfazDTO;
    }

    private PrivilegioInfertaz mapearENTIDAD(PrivilegioInterfazDTO privilegioInterfazDTO){
        PrivilegioInfertaz privilegioInfertaz=new PrivilegioInfertaz();
        privilegioInfertaz.setDescripcion(privilegioInterfazDTO.getDescripcion());
        privilegioInfertaz.setEstado(privilegioInterfazDTO.getEstado());
        privilegioInfertaz.setNivel(privilegioInterfazDTO.getNivel());
        privilegioInfertaz.setIdPadre(privilegioInterfazDTO.getIdPadre());
        privilegioInfertaz.setFechaRegistro(privilegioInterfazDTO.getFechaRegistro());
        privilegioInfertaz.setUserRegistro(privilegioInterfazDTO.getUserRegistro());
        privilegioInfertaz.setFechaActualizacion(privilegioInterfazDTO.getFechaActualizacion());
        privilegioInfertaz.setUserActualizacion(privilegioInterfazDTO.getUserActualizacion());
        return privilegioInfertaz;
    }
}
