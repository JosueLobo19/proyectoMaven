package com.microservice.user.controllers;

import com.microservice.user.models.dto.RolDTO;
import com.microservice.user.models.service.RolService;
import jakarta.validation.Valid;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v01/rol")
@CrossOrigin
public class RolController {

    @Autowired
    private RolService rolServer;

    private static JSONObject json=null;

    @GetMapping
    public ResponseEntity<List<RolDTO>> listaDeRoles(){
        System.out.println("LLEGO AL LISTADO DE ROLES");
        List<RolDTO> listaDeRol= rolServer.obtenerRolListar();
        return ResponseEntity.ok(listaDeRol);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RolDTO> obtenerRolPorId(@PathVariable(name = "id") long id) {

        return ResponseEntity.ok(rolServer.obtenerRolPorID(id));
    }

    @PostMapping
    public ResponseEntity<RolDTO> guardarRol(@Valid @RequestBody RolDTO rolDTO){
        System.out.println("entro a registrar rol");
        return new ResponseEntity<>(rolServer.crearRol(rolDTO), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<RolDTO> actualizarRol(@Valid @RequestBody RolDTO rolDTO,
                                                @PathVariable(name = "id") long id){
        RolDTO rolActualizado=rolServer.actualizarRol(rolDTO, id);
        return new ResponseEntity<>(rolActualizado,HttpStatus.OK);
    }

   // @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarRol(@PathVariable(name = "id") long id){
        rolServer.eliminarRol(id);
        json=new JSONObject();
        return new ResponseEntity<>(json.put("message","Registro Eliminado exitosamente!").toString(),HttpStatus.OK);
    }
}
