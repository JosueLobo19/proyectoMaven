package com.microservice.user.models.service;

import com.microservice.user.models.dao.IAreaDao;
import com.microservice.user.models.dao.IEmpresaDao;
import com.microservice.user.models.dto.AreaDTO;
import com.microservice.user.models.entity.Area;
import com.microservice.user.models.entity.Empresa;
import com.microservice.user.models.errors.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AreaServiceImpl implements AreaService{

    @Autowired
    private IAreaDao areaDao;

    @Autowired
    private IEmpresaDao empresaDao;

    @Override
    public AreaDTO crearArea(AreaDTO areaDTO) {
        //convertion de dto a entidad
        Area area= mapearENTIDAD(areaDTO);


        Area nuevaArea= areaDao.save(area);

        AreaDTO nuevaAreaDto= mapearDTO(nuevaArea);

        return nuevaAreaDto;
    }

    @Override
    public List<AreaDTO> listadoArea() {
        List<Area> listadoArea=areaDao.findAll();
        return listadoArea.stream().map(this::mapearDTO).collect(Collectors.toList());
    }

    @Override
    public AreaDTO obtenerAreaPorID(long id) {
        Area area=areaDao.findById(id).orElseThrow(()->new ResourceNotFoundException("Area", "id", id));
        return mapearDTO(area);
    }

    @Override
    public AreaDTO actualizarArea(AreaDTO areaDTO, long id) {
        Area area=areaDao.findById(id).orElseThrow(()->new ResourceNotFoundException("Area", "id", id));
        Empresa empresa=empresaDao.findById(areaDTO.getIdEmpresa()).orElseThrow(()->new ResourceNotFoundException("Empresa", "id", areaDTO.getIdEmpresa()));
        area.setDescripcion(areaDTO.getDescripcion());
        area.setEstado(areaDTO.getEstado());
        area.setEmpresa(empresa);
        areaDao.save(area);
        return mapearDTO(area);
    }

    @Override
    public void eliminarArea(long id) {
        Area area=areaDao.findById(id).orElseThrow(()->new ResourceNotFoundException("Area", "id", id));
        areaDao.delete(area);
    }

    private AreaDTO mapearDTO(Area area){
        AreaDTO areaDTO= new AreaDTO();
        areaDTO.setId(area.getId());
        areaDTO.setDescripcion(area.getDescripcion());
        areaDTO.setEstado(area.getEstado());
        areaDTO.setIdEmpresa(area.getEmpresa().getId());
     return areaDTO;
    }

    private Area mapearENTIDAD(AreaDTO areaDTO){
        Area area=new Area();
        Empresa empresa=empresaDao.findById(areaDTO.getIdEmpresa()).orElseThrow(()->new ResourceNotFoundException("Empresa", "id", areaDTO.getIdEmpresa()));
        area.setDescripcion(areaDTO.getDescripcion());
        area.setEstado(areaDTO.getEstado());
        area.setEmpresa(empresa);
        return area;
    }

}
