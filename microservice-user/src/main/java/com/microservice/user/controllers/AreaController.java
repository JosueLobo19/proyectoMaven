package com.microservice.user.controllers;

import com.microservice.user.models.dto.AreaDTO;
import com.microservice.user.models.dto.EmpresaDTO;
import com.microservice.user.models.service.AreaService;
import jakarta.validation.Valid;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v01/area")
public class AreaController {

    @Autowired
    private AreaService areaService;
    private static JSONObject json=null;

    @GetMapping()
    public ResponseEntity<List<AreaDTO>> obtenerListaArea() {
        return ResponseEntity.ok(areaService.listadoArea());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AreaDTO> obtenerAreaPorID(@PathVariable(name = "id") long id) {

        return ResponseEntity.ok(areaService.obtenerAreaPorID(id));
    }

    @PostMapping
    public ResponseEntity<AreaDTO> guardarArea(@Valid @RequestBody AreaDTO areaDTO) {

        return new ResponseEntity<>(areaService.crearArea(areaDTO), HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    public ResponseEntity<AreaDTO> actualizarArea(@Valid @RequestBody AreaDTO areaDTO,
                                                        @PathVariable(name = "id") long id) {

        AreaDTO areaDTOActualizada = areaService.actualizarArea(areaDTO, id);
        return new ResponseEntity<>(areaDTOActualizada, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarArea(@PathVariable(name = "id") long id) {

        areaService.eliminarArea(id);
        json=new JSONObject();
        return new ResponseEntity<>(json.put("message","Registro Eliminado exitosamente!").toString(),HttpStatus.OK);    }
}
