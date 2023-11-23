package com.microserviceproyecto.models.Repository;

import com.microserviceproyecto.models.Entity.Requisito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRequisitoRepository extends JpaRepository<Requisito, Long> {
}
