package com.microservicio.backendspring.service;


import com.microservicio.backendspring.dto.CreateUserDto;
import com.microservicio.backendspring.dto.ResponseUserDto;
import com.microservicio.backendspring.model.Roles;
import com.microservicio.backendspring.model.Usuario;
import com.microservicio.backendspring.repository.RoleRepository;
import com.microservicio.backendspring.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RoleRepository roleRepository;


    public ResponseUserDto findUserByEmail(String email) {
        Usuario usuario = usuarioRepository.findUsuarioByEmail(email)
                .orElseThrow( () -> new RuntimeException("No existe el usuario con el correo: " + email) );
        List<String> roles = this.getRoles(usuario);
        List<String> permisos = this.getPermisos(usuario);
        return new ResponseUserDto(usuario.getId().toString(), usuario.getName(),
                usuario.getPassword(), usuario.getEmail(), roles, permisos);
    }

    public ResponseUserDto create(CreateUserDto createUserDto) {
        String name = createUserDto.username();
        String password = createUserDto.password();
        String email = createUserDto.email();
        List<String> roles = createUserDto.roles();
        List<Roles> rolesDocument = roleRepository.findAllByNameIn(roles);

        Usuario usuario = Usuario.builder()
                .name(name)
                .password(password)
                .email(email)
                .roles(rolesDocument)
                .build();
        Usuario savedUsuario = usuarioRepository.save(usuario);
        List<String> permisos = this.getPermisos(savedUsuario);

        return new ResponseUserDto(savedUsuario.getId().toString(), savedUsuario.getName(),
                savedUsuario.getPassword(),savedUsuario.getEmail(), roles, permisos);
    }

    public List<Usuario> findAll() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        List<ResponseUserDto> usuariosDto = new ArrayList<>();
        return new ArrayList<>();
//        return usuarioRepository.findAll();
    }

    private List<String> getRoles(Usuario usuario) {
        List<String> roles = new ArrayList<>();
        usuario.getRoles().forEach( rol -> roles.add(rol.getName()));
        return roles;
    }
    private List<String> getPermisos(Usuario usuario) {
        List<String> permisos = new ArrayList<>();
        usuario.getRoles().stream()
                .flatMap( rol -> rol.getPermisos().stream())
                .forEach(permiso -> permisos.add(permiso.getName()));
        return permisos;
    }

}
