package com.microservice.user.models.service;

import com.microservice.user.models.dao.IEmpresaDao;
import com.microservice.user.models.dto.EmpresaDTO;
import com.microservice.user.models.entity.Empresa;
import com.microservice.user.models.errors.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmpresaServiceImpl implements EmpresaService{

    @Autowired
    private IEmpresaDao empresaDao;

    @Override
    public List<EmpresaDTO> listadoEmpresas() {
        List<Empresa> listaEmpresa= empresaDao.findAll();
        return listaEmpresa.stream().map(this::mapearDTO).collect(Collectors.toList());
    }

    @Override
    public EmpresaDTO obtenEmpresaID(long id_empresa) {
        Empresa empresa=empresaDao.findById(id_empresa).orElseThrow(()->new ResourceNotFoundException("Empresa", "id", id_empresa));
        return mapearDTO(empresa);
    }

    @Override
    public EmpresaDTO crearEmpresa(EmpresaDTO empresaDTO) {
        //convertion de dto a entidad
        Empresa empresa= mapearEntidad(empresaDTO);


        Empresa nuevaEmpresa= empresaDao.save(empresa);

        EmpresaDTO nuevaEmpresaDTO= mapearDTO(nuevaEmpresa);

        return nuevaEmpresaDTO;
    }

    @Override
    public EmpresaDTO actualizarEmpresa(EmpresaDTO empresaDTO, long id_empresa) {
        Empresa empresa= empresaDao.
                findById(id_empresa).orElseThrow(()->new ResourceNotFoundException("Empresa", "id", id_empresa));
        empresa.setDescripcion(empresaDTO.getDescripcion());
        empresa.setEstado(empresaDTO.getEstado());
        empresa.setFechaRegistro(empresaDTO.getFechaRegistro());
        empresa.setUserRegistro(empresaDTO.getUserRegistro());
        empresa.setFechaActualizacion(empresaDTO.getFechaActualizacion());
        empresa.setUserActualizacion(empresaDTO.getUserActualizacion());
        empresa.setRuc(empresaDTO.getRuc());

        Empresa empresaActualizada= empresaDao.save(empresa);
        return mapearDTO(empresaActualizada);
    }

    @Override
    public void eliminarEmpresa(long id_empresa) {
        System.out.println("el id empresa a eliminar es: "+ id_empresa);
        Empresa empresa= empresaDao.
                findById(id_empresa).orElseThrow(()->new ResourceNotFoundException("Empresa", "id", id_empresa));
        System.out.println("en la empresa el id es:  "+ empresa.getId());

        empresaDao.delete(empresa);
    }

    private EmpresaDTO mapearDTO(Empresa empresa) {
        EmpresaDTO empresaDTO= new EmpresaDTO();
        empresaDTO.setId(empresa.getId());
        empresaDTO.setDescripcion(empresa.getDescripcion());
        empresaDTO.setEstado(empresa.getEstado());
        empresaDTO.setFechaRegistro(empresa.getFechaRegistro());
        empresaDTO.setUserRegistro(empresa.getUserRegistro());
        empresaDTO.setFechaActualizacion(empresa.getFechaActualizacion());
        empresaDTO.setUserActualizacion(empresa.getUserActualizacion());
        empresaDTO.setRuc(empresa.getRuc());
        return empresaDTO;
    }

    private Empresa mapearEntidad(EmpresaDTO empresaDTO){
        Empresa empresa=new Empresa();
        empresa.setDescripcion(empresaDTO.getDescripcion());
        empresa.setEstado(empresaDTO.getEstado());
        empresa.setFechaRegistro(empresaDTO.getFechaRegistro());
        empresa.setUserRegistro(empresaDTO.getUserRegistro());
        empresa.setFechaActualizacion(empresaDTO.getFechaActualizacion());
        empresa.setUserActualizacion(empresaDTO.getUserActualizacion());
        empresa.setRuc(empresaDTO.getRuc());
        return empresa;
    }
}
