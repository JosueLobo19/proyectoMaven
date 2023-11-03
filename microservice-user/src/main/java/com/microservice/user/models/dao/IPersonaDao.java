package com.microservice.user.models.dao;

import com.microservice.user.models.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonaDao extends JpaRepository<Persona,Long> {
}
