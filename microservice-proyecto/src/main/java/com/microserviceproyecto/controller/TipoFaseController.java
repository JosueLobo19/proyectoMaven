package com.microserviceproyecto.controller;

import com.microserviceproyecto.models.Dto.ProyectoDTO;
import com.microserviceproyecto.models.Dto.TipoFaseDTO;
import com.microserviceproyecto.models.Service.TipoFaseService;
import jakarta.validation.Valid;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proyecto/tipo-fase")
@CrossOrigin
public class TipoFaseController {

    @Autowired
    private TipoFaseService tipoFaseService;

    private static JSONObject json;

    @GetMapping()
    public ResponseEntity<List<TipoFaseDTO>> obtenerListadoTipoFases() {
        return ResponseEntity.ok(tipoFaseService.listadoTipoFases());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoFaseDTO> obtenerListadoTipoFasesPorID(@PathVariable(name = "id") long id) {

        return ResponseEntity.ok(tipoFaseService.obtenerTipoFasesPorID(id));
    }

    @PostMapping
    public ResponseEntity<TipoFaseDTO> guardarTipoFase(@RequestBody TipoFaseDTO tipoFaseDTO) {

        return new ResponseEntity<>(tipoFaseService.crearTipoDeFase(tipoFaseDTO), HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoFaseDTO> actualizarTipoFase(@Valid @RequestBody TipoFaseDTO tipoFaseDTO,
                                                          @PathVariable(name = "id") long id) {

        TipoFaseDTO tipoFaseDTOActualizado = tipoFaseService.actualizarTipoFases(tipoFaseDTO, id);
        return new ResponseEntity<>(tipoFaseDTOActualizado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarTipoFase(@PathVariable(name = "id") long id) {

        tipoFaseService.eliminarTipoFases(id);
        json=new JSONObject();
        return new ResponseEntity<>(json.put("message","Registro Eliminado exitosamente!").toString(),HttpStatus.OK);
    }


}
