package com.microservice.user.models.service;

import com.microservice.user.models.dto.EmpresaDTO;
import com.microservice.user.models.entity.Empresa;

import java.util.List;

public interface EmpresaService {

    List<EmpresaDTO> listadoEmpresas();
    EmpresaDTO obtenEmpresaID(long id_empresa);

    EmpresaDTO crearEmpresa(EmpresaDTO empresaDTO);

    EmpresaDTO actualizarEmpresa(EmpresaDTO empresaDTO, long id_empresa);

    void eliminarEmpresa(long id_empresa);
}
