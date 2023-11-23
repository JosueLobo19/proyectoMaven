package com.microserviceprivilegios.microserviceprivilegios.models.servis;

import com.microserviceprivilegios.microserviceprivilegios.models.dto.PrivilegioRolDTO;
import com.microserviceprivilegios.microserviceprivilegios.models.entity.PrivilegioInfertaz;
import com.microserviceprivilegios.microserviceprivilegios.models.entity.PrivilegioRol;
import com.microserviceprivilegios.microserviceprivilegios.models.entity.Rol;
import com.microserviceprivilegios.microserviceprivilegios.models.errors.ResourceNotFoundException;
import com.microserviceprivilegios.microserviceprivilegios.models.repository.IOpcionesInterfazRepository;
import com.microserviceprivilegios.microserviceprivilegios.models.repository.IPrivilegioRolRepository;
import com.microserviceprivilegios.microserviceprivilegios.models.repository.IRolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PrivilegioRolImpl implements PrivilegioRolService{

    @Autowired
    private IPrivilegioRolRepository privilegioRolRepository;

    @Autowired
    private IRolRepository rolRepository;

    @Autowired
    private IOpcionesInterfazRepository opcionesInterfazRepository;

    @Override
    public PrivilegioRolDTO crearPrivRol(PrivilegioRolDTO privilegioRolDTO) {
        //convertion de dto a entidad
        PrivilegioRol privilegioRol= mapearENTIDAD(privilegioRolDTO);

        PrivilegioRol nuevoPrivilegioRol= privilegioRolRepository.save(privilegioRol);

        PrivilegioRolDTO nuevoPrivilegioRolDTO= mapearDTO(nuevoPrivilegioRol);

        return nuevoPrivilegioRolDTO;
    }

    @Override
    public List<PrivilegioRolDTO> listadoPrivRol() {
        List<PrivilegioRol> listadoPrivilegioRol=privilegioRolRepository.findAll();
        return listadoPrivilegioRol.stream().map(this::mapearDTO).collect(Collectors.toList());
    }

    @Override
    public PrivilegioRolDTO obtenerPrivRolPorID(long id) {
        PrivilegioRol privilegioRol=privilegioRolRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("PrivilegioRol", "id", id));
        return mapearDTO(privilegioRol);
    }

    @Override
    public PrivilegioRolDTO actualizarPrivRol(PrivilegioRolDTO privilegioRolDTO, long id) {
        PrivilegioRol privilegioRol=privilegioRolRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("PrivilegioRol", "id", id));

        Rol rol;
        PrivilegioInfertaz privilegioInfertaz;

        privilegioRol.setDescripcion(privilegioRolDTO.getDescripcion());
        privilegioRol.setEstado(privilegioRolDTO.getEstado());
        privilegioRol.setFechaRegistro(privilegioRolDTO.getFechaRegistro());
        privilegioRol.setUserRegistro(privilegioRolDTO.getUserRegistro());
        privilegioRol.setFechaActualizacion(privilegioRolDTO.getFechaActualizacion());
        privilegioRol.setUserActualizacion(privilegioRolDTO.getUserActualizacion());
        rol= rolRepository.findById(privilegioRolDTO.getIdRol()).orElseThrow(()->new ResourceNotFoundException("Rol", "idRol", privilegioRolDTO.getIdRol()));
        privilegioInfertaz= opcionesInterfazRepository.findById(privilegioRolDTO.getIdOpcInt()).orElseThrow(()->new ResourceNotFoundException("Opciones de interfaz", "idOpcInt", privilegioRolDTO.getIdOpcInt()));
        privilegioRol.setRol(rol);
        privilegioRol.setOpciones_interfaz(privilegioInfertaz);

        privilegioRolRepository.save(privilegioRol);
        return mapearDTO(privilegioRol);
    }

    @Override
    public void eliminarPrivRol(long id) {
        PrivilegioRol privilegioRol=privilegioRolRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("PrivilegioRol", "id", id));

        privilegioRolRepository.delete(privilegioRol);
    }
    private PrivilegioRolDTO mapearDTO(PrivilegioRol privilegioRol){
        PrivilegioRolDTO privilegioRolDTO= new PrivilegioRolDTO();
        privilegioRolDTO.setIdPrivRol(privilegioRol.getIdPrivRol());
        privilegioRolDTO.setDescripcion(privilegioRol.getDescripcion());
        privilegioRolDTO.setEstado(privilegioRol.getEstado());
        privilegioRolDTO.setFechaRegistro(privilegioRol.getFechaRegistro());
        privilegioRolDTO.setUserRegistro(privilegioRol.getUserRegistro());
        privilegioRolDTO.setFechaActualizacion(privilegioRol.getFechaActualizacion());
        privilegioRolDTO.setUserActualizacion(privilegioRol.getUserActualizacion());
        privilegioRolDTO.setRol(privilegioRol.getRol());
        privilegioRolDTO.setOpciones_interfaz(privilegioRol.getOpciones_interfaz());
        privilegioRolDTO.setIdRol(privilegioRol.getRol().getIdRol());
        privilegioRolDTO.setIdOpcInt(privilegioRol.getOpciones_interfaz().getIdOpcInt());
        return privilegioRolDTO;
    }

    private PrivilegioRol mapearENTIDAD(PrivilegioRolDTO privilegioRolDTO){
        PrivilegioRol privilegioRol=new PrivilegioRol();
        Rol rol;
        PrivilegioInfertaz privilegioInfertaz;

        privilegioRol.setDescripcion(privilegioRolDTO.getDescripcion());
        privilegioRol.setEstado(privilegioRolDTO.getEstado());
        privilegioRol.setFechaRegistro(privilegioRolDTO.getFechaRegistro());
        privilegioRol.setUserRegistro(privilegioRolDTO.getUserRegistro());
        privilegioRol.setFechaActualizacion(privilegioRolDTO.getFechaActualizacion());
        privilegioRol.setUserActualizacion(privilegioRolDTO.getUserActualizacion());
        rol= rolRepository.findById(privilegioRolDTO.getIdRol()).orElseThrow(()->new ResourceNotFoundException("Rol", "idRol", privilegioRolDTO.getIdRol()));
        privilegioInfertaz= opcionesInterfazRepository.findById(privilegioRolDTO.getIdOpcInt()).orElseThrow(()->new ResourceNotFoundException("Opciones de interfaz", "idOpcInt", privilegioRolDTO.getIdOpcInt()));
        privilegioRol.setRol(rol);
        privilegioRol.setOpciones_interfaz(privilegioInfertaz);
        return privilegioRol;
    }
}
