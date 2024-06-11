package com.microservicio.backendspring.repository;

import com.microservicio.backendspring.model.Roles;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;


public interface RoleRepository extends MongoRepository<Roles, String> {

    Optional<Roles> findByName(String name);

    List<Roles> findAllByNameIn(List<String> names);
}
