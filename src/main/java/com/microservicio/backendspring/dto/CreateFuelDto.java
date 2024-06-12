package com.microservicio.backendspring.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateFuelDto(
        @NotBlank String name,
        @NotBlank double sale_price,
        @NotBlank double purchase_price,
        @NotBlank double measurement
) {
}
