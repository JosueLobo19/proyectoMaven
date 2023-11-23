package com.microserviceconfigParametros.controller;

import com.microserviceconfigParametros.models.dto.DetalleListaDTO;
import com.microserviceconfigParametros.models.dto.ListaDTO;
import com.microserviceconfigParametros.models.service.DetalleListaService;
import jakarta.validation.Valid;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/listaParametros/detalle")
@CrossOrigin
public class DetalleListaController {

    @Autowired
    private DetalleListaService detalleListaService;

    private static JSONObject json;

    @GetMapping()
    public ResponseEntity<List<DetalleListaDTO>> obtenerDetalleListado() {
        return ResponseEntity.ok(detalleListaService.listadoDetalleListas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleListaDTO> obtenerDetalleListaPorID(@PathVariable(name = "id") long id) {

        return ResponseEntity.ok(detalleListaService.obtenerDetalleListasPorID(id));
    }

    @GetMapping("/busqueda-id-lista/{id}")
    public ResponseEntity<List<DetalleListaDTO>> obtenerDetalleListaPorIDLista(@PathVariable(name = "id") long id) {

        return ResponseEntity.ok(detalleListaService.obtenerDetalleListasPorIDLista(id));
    }

    @GetMapping("/busqueda-descripcion-lista/{descripcion}")
    public ResponseEntity<List<DetalleListaDTO>> obtenerDetalleListaPorDescripcionLista(@PathVariable(name = "descripcion") String descripcion) {

        return ResponseEntity.ok(detalleListaService.obtenerDetalleListasPorDescripcionLista(descripcion));
    }
    @PostMapping
    public ResponseEntity<DetalleListaDTO> guardarListas(@Valid @RequestBody DetalleListaDTO detalleListaDTO) {

        return new ResponseEntity<>(detalleListaService.crearDetalleLista(detalleListaDTO), HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    public ResponseEntity<DetalleListaDTO> actualizarDetalleLista(@Valid @RequestBody DetalleListaDTO detalleListaDTO,
                                                    @PathVariable(name = "id") long id) {

        DetalleListaDTO detalleListaDTOActualizada = detalleListaService.actualizarDetalleLista(detalleListaDTO, id);
        return new ResponseEntity<>(detalleListaDTOActualizada, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarDetalleLista(@PathVariable(name = "id") long id) {

        detalleListaService.eliminarDetalleLista(id);
        json=new JSONObject();
        return new ResponseEntity<>(json.put("message","Registro Eliminado exitosamente!").toString(),HttpStatus.OK);
    }
}
