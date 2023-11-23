package com.microserviceproyecto.models.Service;

import com.microserviceproyecto.models.Dto.ProyectoDTO;
import com.microserviceproyecto.models.Entity.Proyecto;
import com.microserviceproyecto.models.Error.ResourceNotFoundException;
import com.microserviceproyecto.models.Repository.IProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProyectoServiceImpl implements ProyectoService {

    @Autowired

    private IProyectoRepository proyectoRepository;

    @Override
    public ProyectoDTO crearProyecto(ProyectoDTO proyectoDTO) {
        //convertion de dto a entidad
        Proyecto proyecto= mapearENTIDAD(proyectoDTO);


        Proyecto nuevoProyecto= proyectoRepository.save(proyecto);

        ProyectoDTO nuevoProyectoDTO= mapearDTO(nuevoProyecto);

        proyectoDTO=actualizarProyecto(nuevoProyectoDTO, nuevoProyectoDTO.getId());
        return proyectoDTO;
    }

    @Override
    public List<ProyectoDTO> listadoProyectos() {
        List<Proyecto> listadoProyectos=proyectoRepository.findAll();
        return listadoProyectos.stream().map(this::mapearDTO).collect(Collectors.toList());
    }

    @Override
    public ProyectoDTO obtenerPropyectoPorID(long id) {
        Proyecto proyecto=proyectoRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("proyecto", "id", id));
        return mapearDTO(proyecto);
    }

    @Override
    public ProyectoDTO actualizarProyecto(ProyectoDTO proyectoDTO, long id) {

        Proyecto proyecto=proyectoRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("proyecto", "id", id));
        return actualizar(proyecto,proyectoDTO);
    }

    @Override
    public void eliminarProyecto(long id) {
        Proyecto proyecto
                =proyectoRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Proyecto", "id", id));
        proyectoRepository.delete(proyecto);
    }



    private ProyectoDTO mapearDTO(Proyecto proyecto){
        ProyectoDTO proyectoDTO= new ProyectoDTO();
        proyectoDTO.setId(proyecto.getId());
        proyectoDTO.setCodGenerado(proyecto.getCodGenerado());
        proyectoDTO.setFinalidadProyecto(proyecto.getFinalidadProyecto());
        proyectoDTO.setEstado(proyecto.getEstado());
        proyectoDTO.setSupervisorGDPE(proyecto.getSupervisorGDPE());
        proyectoDTO.setIdEmpresaProyectista(proyecto.getIdEmpresaProyectista());
        proyectoDTO.setIdPersonaProyectista(proyecto.getIdPersonaProyectista());
        proyectoDTO.setNombreProyecto(proyecto.getNombreProyecto());
        proyectoDTO.setDepartamento(proyecto.getDepartamento());
        proyectoDTO.setProvincia(proyecto.getProvincia());
        proyectoDTO.setDistrito(proyecto.getDistrito());
        proyectoDTO.setUbigeo(proyecto.getUbigeo());
        proyectoDTO.setLocalidad(proyecto.getLocalidad());
        proyectoDTO.setIdSistema(proyecto.getIdSistema());
        proyectoDTO.setCoordUtmX(proyecto.getCoordUtmX());
        proyectoDTO.setCoordUtmY(proyecto.getCoordUtmY());
        proyectoDTO.setCoordUtmY(proyecto.getCoordUtmY());
        proyectoDTO.setUbicacionProyecto(proyecto.getUbicacionProyecto());
        proyectoDTO.setIdPersonaInteresada(proyecto.getIdPersonaInteresada());
        proyectoDTO.setIdTipoProyecto(proyecto.getIdTipoProyecto());
        proyectoDTO.setIdTipoFinanciamiento(proyecto.getIdTipoFinanciamiento());
        proyectoDTO.setDetalleFinanciamiento(proyecto.getDetalleFinanciamiento());
        proyectoDTO.setCantidadBeneficiarios(proyecto.getCantidadBeneficiarios());
        proyectoDTO.setDemPotencia(proyecto.getDemPotencia());
        proyectoDTO.setNivelTension(proyecto.getNivelTension());
        proyectoDTO.setLongitudProyecto(proyecto.getLongitudProyecto());
        proyectoDTO.setInversion(proyecto.getInversion());
        proyectoDTO.setUserRegistro(proyecto.getUserRegistro());
        proyectoDTO.setFechaRegistro(proyecto.getFechaRegistro());
        proyectoDTO.setUserActualizacion(proyecto.getUserActualizacion());
        proyectoDTO.setFechaActualizacion(proyecto.getFechaActualizacion());

        return proyectoDTO;
    }

    private Proyecto mapearENTIDAD(ProyectoDTO proyectoDTO){
        Proyecto proyecto=new Proyecto();
        proyecto.setCodGenerado("prueba");
        proyecto.setFinalidadProyecto(proyectoDTO.getFinalidadProyecto());
        proyecto.setEstado(proyectoDTO.getEstado());
        proyecto.setSupervisorGDPE(proyectoDTO.getSupervisorGDPE());
        proyecto.setIdEmpresaProyectista(proyectoDTO.getIdEmpresaProyectista());
        proyecto.setIdPersonaProyectista(proyectoDTO.getIdPersonaProyectista());
        proyecto.setNombreProyecto(proyectoDTO.getNombreProyecto());
        proyecto.setDepartamento(proyectoDTO.getDepartamento());
        proyecto.setProvincia(proyectoDTO.getProvincia());
        proyecto.setDistrito(proyectoDTO.getDistrito());
        proyecto.setUbigeo(proyectoDTO.getUbigeo());
        proyecto.setLocalidad(proyectoDTO.getLocalidad());
        proyecto.setIdSistema(proyectoDTO.getIdSistema());
        proyecto.setCoordUtmX(proyectoDTO.getCoordUtmX());
        proyecto.setCoordUtmY(proyectoDTO.getCoordUtmY());
        proyecto.setCoordUtmY(proyectoDTO.getCoordUtmY());
        proyecto.setUbicacionProyecto(proyectoDTO.getUbicacionProyecto());
        proyecto.setIdPersonaInteresada(proyectoDTO.getIdPersonaInteresada());
        proyecto.setIdTipoProyecto(proyectoDTO.getIdTipoProyecto());
        proyecto.setIdTipoFinanciamiento(proyectoDTO.getIdTipoFinanciamiento());
        proyecto.setDetalleFinanciamiento(proyectoDTO.getDetalleFinanciamiento());
        proyecto.setCantidadBeneficiarios(proyectoDTO.getCantidadBeneficiarios());
        proyecto.setDemPotencia(proyectoDTO.getDemPotencia());
        proyecto.setNivelTension(proyectoDTO.getNivelTension());
        proyecto.setLongitudProyecto(proyectoDTO.getLongitudProyecto());
        proyecto.setInversion(proyectoDTO.getInversion());
        proyecto.setUserRegistro(proyectoDTO.getUserRegistro());
        proyecto.setFechaRegistro(proyectoDTO.getFechaRegistro());
        proyecto.setUserActualizacion(proyectoDTO.getUserActualizacion());
        proyecto.setFechaActualizacion(proyectoDTO.getFechaActualizacion());

        return proyecto;
    }

    private ProyectoDTO actualizar(Proyecto proyecto, ProyectoDTO proyectoDTO){
        String codigoGenerado;
        if(proyecto.getCodGenerado().equals("prueba"))
        {
            codigoGenerado="ELPU-"+proyecto.getId()+"-FP";
            proyecto.setCodGenerado(codigoGenerado);
        }
        else
        {proyecto.setCodGenerado(proyectoDTO.getCodGenerado());  }

        proyecto.setFinalidadProyecto(proyectoDTO.getFinalidadProyecto());
        proyecto.setEstado(proyectoDTO.getEstado());
        proyecto.setSupervisorGDPE(proyectoDTO.getSupervisorGDPE());
        proyecto.setIdEmpresaProyectista(proyectoDTO.getIdEmpresaProyectista());
        proyecto.setIdPersonaProyectista(proyectoDTO.getIdPersonaProyectista());
        proyecto.setNombreProyecto(proyectoDTO.getNombreProyecto());
        proyecto.setDepartamento(proyectoDTO.getDepartamento());
        proyecto.setProvincia(proyectoDTO.getProvincia());
        proyecto.setDistrito(proyectoDTO.getDistrito());
        proyecto.setUbigeo(proyectoDTO.getUbigeo());
        proyecto.setLocalidad(proyectoDTO.getLocalidad());
        proyecto.setIdSistema(proyectoDTO.getIdSistema());
        proyecto.setCoordUtmX(proyectoDTO.getCoordUtmX());
        proyecto.setCoordUtmY(proyectoDTO.getCoordUtmY());
        proyecto.setCoordUtmY(proyectoDTO.getCoordUtmY());
        proyecto.setUbicacionProyecto(proyectoDTO.getUbicacionProyecto());
        proyecto.setIdPersonaInteresada(proyectoDTO.getIdPersonaInteresada());
        proyecto.setIdTipoProyecto(proyectoDTO.getIdTipoProyecto());
        proyecto.setIdTipoFinanciamiento(proyectoDTO.getIdTipoFinanciamiento());
        proyecto.setDetalleFinanciamiento(proyectoDTO.getDetalleFinanciamiento());
        proyecto.setCantidadBeneficiarios(proyectoDTO.getCantidadBeneficiarios());
        proyecto.setDemPotencia(proyectoDTO.getDemPotencia());
        proyecto.setNivelTension(proyectoDTO.getNivelTension());
        proyecto.setLongitudProyecto(proyectoDTO.getLongitudProyecto());
        proyecto.setInversion(proyectoDTO.getInversion());
        proyecto.setUserRegistro(proyectoDTO.getUserRegistro());
        proyecto.setFechaRegistro(proyectoDTO.getFechaRegistro());
        proyecto.setUserActualizacion(proyectoDTO.getUserActualizacion());
        proyecto.setFechaActualizacion(proyectoDTO.getFechaActualizacion());
        proyectoRepository.save(proyecto);
        return mapearDTO(proyecto);
    }
}
