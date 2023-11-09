package com.microservice.user.controllers;

import com.microservice.user.models.dto.EmpresaDTO;
import com.microservice.user.models.service.EmpresaService;
import jakarta.validation.Valid;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v01/empresa")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    private static JSONObject json=null;

    @GetMapping()
    public ResponseEntity<List<EmpresaDTO>> obtenerListaEmpresa() {
        return ResponseEntity.ok(empresaService.listadoEmpresas());
    }


    @GetMapping("/{id}")
    public ResponseEntity<EmpresaDTO> obtenerEmpresaPorID(@PathVariable(name = "id") long id) {

        return ResponseEntity.ok(empresaService.obtenEmpresaID(id));
    }

    @PostMapping
    public ResponseEntity<EmpresaDTO> guardarEmpresa(@Valid @RequestBody EmpresaDTO empresaDTO) {

        return new ResponseEntity<>(empresaService.crearEmpresa(empresaDTO), HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    public ResponseEntity<EmpresaDTO> actualizarEmpresa(@Valid @RequestBody EmpresaDTO empresaDTO,
                                                        @PathVariable(name = "id") long id) {

        EmpresaDTO empresaDTOActualizada = empresaService.actualizarEmpresa(empresaDTO, id);
        return new ResponseEntity<>(empresaDTOActualizada, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarEmpresa(@PathVariable(name = "id") long id) {

        empresaService.eliminarEmpresa(id);
        json=new JSONObject();
        return new ResponseEntity<>(json.put("message","Registro Eliminado exitosamente!").toString(),HttpStatus.OK);    }

}
