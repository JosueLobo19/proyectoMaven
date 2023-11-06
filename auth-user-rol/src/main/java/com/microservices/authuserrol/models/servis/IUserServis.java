package com.microservices.authuserrol.models.servis;

import com.microservices.authuserrol.models.dtos.LoginDtos;
import com.microservices.authuserrol.models.dtos.TokenDtos;
import com.microservices.authuserrol.models.dtos.UserDtos;

import java.util.List;

public interface IUserServis {

List<UserDtos> ObtenerListadoUser();
    UserDtos save(UserDtos usuarioDTO);

    TokenDtos login(LoginDtos loginDtos);

    TokenDtos validate(String token);
    List<UserDtos> obtenerUsuariosPorPersonaId(long personaId);

    UserDtos obtenerUsuarioPorId(Long personaId,Long usuarioId);

    UserDtos actualizarUsuario(Long personaId,Long usuarioId,UserDtos solicitudDeUsuario);

    void eliminarUsuario(Long personaId,Long usuarioId);
}
