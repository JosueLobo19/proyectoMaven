package com.microserviceproyecto.controller;

import com.microserviceproyecto.models.Dto.ActividadDTO;
import com.microserviceproyecto.models.Dto.DocumentoDTO;
import com.microserviceproyecto.models.Service.DocumentoService;
import jakarta.validation.Valid;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/proyecto/documento")
@CrossOrigin
public class DocumentoController {

    @Autowired
    private DocumentoService documentoService;

    private static JSONObject json;

    @GetMapping()
    public ResponseEntity<List<DocumentoDTO>> obtenerListadoDocumento() throws IOException {
        return ResponseEntity.ok(documentoService.listadoDocumentos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DocumentoDTO> obtenerListadoDocumentosPorID(@PathVariable(name = "id") long id) throws IOException{

        return ResponseEntity.ok(documentoService.obtenerDocumentoPorID(id));
    }

    @PostMapping
    public ResponseEntity<DocumentoDTO> guardarDocumento(@RequestBody DocumentoDTO documentoDTO) throws IOException {
        return new ResponseEntity<>(documentoService.crearDocumento(documentoDTO), HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    public ResponseEntity<DocumentoDTO> actualizarDocumento(@Valid @RequestBody DocumentoDTO documentoDTO,
                                                            @PathVariable(name = "id") long id) throws IOException{

        DocumentoDTO documentoDTOActualizado = documentoService.actualizarDocumentos(documentoDTO, id);
        return new ResponseEntity<>(documentoDTOActualizado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarDocumento(@PathVariable(name = "id") long id) {

        documentoService.eliminarDocumento(id);
        json=new JSONObject();
        return new ResponseEntity<>(json.put("message","Registro Eliminado exitosamente!").toString(),HttpStatus.OK);
    }



}
