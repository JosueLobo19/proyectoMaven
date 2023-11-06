package com.microservices.authuserrol.models.repository;

import com.microservices.authuserrol.models.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonaRepository extends JpaRepository<Persona,Long> {
}
