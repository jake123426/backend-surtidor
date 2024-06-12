package com.microservicio.backendspring.dto;

public record ResponseFuelDto(
        String id,
        String name,
        double sale_price,
        double purchase_price,
        double measurement
) {
}
