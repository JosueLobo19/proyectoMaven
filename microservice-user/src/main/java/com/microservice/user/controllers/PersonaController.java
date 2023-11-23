package com.microservice.user.controllers;

import com.microservice.user.models.dto.PersonaDTO;
import com.microservice.user.models.service.PersonaService;
import jakarta.validation.Valid;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v01/persona")
@CrossOrigin
public class PersonaController {

    @Autowired
    private PersonaService personaServe;

    private static JSONObject json=null;

    @GetMapping()
    public ResponseEntity<List<PersonaDTO>> obtenerListaPersona() {
        System.out.println("LLEGO AL LISTADO DE PERSONASSSS");

        //List<PersonaDTO> listadoPersonas= personaServe.listadoPersonas();
        return ResponseEntity.ok(personaServe.listadoPersonas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonaDTO> obtenerPersonaPorID(@PathVariable(name = "id") long id) {

        return ResponseEntity.ok(personaServe.obtenerPersonaPorID(id));
    }

    @PostMapping
    public ResponseEntity<PersonaDTO> guardarPersona(@Valid @RequestBody PersonaDTO personaDTO) {

        return new ResponseEntity<>(personaServe.crearPersona(personaDTO), HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonaDTO> actualizarPersona(@Valid @RequestBody PersonaDTO personaDTO,
                                                        @PathVariable(name = "id") long id) {

        PersonaDTO personaActualizada = personaServe.actualizarPersona(personaDTO, id);
        return new ResponseEntity<>(personaActualizada, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarPersona(@PathVariable(name = "id") long id) {
        personaServe.eliminarPersona(id);
        json=new JSONObject();
        return new ResponseEntity<>(json.put("message","Registro Eliminado exitosamente!").toString(),HttpStatus.OK);    }

}
