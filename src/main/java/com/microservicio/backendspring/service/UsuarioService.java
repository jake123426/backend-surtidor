package com.microservicio.backendspring.service;


import com.microservicio.backendspring.dto.CreateUserDto;
import com.microservicio.backendspring.dto.ResponseUserDto;
import com.microservicio.backendspring.model.Bomba;
import com.microservicio.backendspring.model.Roles;
import com.microservicio.backendspring.model.Usuario;
import com.microservicio.backendspring.repository.PumpRepository;
import com.microservicio.backendspring.repository.RoleRepository;
import com.microservicio.backendspring.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PumpRepository pumpRepository;


    public ResponseUserDto findUserByEmail(String email) {
        Usuario usuario = usuarioRepository.findUsuarioByEmail(email)
                .orElseThrow( () -> new RuntimeException("No existe el usuario con el correo: " + email) );
        List<String> roles = this.getRoles(usuario);
        List<String> permisos = this.getPermisos(usuario);
        return new ResponseUserDto(usuario.getId().toString(), usuario.getName(),
                usuario.getPassword(), usuario.getEmail(), null,null, roles, permisos);
    }

    public ResponseUserDto create(CreateUserDto createUserDto) {
        Bomba bomba = pumpRepository.findBombaByName(createUserDto.bomba()).orElse(null);
        List<String> roles = createUserDto.roles();
        List<Roles> rolesDocument = roleRepository.findAllByNameIn(roles);

        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        String formattedDate = format.format(date);

        Usuario usuario = Usuario.builder()
                .name(createUserDto.username())
                .password(createUserDto.password())
                .email(createUserDto.email())
                .status(1)
                .bomba(bomba)
                .createAt(formattedDate)
                .roles(rolesDocument)
                .build();
        Usuario savedUsuario = usuarioRepository.save(usuario);
        List<String> permisos = this.getPermisos(savedUsuario);

        return new ResponseUserDto(savedUsuario.getId().toString(), savedUsuario.getName(),
                savedUsuario.getPassword(),savedUsuario.getEmail(), bomba != null ? bomba.getName() : null, savedUsuario.getCreateAt(), roles, permisos);
    }

    public List<ResponseUserDto> findAll() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        List<ResponseUserDto> usuariosDto = new ArrayList<>();
        usuarios.forEach( usuario -> {
            List<String> roles = this.getRoles(usuario);
            List<String> permisos = this.getPermisos(usuario);
            ResponseUserDto responseUserDto = new ResponseUserDto(usuario.getId().toString(),
                    usuario.getName(), usuario.getPassword(), usuario.getEmail(),
                    usuario.getBomba() != null ? usuario.getBomba().getName() : null, usuario.getCreateAt(), roles, permisos);
            usuariosDto.add(responseUserDto);
        });
        return usuariosDto;
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
