package com.microservicio.backendspring.repository;

import com.microservicio.backendspring.model.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {

    Optional<Usuario> findUsuarioByEmail(String email);

}
