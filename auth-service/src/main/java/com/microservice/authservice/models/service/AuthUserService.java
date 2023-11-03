package com.microservice.authservice.models.service;

import com.microservice.authservice.models.dto.TokenDTO;
import com.microservice.authservice.models.dto.UsuarioDTO;

import java.util.List;

public interface AuthUserService {
     UsuarioDTO save(UsuarioDTO usuarioDTO );

     TokenDTO login(UsuarioDTO usuarioDTO);

     TokenDTO validate(String token);
     List<UsuarioDTO> obtenerUsuariosPorPersonaId(long personaId);

     UsuarioDTO obtenerUsuarioPorId(Long personaId,Long usuarioId);

     UsuarioDTO actualizarUsuario(Long personaId,Long usuarioId,UsuarioDTO solicitudDeUsuario);

     void eliminarUsuario(Long personaId,Long usuarioId);
}
