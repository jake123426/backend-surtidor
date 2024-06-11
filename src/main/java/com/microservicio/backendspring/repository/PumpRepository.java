package com.microservicio.backendspring.repository;


import com.microservicio.backendspring.model.Bomba;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PumpRepository extends MongoRepository<Bomba, String> {
}
