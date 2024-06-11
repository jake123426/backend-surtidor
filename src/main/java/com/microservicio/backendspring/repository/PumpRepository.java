package com.microservicio.backendspring.repository;


import com.microservicio.backendspring.model.Bomba;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface PumpRepository extends MongoRepository<Bomba, String> {

    Optional<Bomba> findBombaByName(String nombre);
}
