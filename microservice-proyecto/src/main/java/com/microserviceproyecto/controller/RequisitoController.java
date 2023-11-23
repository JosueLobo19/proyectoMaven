package com.microserviceproyecto.controller;

import com.microserviceproyecto.models.Dto.RequisitoDTO;
import com.microserviceproyecto.models.Service.RequisitoService;
import jakarta.validation.Valid;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proyecto/requisito")
@CrossOrigin
public class RequisitoController {


    @Autowired
    private RequisitoService requisitoService;

    private static JSONObject json;

    @GetMapping()
    public ResponseEntity<List<RequisitoDTO>> obtenerListadoRequisitos() {
        return ResponseEntity.ok(requisitoService.listadoRequisito());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RequisitoDTO> obtenerListadoRequisitosPorID(@PathVariable(name = "id") long id) {

        return ResponseEntity.ok(requisitoService.obtenerRequisitoPorID(id));
    }

    @PostMapping
    public ResponseEntity<RequisitoDTO> guardarRequisito(@RequestBody RequisitoDTO requisitoDTO) {

        return new ResponseEntity<>(requisitoService.crearRequisito(requisitoDTO), HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    public ResponseEntity<RequisitoDTO> actualizarRequisito(@Valid @RequestBody RequisitoDTO requisitoDTO,
                                                          @PathVariable(name = "id") long id) {

        RequisitoDTO requisitoDTOActualizado = requisitoService.actualizarRequisito(requisitoDTO, id);
        return new ResponseEntity<>(requisitoDTOActualizado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarRequisito(@PathVariable(name = "id") long id) {

        requisitoService.eliminarRequisito(id);
        json=new JSONObject();
        return new ResponseEntity<>(json.put("message","Registro Eliminado exitosamente!").toString(),HttpStatus.OK);
    }
}
