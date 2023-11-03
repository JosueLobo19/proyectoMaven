package com.microservice.authservice.models.dao;

import com.microservice.authservice.models.entity.Conectividad;
import com.microservice.authservice.models.entity.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IConectividadDAO extends JpaRepository<Conectividad,Long> {
    Optional<Conectividad> findById(Long id);
}
