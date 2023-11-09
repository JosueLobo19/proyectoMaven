package com.microservices.authuserrol.models.servis;

import com.microservices.authuserrol.models.dtos.LoginDtos;
import com.microservices.authuserrol.models.dtos.TokenDtos;
import com.microservices.authuserrol.models.dtos.UserDtos;
import com.microservices.authuserrol.models.entity.Persona;
import com.microservices.authuserrol.models.entity.RolEntidad;
import com.microservices.authuserrol.models.entity.Usuario;
import com.microservices.authuserrol.models.errores.ResourceNotFoundException;
import com.microservices.authuserrol.models.repository.IPersonaRepository;
import com.microservices.authuserrol.models.repository.IRolRepository;
import com.microservices.authuserrol.models.repository.IUsuarioRepository;
import com.microservices.authuserrol.models.security.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServisImpl implements IUserServis{

    @Autowired
    private IRolRepository rolRepository;

    @Autowired
    private IPersonaRepository personaRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    IUsuarioRepository usuarioRepository;
    @Override
    public List<UserDtos> ObtenerListadoUser() {
        List<Usuario> listaDeUsuarios = usuarioRepository.findAll();
        return listaDeUsuarios.stream().map(this::mapearDTO).collect(Collectors.toList());
    }

    @Override
    public UserDtos save(UserDtos usuarioDTO) {
        String nombreRol;

        System.out.println("el id persona es:"+usuarioDTO.getIdPersona());
        System.out.println("el id rol es:"+usuarioDTO.getIdRol());
        System.out.println("el username es:"+usuarioDTO.getUserName());

        Usuario usuario= mapearEntidad(usuarioDTO);
        nombreRol=rolRepository.findById(usuarioDTO.getIdRol()).get().getNombre();
        System.out.println("el valor de rol nombre:"+nombreRol);

        RolEntidad roles = rolRepository.findById(usuarioDTO.getIdRol()).get();
        System.out.println("el valor de rol nombre:"+roles.getNombre());

        Persona persona= personaRepository.
                findById(usuarioDTO.getIdPersona()).orElseThrow(()->new ResourceNotFoundException("Persona", "id", usuarioDTO.getIdPersona()));
        System.out.println("el id persona de la tabla persona:"+persona.getId());
        String password= passwordEncoder.encode(usuarioDTO.getPassword());
        usuario.setRol(Collections.singleton(roles));
        usuario.setPassword(password);
        //usuario.setPersona(persona);
        System.out.println("lo que se esta guardando");
        System.out.println("el estado es:"+usuario.getEstado());
        System.out.println("el username es:"+usuario.getUserName());
        System.out.println("el password es:"+usuario.getPassword());
        System.out.println("el id persona es:"+usuario.getPersona().getId());
        System.out.println("el id persona es:"+usuario.getRol());
        Usuario nuevoUsuario= usuarioRepository.save(usuario);

        return mapearDTO(nuevoUsuario);
    }

    @Override
    public TokenDtos login(LoginDtos loginDtos) {
        Optional<Usuario> user = usuarioRepository.findByUserName(loginDtos.getUsernameOrEmail());
        if(!user.isPresent())
            return null;
        if(passwordEncoder.matches(loginDtos.getPassword(), user.get().getPassword()))
            return new TokenDtos(jwtProvider.createToken(user.get()));
        return null;
    }

    @Override
    public TokenDtos validate(String token) {
        System.out.println("llego al service implement");

        if(!jwtProvider.validate(token))
            return null;
       String username = jwtProvider.getUserNameFromToken(token);
       System.out.println("el valor dedl username en el servicio implemetnacion es: "+username);
        //Optional<Usuario> user=Optional.ofNullable((usuarioRepository.findByUsername(username)));
        if(!usuarioRepository.findByUserName(username).isPresent())
            return null;
        return new TokenDtos(token);
    }

    @Override
    public List<UserDtos> obtenerUsuariosPorPersonaId(long personaId) {
        return null;
    }

    @Override
    public UserDtos obtenerUsuarioPorId(Long personaId, Long usuarioId) {
        return null;
    }

    @Override
    public UserDtos actualizarUsuario(Long personaId, Long usuarioId, UserDtos solicitudDeUsuario) {
        return null;
    }

    @Override
    public void eliminarUsuario(Long personaId, Long usuarioId) {

    }


    //convierte entidad a DTO
    private UserDtos mapearDTO(Usuario usuario) {
        UserDtos userDtos= new UserDtos();
        long id_persona,id_rol;
        RolEntidad roldata;
        id_persona=usuario.getPersona().getId();
        roldata= (RolEntidad) usuario.getRol();
        id_rol=roldata.getIdRol();
        userDtos.setIdUser(usuario.getIdUser());
        userDtos.setUserName(usuario.getUserName());
        userDtos.setPassword(usuario.getPassword());
        userDtos.setEstado(usuario.getEstado());
        userDtos.setIdPersona(id_persona);
        userDtos.setIdRol(id_rol);
        return userDtos;
    }
    //convierte DTO a entidad
    private Usuario mapearEntidad(UserDtos userDtos) {
        Usuario usuario= new Usuario();
        Persona persona=new Persona();
        persona=personaRepository.findById(userDtos.getIdPersona()).orElseThrow(()->new ResourceNotFoundException("Persona", "id", userDtos.getIdPersona()));
        usuario.setUserName(userDtos.getUserName());
        usuario.setPassword(userDtos.getPassword());
        usuario.setEstado(userDtos.getEstado());
        usuario.setPersona(persona);
        return usuario;
    }

}
