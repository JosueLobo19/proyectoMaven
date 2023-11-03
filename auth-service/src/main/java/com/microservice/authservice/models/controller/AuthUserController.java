package com.microservice.authservice.models.controller;

import com.microservice.authservice.models.dao.IConectividadDAO;
import com.microservice.authservice.models.dao.IPersonaDAO;
import com.microservice.authservice.models.dao.IRolDAO;
import com.microservice.authservice.models.dao.IUserDAO;
import com.microservice.authservice.models.dto.ConectividadDTO;
import com.microservice.authservice.models.dto.TokenDTO;
import com.microservice.authservice.models.dto.UsuarioDTO;
import com.microservice.authservice.models.entity.Persona;
import com.microservice.authservice.models.entity.Rol;
import com.microservice.authservice.models.entity.Usuario;
import com.microservice.authservice.models.errors.ResourceNotFoundException;
import com.microservice.authservice.models.service.AuthUserService;
import com.microservice.authservice.models.service.ConectividadService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthUserController {
    private static JSONObject json = null;
    @Autowired
    private AuthUserService authUserService;

    @Autowired
    private IConectividadDAO conectividadDAO;

    ConectividadService conectividadService;

    IRolDAO rolDAO;

    IUserDAO userDAO;

    IPersonaDAO personaDao;

    PasswordEncoder passwordEncoder;

    @GetMapping("/conectividad")
    public ResponseEntity<?> listadoConectividad(){
        List<ConectividadDTO> listaDeRol= conectividadService.obtenerListar();
        return ResponseEntity.ok(listaDeRol);
    }

    @GetMapping("/conectividad/{id}")
    public ResponseEntity<?> listadoConectividadUno(@PathVariable(name = "id") long id){
        return ResponseEntity.ok(conectividadDAO.findById(id));
    }

    @PostMapping("/login")
    public ResponseEntity<TokenDTO> login(@RequestBody UsuarioDTO usuarioDTO){
        TokenDTO tokenDTO= authUserService.login(usuarioDTO);
        if(tokenDTO==null)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(tokenDTO);
    }

    @PostMapping("/validate")
    public ResponseEntity<TokenDTO> validate(@RequestBody String token){
        TokenDTO tokenDTO= authUserService.validate(token);
        if(tokenDTO==null)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(tokenDTO);

    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody UsuarioDTO usuarioDTO){
        System.out.println("LLEGO A a la primera parte del crear");

        /*
        if(userDAO.existsByUsername(usuarioDTO.getUsername())) {
            return new ResponseEntity<>("Ese nombre de usuario ya existe", HttpStatus.BAD_REQUEST);
        }


        System.out.println("LLEGO A a la segunda parte del crear");

        Usuario usuario = new Usuario();
        usuario.setIdUser(usuarioDTO.getIdUser());
        usuario.setUsername(usuarioDTO.getUsername());
        usuario.setEstado(usuarioDTO.getEstado());
        usuario.setPassword(passwordEncoder.encode(usuarioDTO.getPassword()));
        System.out.println("LLEGO A a la tercera parte del crear");

        Rol roles = rolDAO.findById(usuarioDTO.getIdRol()).get();
        usuario.setRol(Collections.singleton(roles));
        Persona persona= personaDao.
                findById(usuarioDTO.getIdPersona()).orElseThrow(()->new ResourceNotFoundException("Persona", "id", usuarioDTO.getIdPersona()));
        usuario.setPersona(persona);
        System.out.println("LLEGO A a la cuarta parte del crear");

        userDAO.save(usuario);
        json = new JSONObject();
        return new ResponseEntity<>(json.put("message", "se Registro  exitosamente!!!").toString(), HttpStatus.OK);
        */
        return new ResponseEntity<>(authUserService.save(usuarioDTO), HttpStatus.CREATED);

    }
}
