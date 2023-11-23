package com.microserviceproyecto.models.Repository;

import com.microserviceproyecto.models.Entity.TipoFase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITipoFaseRepository extends JpaRepository<TipoFase,Long> {
}
