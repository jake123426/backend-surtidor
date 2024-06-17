package com.microservicio.backendspring.dto;

import jakarta.validation.constraints.NotBlank;

public record CreatePumpDto(
        @NotBlank String name,
        @NotBlank String description,
        @NotBlank String fuel_type,
        @NotBlank String tank,
        @NotBlank int status
) {
}
