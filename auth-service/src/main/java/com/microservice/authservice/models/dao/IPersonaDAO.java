package com.microservice.authservice.models.dao;

import com.microservice.authservice.models.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonaDAO extends JpaRepository<Persona,Long> {

}
