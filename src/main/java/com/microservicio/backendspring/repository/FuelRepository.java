package com.microservicio.backendspring.repository;


import com.microservicio.backendspring.model.Combustible;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FuelRepository extends MongoRepository<Combustible, String> {
}
