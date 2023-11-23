package com.microserviceproyecto.models.Service;

import com.microserviceproyecto.models.Dto.ActividadDTO;
import com.microserviceproyecto.models.Dto.DocumentoDTO;

import java.io.IOException;
import java.util.List;

public interface DocumentoService {
    DocumentoDTO crearDocumento(DocumentoDTO documentoDTO) throws IOException;
    List<DocumentoDTO> listadoDocumentos() throws IOException;
    DocumentoDTO obtenerDocumentoPorID(long id) throws IOException;
    DocumentoDTO actualizarDocumentos(DocumentoDTO documentoDTO, long id) throws IOException;
    void eliminarDocumento(long id);
}
