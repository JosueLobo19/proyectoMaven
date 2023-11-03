package com.microservice.authservice.models.dao;

import com.microservice.authservice.models.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPruebaDAO extends JpaRepository<Usuario,Long> {
}
