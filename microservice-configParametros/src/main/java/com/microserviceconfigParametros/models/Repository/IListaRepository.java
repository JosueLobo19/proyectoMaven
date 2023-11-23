package com.microserviceconfigParametros.models.Repository;

import com.microserviceconfigParametros.models.entity.Lista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IListaRepository extends JpaRepository<Lista,Long> {
}
