package com.microserviceplantillasreport.controller;

import com.microserviceplantillasreport.models.dto.PlantillaDocumentoDTO;
import com.microserviceplantillasreport.models.entity.PlantillaDocumento;
import com.microserviceplantillasreport.models.service.IPlantillaDocumentoService;
import jakarta.validation.Valid;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estructuraDocumento/plantillaDocumento")
@CrossOrigin
public class PlantillaDocumentoController {

    @Autowired
    private IPlantillaDocumentoService plantillaDocumentoService;

    private static JSONObject json;


    @GetMapping()
    public ResponseEntity<List<PlantillaDocumentoDTO>> obtenerListadoPlantillaDocumento() {
        return ResponseEntity.ok(plantillaDocumentoService.listadoPlantillaDocumento());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlantillaDocumentoDTO> obtenerPlantillaDocumentoPorID(@PathVariable(name = "id") long id) {

        return ResponseEntity.ok(plantillaDocumentoService.obtenerPlantillaDocumentoPorID(id));
    }

    @PostMapping
    public ResponseEntity<PlantillaDocumentoDTO> guardarPlantillaDocumento(@RequestBody PlantillaDocumentoDTO plantillaDocumentoDTO) {

        return new ResponseEntity<>(plantillaDocumentoService.crearPlantillaDocumento(plantillaDocumentoDTO), HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    public ResponseEntity<PlantillaDocumentoDTO> actualizarPlantillaDocumento(@Valid @RequestBody PlantillaDocumentoDTO plantillaDocumentoDTO,
                                                            @PathVariable(name = "id") long id) {

        PlantillaDocumentoDTO plantillaDocumentoDTOActualizado = plantillaDocumentoService.actualizarPlantillaDocumento(plantillaDocumentoDTO, id);
        return new ResponseEntity<>(plantillaDocumentoDTOActualizado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarPlantillaDocumento(@PathVariable(name = "id") long id) {

        plantillaDocumentoService.eliminarPlantillaDocumento(id);
        json=new JSONObject();
        return new ResponseEntity<>(json.put("message","Registro Eliminado exitosamente!").toString(),HttpStatus.OK);
    }



}
