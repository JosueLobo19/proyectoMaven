package com.microservices.authuserrol.models.repository;

import com.microservices.authuserrol.models.entity.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IRolRepository extends JpaRepository<Rol,Long> {
    Optional<Rol> findByNombre(String nombre);
    Optional<Rol> findById(Long id);
}
