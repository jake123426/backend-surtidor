package com.microservicio.backendspring.model;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
//@Document(collection = "vehicle")
public class Vehiculo {

//    @Id
//    private ObjectId id;
//
//    @NotNull(message = "El campo marca no puede estar vacio")
//    private String brand;
//
//    @NotNull(message = "El campo modelo no puede estar vacio")
//    private String model;
//
//    @NotNull(message = "El campo tipo de conbustible no puede estar vacio")
//    private String fuel_type;
//
//    @NotNull(message = "El campo numero de placa no puede estar vacio")
//    private String number_plate;
//
//    @NotNull(message = "El campo imagen no puede estar vacio")
//    private String path_image;
//
//    @NotNull(message = "El campo estado no puede estar vacio")
//    private int status;
}
