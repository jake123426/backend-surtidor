package com.microservicio.backendspring.model;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "pump")
public class Bomba {

    @Id
    private ObjectId id;

    @NotNull(message = "El campo nombre no puede estar vacio")
    private String name;

    @NotNull(message = "El campo descripción no puede estar vacio")
    private String description;

    @NotNull(message = "El campo tipo de combustible no puede estar vacio")
    private String fuel_type;

    @NotNull(message = "El campo estado no puede estar vacio")
    private int status;

    @DocumentReference(collection = "tank")
    private Tanque tanque;

}
