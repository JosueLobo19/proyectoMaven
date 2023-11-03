package com.microservice.user.models.dao;

import com.microservice.user.models.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IUsuarioDao extends JpaRepository<Usuario,Long> {

     List<Usuario> findByPersonaId(long personaId);


     Optional<Usuario> findByUsername(String username);

     Boolean existsByUsername(String username);
}
