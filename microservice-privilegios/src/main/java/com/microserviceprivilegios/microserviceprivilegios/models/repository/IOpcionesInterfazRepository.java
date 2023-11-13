package com.microserviceprivilegios.microserviceprivilegios.models.repository;

import com.microserviceprivilegios.microserviceprivilegios.models.entity.PrivilegioInfertaz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOpcionesInterfazRepository extends JpaRepository<PrivilegioInfertaz,Long> {
}
