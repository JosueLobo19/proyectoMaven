package com.microserviceproyecto.models.Repository;

import com.microserviceproyecto.models.Entity.Fase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFaseRepository extends JpaRepository<Fase,Long> {
}
