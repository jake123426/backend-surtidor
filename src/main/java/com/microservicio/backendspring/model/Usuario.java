package com.microservicio.backendspring.model;


import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
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
@Document(collection = "user")
public class Usuario {

    @Id
    private ObjectId id;

    @NotNull(message = "El campo nombre no puede estar vacio")
    private String name;

//    @Indexed(unique = true)
    @NotNull(message = "El campo email no puede estar vacio")
    private String email;

    @NotNull(message = "El campo password no puede estar vacio")
    private String password;

    @NotNull(message = "El campo status no puede estar vacio")
    private int status;

    @DocumentReference(collection = "pump")
    private Bomba bomba;

    @DocumentReference(collection = "role")
    private List<Roles> roles;


}
