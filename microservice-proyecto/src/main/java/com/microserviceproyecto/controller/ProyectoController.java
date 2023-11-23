package com.microserviceproyecto.controller;

import com.microserviceproyecto.models.Dto.ProyectoDTO;
import com.microserviceproyecto.models.Service.ProyectoService;
import jakarta.validation.Valid;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proyecto/proyec")
@CrossOrigin
public class ProyectoController {

    @Autowired
    private ProyectoService proyectoService;

    private static JSONObject json;

    @GetMapping()
    public ResponseEntity<List<ProyectoDTO>> obtenerListadoProyectos() {
        return ResponseEntity.ok(proyectoService.listadoProyectos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProyectoDTO> obtenerListaProyectoPorID(@PathVariable(name = "id") long id) {

        return ResponseEntity.ok(proyectoService.obtenerPropyectoPorID(id));
    }

    @PostMapping
    public ResponseEntity<ProyectoDTO> guardarProyecto(@RequestBody ProyectoDTO proyectoDTO) {

        return new ResponseEntity<>(proyectoService.crearProyecto(proyectoDTO), HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    public ResponseEntity<ProyectoDTO> actualizarProyecto(@Valid @RequestBody ProyectoDTO proyectoDTO,
                                                    @PathVariable(name = "id") long id) {

        ProyectoDTO proyectoDTOActualizado = proyectoService.actualizarProyecto(proyectoDTO, id);
        return new ResponseEntity<>(proyectoDTOActualizado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarProyeeto(@PathVariable(name = "id") long id) {

        proyectoService.eliminarProyecto(id);
        json=new JSONObject();
        return new ResponseEntity<>(json.put("message","Registro Eliminado exitosamente!").toString(),HttpStatus.OK);
    }


}
