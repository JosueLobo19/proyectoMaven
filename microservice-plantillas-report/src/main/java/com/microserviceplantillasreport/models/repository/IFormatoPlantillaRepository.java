package com.microserviceplantillasreport.models.repository;

import com.microserviceplantillasreport.models.entity.FormatoPlantilla;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFormatoPlantillaRepository extends JpaRepository<FormatoPlantilla,Long> {
}
