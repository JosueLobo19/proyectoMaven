package com.microservice.user.models.dao;

import com.microservice.user.models.entity.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IRolDao extends JpaRepository<Rol, Long> {
    Optional<Rol> findByNombre(String nombre);
    Optional<Rol> findById(Long id);
}
