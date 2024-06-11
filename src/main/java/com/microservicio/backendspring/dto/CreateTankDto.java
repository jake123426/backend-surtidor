package com.microservicio.backendspring.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public record CreateTankDto(
        @NotEmpty double fuel_quantity,
        @NotBlank double cap_max,
        @NotBlank double cap_min
) {
}
