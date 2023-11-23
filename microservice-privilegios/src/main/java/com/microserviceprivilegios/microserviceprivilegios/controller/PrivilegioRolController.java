package com.microserviceprivilegios.microserviceprivilegios.controller;

import com.microserviceprivilegios.microserviceprivilegios.models.dto.PrivilegioRolDTO;
import com.microserviceprivilegios.microserviceprivilegios.models.servis.PrivilegioRolService;
import jakarta.validation.Valid;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pr/privilegioRol")
@CrossOrigin
public class PrivilegioRolController {

    @Autowired
    private PrivilegioRolService privilegioRolService;

    private static JSONObject json;

    @GetMapping()
    public ResponseEntity<List<PrivilegioRolDTO>> obtenerListaPrivilegioRol() {
        return ResponseEntity.ok(privilegioRolService.listadoPrivRol());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PrivilegioRolDTO> obtenerPrivRolPorID(@PathVariable(name = "id") long id) {

        return ResponseEntity.ok(privilegioRolService.obtenerPrivRolPorID(id));
    }

    @PostMapping
    public ResponseEntity<PrivilegioRolDTO> guardarPrivilegioRol(@Valid @RequestBody PrivilegioRolDTO privilegioRolDTO) {

        return new ResponseEntity<>(privilegioRolService.crearPrivRol(privilegioRolDTO), HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    public ResponseEntity<PrivilegioRolDTO> actualizarPrivRol(@Valid @RequestBody PrivilegioRolDTO privilegioRolDTO,
                                                                  @PathVariable(name = "id") long id) {

        PrivilegioRolDTO privilegioRolDTOActualizado = privilegioRolService.actualizarPrivRol(privilegioRolDTO, id);
        return new ResponseEntity<>(privilegioRolDTOActualizado, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarPrivRol(@PathVariable(name = "id") long id) {

        privilegioRolService.eliminarPrivRol(id);
        json=new JSONObject();
        return new ResponseEntity<>(json.put("message","Registro Eliminado exitosamente!").toString(),HttpStatus.OK);    }

}
