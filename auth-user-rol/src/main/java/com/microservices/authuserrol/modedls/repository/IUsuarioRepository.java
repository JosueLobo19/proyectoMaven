package com.microservices.authuserrol.modedls.repository;

import com.microservices.authuserrol.modedls.entity.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "usuario",path="usuario")
public interface IUsuarioRepository extends PagingAndSortingRepository<Usuario,Long> {

    Usuario findByUsername(String username);

    @Query(value = "SELECT * FROM usuario u WHERE u.username = ?1", nativeQuery = true)
    Usuario obtenerPorUsername(String username);
}
