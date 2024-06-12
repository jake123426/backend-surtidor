package com.microservicio.backendspring.repository;


import com.microservicio.backendspring.model.Combustible;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface FuelRepository extends MongoRepository<Combustible, String> {

    Optional<Combustible> findCombustibleByName(String fuel);
}
