package com.microserviceprivilegios.microserviceprivilegios.models.repository;

import com.microserviceprivilegios.microserviceprivilegios.models.entity.PrivilegioRol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPrivilegioRolRepository extends JpaRepository<PrivilegioRol,Long> {
}
