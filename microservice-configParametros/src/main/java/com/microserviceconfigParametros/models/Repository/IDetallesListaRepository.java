package com.microserviceconfigParametros.models.Repository;

import com.microserviceconfigParametros.models.entity.DetalleLista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDetallesListaRepository extends JpaRepository<DetalleLista,Long> {
    @Query(value = "select dl.id_det_lista,dl.descripcion, dl.estado, dl.fecha_upd, dl.fecha_registro, dl.user_upd, dl.user_registro, dl.valor, dl.id_lista from lista as l inner join detalle_lista as dl on l.id_lista=dl.id_lista where dl.id_lista= ?1", nativeQuery = true)
    List<DetalleLista> obtenerDetallePorIDLista(Long idLista);

    @Query(value = "select dl.id_det_lista,dl.descripcion, dl.estado, dl.fecha_upd, dl.fecha_registro, dl.user_upd, dl.user_registro, dl.valor, dl.id_lista from lista as l inner join detalle_lista as dl on l.id_lista=dl.id_lista where l.descripcion= ?1", nativeQuery = true)
    List<DetalleLista> obtenerPorDescripcionLista(String descripcionLista);
}
