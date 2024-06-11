package com.microservicio.backendspring.model;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "tank")
public class Tanque {

    @Id
    private ObjectId id;

    @NotNull(message = "El campo cantida de combustible no puede estar vacio")
    private double fuel_quantity;

    @NotNull(message = "El campo cantida maxima no puede estar vacio")
    private double cap_max;

    @NotNull(message = "El campo cantida minima no puede estar vacio")
    private double cap_min;

    @NotNull(message = "El campo estado no puede estar vacio")
    private int status;


}
