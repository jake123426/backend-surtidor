package com.microservicio.backendspring.model;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "role")
public class Roles {

    @Id
    private ObjectId id;

    @NotNull(message = "El campo nombre no puede estar vacio")
    private String name;

    @DocumentReference(collection = "permission")
    private List<Permisos> permisos;
}
