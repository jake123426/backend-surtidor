package com.microservicio.backendspring.repository;

import com.microservicio.backendspring.model.Tanque;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface TankRepository extends MongoRepository<Tanque, String> {

    Optional<Tanque> findTanqueByName(String nombre);
}
