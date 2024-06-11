package com.microservicio.backendspring.repository;

import com.microservicio.backendspring.model.Permisos;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface PermissionRepository extends MongoRepository<Permisos, String> {

    List<Permisos> findAllByNameIn(List<String> names);
}
