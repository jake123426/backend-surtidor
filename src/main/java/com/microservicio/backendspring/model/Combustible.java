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
@Document(collection = "fuel")
public class Combustible {

    @Id
    private ObjectId id;

    @NotNull(message = "El campo nombre no puede estar vacio")
    private String name;

    @NotNull(message = "El campo precio de venta no puede estar vacio")
    private double sale_price;

    @NotNull(message = "El campo precio de compra no puede estar vacio")
    private double purchase_price;

    @NotNull(message = "El campo medición no puede estar vacio")
    private String measurement;

}
