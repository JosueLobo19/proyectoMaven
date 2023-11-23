package com.microserviceprivilegios.microserviceprivilegios.controller;

import com.microserviceprivilegios.microserviceprivilegios.models.dto.PrivilegioInterfazDTO;
import com.microserviceprivilegios.microserviceprivilegios.models.servis.OpcionInterfazService;
import jakarta.validation.Valid;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pr/opcionInterfaz")
@CrossOrigin
public class OpcionInterfazController {
    private static JSONObject json=null;

    @Autowired
    private OpcionInterfazService opcionInterfazService;

    @GetMapping()
    public ResponseEntity<List<PrivilegioInterfazDTO>> obtenerListaOpcionInterfaz() {
        return ResponseEntity.ok(opcionInterfazService.listadoOpcInt());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PrivilegioInterfazDTO> obtenerOpcIntPorID(@PathVariable(name = "id") long id) {

        return ResponseEntity.ok(opcionInterfazService.obtenerOpcIntPorID(id));
    }

    @PostMapping
    public ResponseEntity<PrivilegioInterfazDTO> guardarOpcInt(@Valid @RequestBody PrivilegioInterfazDTO privilegioInterfazDTO) {
        System.out.println("entro a guardar opcion de interfaz");
        return new ResponseEntity<>(opcionInterfazService.crearOpcInt(privilegioInterfazDTO), HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    public ResponseEntity<PrivilegioInterfazDTO> actualizarOpcInt(@Valid @RequestBody PrivilegioInterfazDTO privilegioInterfazDTO,
                                                  @PathVariable(name = "id") long id) {

        PrivilegioInterfazDTO privilegioInterfazDTOActualizado = opcionInterfazService.actualizarOpcInt(privilegioInterfazDTO, id);
        return new ResponseEntity<>(privilegioInterfazDTOActualizado, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarOpcInt(@PathVariable(name = "id") long id) {

        opcionInterfazService.eliminarOpcInt(id);
        json=new JSONObject();
        return new ResponseEntity<>(json.put("message","Registro Eliminado exitosamente!").toString(),HttpStatus.OK);    }
}
