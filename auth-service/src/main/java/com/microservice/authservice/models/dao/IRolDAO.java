package com.microservice.authservice.models.dao;

import com.microservice.authservice.models.entity.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IRolDAO extends JpaRepository<Rol, Long> {
    Optional<Rol> findByNombre(String nombre);
    Optional<Rol> findById(Long id);
}
