package com.microserviceplantillasreport.models.repository;

import com.microserviceplantillasreport.models.entity.PlantillaDocumento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPlantillaDocumentoRepository extends JpaRepository<PlantillaDocumento,Long> {
}
