package com.microserviceconfigParametros.controller;

import com.microserviceconfigParametros.models.dto.ListaDTO;
import com.microserviceconfigParametros.models.service.ListaService;
import jakarta.validation.Valid;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/listaParametros/lista")
@CrossOrigin
public class ListaController {

    @Autowired
    private ListaService listaService;

    private static JSONObject json;

    @GetMapping()
    public ResponseEntity<List<ListaDTO>> obtenerListado() {
        return ResponseEntity.ok(listaService.listadoListas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ListaDTO> obtenerListaPorID(@PathVariable(name = "id") long id) {

        return ResponseEntity.ok(listaService.obtenerListaPorID(id));
    }

    @PostMapping
    public ResponseEntity<ListaDTO> guardarListas(@Valid @RequestBody ListaDTO listaDTO) {

        return new ResponseEntity<>(listaService.crearLista(listaDTO), HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    public ResponseEntity<ListaDTO> actualizarLista(@Valid @RequestBody ListaDTO listaDTO,
                                                              @PathVariable(name = "id") long id) {

        ListaDTO listaDTOActualizado = listaService.actualizarLista(listaDTO, id);
        return new ResponseEntity<>(listaDTOActualizado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarDetalleLista(@PathVariable(name = "id") long id) {

        listaService.eliminarLista(id);
        json=new JSONObject();
        return new ResponseEntity<>(json.put("message","Registro Eliminado exitosamente!").toString(),HttpStatus.OK);
    }

}
