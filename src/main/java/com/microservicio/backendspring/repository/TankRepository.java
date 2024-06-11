package com.microservicio.backendspring.repository;

import com.microservicio.backendspring.model.Tanque;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TankRepository extends MongoRepository<Tanque, String> {
}
