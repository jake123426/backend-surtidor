package com.microservicio.backendspring.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateTankDto(
        @NotBlank String name,
        @NotBlank double fuel_quantity,
        @NotBlank double cap_max,
        @NotBlank double cap_min,
        @NotBlank String fuel
) {
}
