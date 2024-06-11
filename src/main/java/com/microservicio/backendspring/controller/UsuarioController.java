package com.microservicio.backendspring.controller;


import com.microservicio.backendspring.dto.CreateUserDto;
import com.microservicio.backendspring.dto.ResponseUserDto;
import com.microservicio.backendspring.model.Usuario;
import com.microservicio.backendspring.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/user/{email}")
    public ResponseEntity<?> getUsuario(@PathVariable String email){
        try {
            ResponseUserDto responseUserDto = usuarioService.findUserByEmail(email);
            return new  ResponseEntity<ResponseUserDto>(responseUserDto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
        }
    }
    @PostMapping("/user")
    public ResponseEntity<?> createUsuario(@RequestBody CreateUserDto usuario){
        ResponseUserDto responseUserDto = usuarioService.create(usuario);
        return new  ResponseEntity<ResponseUserDto>(responseUserDto, HttpStatus.OK);
    }

    @GetMapping("/user/all")
    public ResponseEntity<?> getAllUsers(){
        try {
            List<Usuario> usuarios = usuarioService.findAll();
            return new  ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getCause().toString(), HttpStatus.BAD_REQUEST);
        }
    }
}
