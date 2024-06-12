package com.microservicio.backendspring.repository;

import com.microservicio.backendspring.model.Vehiculo;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface VehiculoRepository extends MongoRepository<Vehiculo, String> {
}
