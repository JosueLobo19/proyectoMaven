package com.microserviceproyecto.controller;

import com.microserviceproyecto.models.Dto.ActividadDTO;
import com.microserviceproyecto.models.Service.ActividadService;
import jakarta.validation.Valid;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proyecto/actividad")
@CrossOrigin
public class ActividadController {

    @Autowired
    private ActividadService actividadService;

    private static JSONObject json;


    @GetMapping()
    public ResponseEntity<List<ActividadDTO>> obtenerListadoActividad() {
        return ResponseEntity.ok(actividadService.listadoActividad());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ActividadDTO> obtenerListadoActividadesPorID(@PathVariable(name = "id") long id) {

        return ResponseEntity.ok(actividadService.obtenerActividadPorID(id));
    }

    @PostMapping
    public ResponseEntity<ActividadDTO> guardarActividad(@RequestBody ActividadDTO actividadDTO) {

        return new ResponseEntity<>(actividadService.crearActividad(actividadDTO), HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    public ResponseEntity<ActividadDTO> actualizarActividad(@Valid @RequestBody ActividadDTO actividadDTO,
                                                            @PathVariable(name = "id") long id) {

        ActividadDTO actividadDTOActualizado = actividadService.actualizarActividad(actividadDTO, id);
        return new ResponseEntity<>(actividadDTOActualizado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarActividad(@PathVariable(name = "id") long id) {

        actividadService.eliminarActividad(id);
        json=new JSONObject();
        return new ResponseEntity<>(json.put("message","Registro Eliminado exitosamente!").toString(),HttpStatus.OK);
    }


}
