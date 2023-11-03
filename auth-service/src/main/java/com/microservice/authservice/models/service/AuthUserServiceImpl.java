package com.microservice.authservice.models.service;

import com.microservice.authservice.models.dao.IRolDAO;
import com.microservice.authservice.models.dao.IUserDAO;
import com.microservice.authservice.models.dto.TokenDTO;
import com.microservice.authservice.models.dto.UsuarioDTO;
import com.microservice.authservice.models.entity.Persona;
import com.microservice.authservice.models.entity.Rol;
import com.microservice.authservice.models.entity.Usuario;
import com.microservice.authservice.models.errors.ResourceNotFoundException;
import com.microservice.authservice.models.security.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.microservice.authservice.models.dao.IPersonaDAO;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class AuthUserServiceImpl implements  AuthUserService{
    IUserDAO usuarioDao;

    IRolDAO rolDAO;
    PasswordEncoder passwordEncoder;

   IPersonaDAO personaDAO;


    JwtProvider jwtProvider;


    @Override
    public UsuarioDTO save(UsuarioDTO usuarioDTO) {
        System.out.println("el id persona es:"+usuarioDTO.getIdPersona());
        System.out.println("el id rol es:"+usuarioDTO.getIdRol());
        Usuario usuario= mapearEntidad(usuarioDTO);
        Rol roles = rolDAO.findById(usuarioDTO.getIdRol()).get();
        Persona persona= personaDAO.
                findById(usuarioDTO.getIdPersona()).orElseThrow(()->new ResourceNotFoundException("Persona", "id", usuarioDTO.getIdPersona()));
        String password= passwordEncoder.encode(usuarioDTO.getPassword());
        usuario.setRol(Collections.singleton(roles));
        usuario.setPassword(password);
        usuario.setPersona(persona);
        Usuario nuevoUsuario= usuarioDao.save(usuario);

        return mapearDTO(nuevoUsuario);
    }

    @Override
    public TokenDTO login(UsuarioDTO usuarioDTO) {
        Optional<Usuario> user = usuarioDao.findByUsername(usuarioDTO.getUsername());
        if(!user.isPresent())
            return null;
        if(passwordEncoder.matches(usuarioDTO.getPassword(), user.get().getPassword()))
            return new TokenDTO(jwtProvider.createToken(user.get()));
        return null;
    }

    @Override
    public TokenDTO validate(String token) {
        if(!jwtProvider.validate(token))
            return null;
        String username = jwtProvider.getUserNameFromToken(token);
        if(!usuarioDao.findByUsername(username).isPresent())
            return null;
        return new TokenDTO(token);
    }

    @Override
    public List<UsuarioDTO> obtenerUsuariosPorPersonaId(long personaId) {
        return null;
    }

    @Override
    public UsuarioDTO obtenerUsuarioPorId(Long personaId, Long usuarioId) {
        return null;
    }

    @Override
    public UsuarioDTO actualizarUsuario(Long personaId, Long usuarioId, UsuarioDTO solicitudDeUsuario) {
        return null;
    }

    @Override
    public void eliminarUsuario(Long personaId, Long usuarioId) {

    }

    private UsuarioDTO mapearDTO(Usuario usuario) {
        UsuarioDTO usuarioDTO= new UsuarioDTO();
        usuarioDTO.setIdPersona(usuario.getIdUser());
        usuarioDTO.setUsername(usuario.getUsername());
        usuarioDTO.setPassword(usuario.getPassword());
        usuarioDTO.setEstado(usuario.getEstado());

        return usuarioDTO;
    }
    //convierte DTO a entidad
    private Usuario mapearEntidad(UsuarioDTO usuarioDTO) {
        Usuario usuario= new Usuario();
        usuario.setUsername(usuarioDTO.getUsername());
        usuario.setPassword(usuarioDTO.getPassword());
        usuario.setEstado(usuarioDTO.getEstado());
        return usuario;

    }
}
