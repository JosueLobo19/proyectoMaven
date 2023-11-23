package com.microserviceproyecto.controller;

import com.microserviceproyecto.models.Dto.FaseDTO;
import com.microserviceproyecto.models.Service.FaseService;
import jakarta.validation.Valid;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proyecto/fase")
@CrossOrigin
public class FaseController {

    @Autowired
    private FaseService faseService;

    private static JSONObject json;


    @GetMapping()
    public ResponseEntity<List<FaseDTO>> obtenerListadoActividad() {
        return ResponseEntity.ok(faseService.listadoFase());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FaseDTO> obtenerListadoActividadesPorID(@PathVariable(name = "id") long id) {

        return ResponseEntity.ok(faseService.obtenerFasePorID(id));
    }

    @PostMapping
    public ResponseEntity<FaseDTO> guardarActividad(@RequestBody FaseDTO faseDTO) {

        return new ResponseEntity<>(faseService.crearAFase(faseDTO), HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    public ResponseEntity<FaseDTO> actualizarFase(@Valid @RequestBody FaseDTO faseDTO,
                                                            @PathVariable(name = "id") long id) {

        FaseDTO faseDTOActualizada = faseService.actualizarFase(faseDTO, id);
        return new ResponseEntity<>(faseDTOActualizada, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarActividad(@PathVariable(name = "id") long id) {

        faseService.eliminarFase(id);
        json=new JSONObject();
        return new ResponseEntity<>(json.put("message","Registro Eliminado exitosamente!").toString(),HttpStatus.OK);
    }


}
