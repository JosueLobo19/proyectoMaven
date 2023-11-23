package com.microserviceproyecto.models.Repository;

import com.microserviceproyecto.models.Entity.Actividad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IActividadRepository extends JpaRepository<Actividad,Long> {
}
