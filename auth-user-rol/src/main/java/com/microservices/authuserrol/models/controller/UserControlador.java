package com.microservices.authuserrol.models.controller;

import com.microservices.authuserrol.models.dtos.LoginDtos;
import com.microservices.authuserrol.models.dtos.TokenDtos;
import com.microservices.authuserrol.models.dtos.UserDtos;
import com.microservices.authuserrol.models.entity.Usuario;
import com.microservices.authuserrol.models.repository.IUsuarioRepository;
import com.microservices.authuserrol.models.servis.IUserServis;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class UserControlador {

    private static JSONObject json = null;

    @Autowired
    IUsuarioRepository userRepository;

    @Autowired
    IUserServis userServis;

    @GetMapping("/listadoUser")
    public ResponseEntity<?> obtenerListaUsuarios() {
        System.out.println("LLEGO AL LISTADO DE users");

        return ResponseEntity.ok(userRepository.findAll());
    }

    @PostMapping("/create")
    public ResponseEntity<UserDtos> registrarUsuario(@RequestBody UserDtos userDtos){
        UserDtos userD;
        userD=userServis.save(userDtos);
        return ResponseEntity.ok(userD);
    }

    @PostMapping("/login")
    public ResponseEntity<TokenDtos> login(@RequestBody LoginDtos loginDtos){
        TokenDtos tokenDtos=userServis.login(loginDtos);
        if(tokenDtos==null)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(tokenDtos);
    }

    @PostMapping("/validate")
    public ResponseEntity<?> validar(@RequestBody String token){
        System.out.println("antes de validar token"+token);

        TokenDtos tokenDtos=userServis.validate(token);
        System.out.println("despues de validar token"+tokenDtos);

        if(tokenDtos==null)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(tokenDtos);

    }
    @GetMapping("/validate/{token}")
    public ResponseEntity<?> validarGet(@PathVariable(name = "token") String token){
        System.out.println("antes de validar token"+token);

        TokenDtos tokenDtos=userServis.validate(token);
        System.out.println("despues de validar token:"+tokenDtos);

        if(tokenDtos==null)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(tokenDtos);

    }
}
