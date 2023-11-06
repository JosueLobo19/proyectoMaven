package com.microservices.authuserrol.models.repository;

import com.microservices.authuserrol.models.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
//@RepositoryRestResource(collectionResourceRel = "usuario",path="usuario")
public interface IUsuarioRepository extends JpaRepository<Usuario,Long> {
    Optional<Usuario> findByUserName(String username);
   // @RestResource(path = "buscar-usuario")
    //Usuario findByUsername(@Param("nombre-user") String username);

    @RestResource(path = "buscar-usuario-id")
    @Query(value = "SELECT * FROM usuario u WHERE u.id_user= ?1", nativeQuery = true)
    Usuario obtenerPorID(@Param("id-user") Long id);

    @Query(value = "SELECT * FROM usuario u WHERE u.username = ?1", nativeQuery = true)
    Usuario obtenerPorUsername(String username);
}
