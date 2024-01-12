package com.microserviceplantillasreport.controller;

import com.microserviceplantillasreport.models.dto.FormatoPlantillaDTO;
import com.microserviceplantillasreport.models.service.IFormatoPlantillaService;
import jakarta.validation.Valid;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estructuraDocumento/formatoPlantilla")
@CrossOrigin
public class FormatoPlantillaController {

    @Autowired
    private IFormatoPlantillaService formatoPlantillaService;

    private static JSONObject json;


    @GetMapping()
    public ResponseEntity<List<FormatoPlantillaDTO>> obtenerListadoFormatoPlantilla() {
        return ResponseEntity.ok(formatoPlantillaService.listadoFormatoPlantilla());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FormatoPlantillaDTO> obtenerListadoFormatoPlantillasPorID(@PathVariable(name = "id") long id) {

        return ResponseEntity.ok(formatoPlantillaService.obtenerFormatoPlantillaPorID(id));
    }

    @PostMapping
    public ResponseEntity<FormatoPlantillaDTO> guardarFormatoPlantillaDTO(@RequestBody FormatoPlantillaDTO formatoPlantillaDTO) {

        return new ResponseEntity<>(formatoPlantillaService.crearFormatoPlantilla(formatoPlantillaDTO), HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    public ResponseEntity<FormatoPlantillaDTO> actualizarFormatoPlantilla(@Valid @RequestBody FormatoPlantillaDTO formatoPlantillaDTO,
                                                            @PathVariable(name = "id") long id) {

        FormatoPlantillaDTO formatoPlantillaDTOActualizado = formatoPlantillaService.actualizarFormatoPlantilla(formatoPlantillaDTO, id);
        return new ResponseEntity<>(formatoPlantillaDTOActualizado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarFormatoPlantilla(@PathVariable(name = "id") long id) {

        formatoPlantillaService.eliminarFormatoPlantilla(id);
        json=new JSONObject();
        return new ResponseEntity<>(json.put("message","Registro Eliminado exitosamente!").toString(),HttpStatus.OK);
    }



}
