package com.microservicio.backendspring.controllerGrapQL;


import com.microservicio.backendspring.dto.ResponseUserDto;
import com.microservicio.backendspring.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;


import java.util.List;

@Controller
public class UserController {


    @Autowired
    private UsuarioService usuarioService;

    @PreAuthorize("hasAnyRole('ADMIN', 'SELLER')")
    @QueryMapping
    public List<ResponseUserDto> getAllUser() {
        return usuarioService.findAll();
    }


}
