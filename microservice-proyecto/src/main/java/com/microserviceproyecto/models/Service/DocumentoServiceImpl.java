package com.microserviceproyecto.models.Service;

import com.microserviceproyecto.models.Dto.DocumentoDTO;
import com.microserviceproyecto.models.Entity.Documento;
import com.microserviceproyecto.models.Entity.Fase;
import com.microserviceproyecto.models.Error.ResourceNotFoundException;
import com.microserviceproyecto.models.Repository.IDocumentoRepository;
import com.microserviceproyecto.models.Repository.IFaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DocumentoServiceImpl implements DocumentoService{

    @Autowired
    private IDocumentoRepository documentoRepository;

    @Autowired
    private IFaseRepository faseRepository;

    @Override
    public DocumentoDTO crearDocumento(DocumentoDTO documentoDTO) throws IOException{
        //convertion de dto a entidad
        Documento documento= mapearENTIDAD(documentoDTO);
        documento.setRutaArchivo(rutaDeDcoumento(documentoDTO));
        Documento nuevoDocumento= documentoRepository.save(documento);

        DocumentoDTO nuevoDocumentoDTO= mapearDTO(nuevoDocumento);

        return nuevoDocumentoDTO;
    }

    @Override
    public List<DocumentoDTO> listadoDocumentos() throws IOException{
        List<Documento> listadoDocumentos=documentoRepository.findAll();
        return listadoDocumentos.stream().map(this::mapearDTO).collect(Collectors.toList());
    }

    @Override
    public DocumentoDTO obtenerDocumentoPorID(long id) throws IOException {
        Documento documento=documentoRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Documento", "id", id));
        return mapearDTO(documento);
    }

    @Override
    public DocumentoDTO actualizarDocumentos(DocumentoDTO documentoDTO, long id)  throws IOException {
        Documento documento
                =documentoRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Documento", "id", id));
        return actualizar(documento,documentoDTO);
    }

    @Override
    public void eliminarDocumento(long id) {
        Documento documento
                =documentoRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Documento", "id", id));
        documentoRepository.delete(documento);
    }

    public String rutaDeDcoumento(DocumentoDTO documentoDTO) throws IOException {
        String rutaDocumento;
        System.out.println("entro en la ruta de documento");

        rutaDocumento="c:"+File.separator+"empresa-"+documentoDTO.getIdEmpresa()+File.separator+"fase-"+documentoDTO.getIdFase()+File.separator+"requisito-"
                +documentoDTO.getIdRequisito()+File.separator+"documento-"+documentoRepository.conteoDocumento();
        System.out.println("entro en crear Documento:"+rutaDocumento);

        File directorios = new File(rutaDocumento);
        if (!directorios.exists()) {
            if (directorios.mkdirs()) {
                System.out.println("Multiples directorios fueron creados");
            } else {
                System.out.println("Error al crear directorios");
            }
        }
        rutaDocumento=rutaDocumento+File.separator+documentoDTO.getNombreArchivo();

        File file=new File(rutaDocumento);

        try(FileOutputStream fos= new FileOutputStream(file);){
            byte[] decoder= Base64.getDecoder().decode(documentoDTO.getArchivoBase64());
            fos.write(decoder);
            System.out.println("archivo creado exitosamente");
        } catch (IOException e) {
            System.out.println("Error al escribir en el fichero " + e);
        }

        return rutaDocumento;

    }

    public String base64Archivo(String rutaDocumento) throws IOException {
        String b64="";
        try {
            File file = new File(rutaDocumento);
            byte [] bytes = Files.readAllBytes(file.toPath());

             b64 = Base64.getEncoder().encodeToString(bytes);
            System.out.println("el pdf en base 64 es:"+b64);
        } catch (Exception e) {
            e.printStackTrace();
        }


        return b64;
    }

    private DocumentoDTO mapearDTO(Documento documento)  {
        String base64="";
        DocumentoDTO documentoDTO= new DocumentoDTO();
        documentoDTO.setId(documento.getId());
        documentoDTO.setAdjuntado(documento.getAdjuntado());
        documentoDTO.setGenerado(documento.getGenerado());
        documentoDTO.setEstado(documento.getEstado());
        documentoDTO.setRutaArchivo(documento.getRutaArchivo());
        documentoDTO.setUserRegistro(documento.getUserRegistro());
        documentoDTO.setFechaRegistro(documento.getFechaRegistro());
        documentoDTO.setUserActualizacion(documento.getUserActualizacion());
        documentoDTO.setFechaActualizacion(documento.getFechaActualizacion());
        documentoDTO.setIdFase(documento.getFase().getId());
        try {
            base64=base64Archivo(documento.getRutaArchivo());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        documentoDTO.setArchivoBase64(base64);

        return documentoDTO;
    }

    private Documento mapearENTIDAD(DocumentoDTO documentoDTO){
        Fase fase;
        Documento documento=new Documento();

        documento.setAdjuntado(documentoDTO.getAdjuntado());
        documento.setGenerado(documentoDTO.getGenerado());
        documento.setEstado(documentoDTO.getEstado());
       // documento.setRutaArchivo(documentoDTO.getRutaArchivo());
        documento.setUserRegistro(documentoDTO.getUserRegistro());
        documento.setFechaRegistro(documentoDTO.getFechaRegistro());
        documento.setUserActualizacion(documentoDTO.getUserActualizacion());
        documento.setFechaActualizacion(documentoDTO.getFechaActualizacion());
        fase=faseRepository.findById(documentoDTO.getIdFase()).orElseThrow(()->new ResourceNotFoundException("Fase", "id_fase", documentoDTO.getIdFase()));
        documento.setFase(fase);
        return documento;
    }


    private DocumentoDTO actualizar(Documento documento, DocumentoDTO documentoDTO) throws IOException{
        Fase fase;
        documento.setAdjuntado(documentoDTO.getAdjuntado());
        documento.setGenerado(documentoDTO.getGenerado());
        documento.setEstado(documentoDTO.getEstado());
       // documento.setRutaArchivo(documentoDTO.getRutaArchivo());
        documento.setUserRegistro(documentoDTO.getUserRegistro());
        documento.setFechaRegistro(documentoDTO.getFechaRegistro());
        documento.setUserActualizacion(documentoDTO.getUserActualizacion());
        documento.setFechaActualizacion(documentoDTO.getFechaActualizacion());
        fase=faseRepository.findById(documentoDTO.getIdFase()).orElseThrow(()->new ResourceNotFoundException("Fase", "id_fase", documentoDTO.getIdFase()));
        documento.setFase(fase);
        faseRepository.save(fase);
        return mapearDTO(documento);
    }
}
