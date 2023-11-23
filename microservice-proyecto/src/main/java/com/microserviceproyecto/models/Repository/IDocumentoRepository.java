package com.microserviceproyecto.models.Repository;

import com.microserviceproyecto.models.Entity.Documento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IDocumentoRepository extends JpaRepository<Documento,Long> {

    @Query(value = "select top 1 case when (select  count(id_documento) from documento) is null then 1 else (select count(id_documento)+1 from documento) end as conteo", nativeQuery = true)
    Long conteoDocumento();
}
