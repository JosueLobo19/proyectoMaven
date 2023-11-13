package com.microserviceprivilegios.microserviceprivilegios.models.repository;

import com.microserviceprivilegios.microserviceprivilegios.models.entity.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRolRepository extends JpaRepository<Rol,Long> {
}
