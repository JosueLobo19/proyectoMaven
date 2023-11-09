package com.microservices.authuserrol.models.repository;

import com.microservices.authuserrol.models.entity.RolEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IRolRepository extends JpaRepository<RolEntidad,Long> {
    Optional<RolEntidad> findByNombre(String nombre);
    Optional<RolEntidad> findById(Long id);
}
