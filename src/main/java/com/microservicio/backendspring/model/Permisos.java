package com.microservicio.backendspring.model;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "permission")
public class Permisos {

    @Id
    private ObjectId id;

    @NotNull(message = "El campo nombre no puede estar vacio")
    private String name;
}
