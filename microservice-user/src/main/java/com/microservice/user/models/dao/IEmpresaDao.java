package com.microservice.user.models.dao;

import com.microservice.user.models.entity.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEmpresaDao extends JpaRepository<Empresa,Long> {



}
