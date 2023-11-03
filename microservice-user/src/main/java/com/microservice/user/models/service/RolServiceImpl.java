package com.microservice.user.models.service;
import com.microservice.user.models.entity.Rol;
import com.microservice.user.models.dao.IRolDao;
import com.microservice.user.models.dto.RolDTO;
import com.microservice.user.models.errors.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RolServiceImpl implements RolService {

    @Autowired
    private IRolDao rolDAO;

    @Override
    public RolDTO crearRol(RolDTO rolDTO) {
        //convertion de dto a entidad
        Rol rol= mapearEntidad(rolDTO);


        Rol nuevoRol= rolDAO.save(rol);

        RolDTO rolRespuesta= mapearDTO(nuevoRol);

        return rolRespuesta;
    }

    @Override
    public RolDTO obtenerRolPorID(long id) {
        Rol rol= rolDAO.
                findById(id).orElseThrow(()->new ResourceNotFoundException("Rol", "idRol", id));
        return mapearDTO(rol);
    }

    @Override
    public List<RolDTO> obtenerRolListar() {
        List<Rol> listaDeRoles = rolDAO.findAll();
       return listaDeRoles.stream().map(rol -> mapearDTO(rol)).collect(Collectors.toList());
    }

    @Override
    public RolDTO actualizarRol(RolDTO rolDTO, long id) {
        Rol rol= rolDAO.
                findById(id).orElseThrow(()->new ResourceNotFoundException("Rol", "id_rol", id));
        rol.setNombre(rolDTO.getNombre());
        rol.setEstado(rolDTO.getEstado());
        rol.setFechaRegistro(rolDTO.getFechaRegistro());


        Rol rolActualizado= rolDAO.save(rol);
        return mapearDTO(rolActualizado);
    }

    @Override
    public void eliminarRol(long id) {
        Rol rol= rolDAO.
                findById(id).orElseThrow(()->new ResourceNotFoundException("Rol", "id_rol", id));
        rolDAO.delete(rol);
    }


    //convierte entidad a DTO
    private RolDTO mapearDTO(Rol rol) {
        RolDTO rolDTO= new RolDTO();
        rolDTO.setIdRol(rol.getIdRol());
        rolDTO.setNombre(rol.getNombre());
        rolDTO.setEstado(rol.getEstado());
        rolDTO.setFechaRegistro(rol.getFechaRegistro());
        return rolDTO;
    }
    //convierte DTO a entidad
    private Rol mapearEntidad(RolDTO rolDTO) {
        Rol rol= new Rol();
        rol.setNombre(rolDTO.getNombre());
        rol.setEstado(rolDTO.getEstado());
        rol.setFechaRegistro(rolDTO.getFechaRegistro());
        return rol;
    }


}
