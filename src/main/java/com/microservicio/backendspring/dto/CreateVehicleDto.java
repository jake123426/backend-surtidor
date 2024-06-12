package com.microservicio.backendspring.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateVehicleDto(
       @NotBlank String brand,
       @NotBlank String model,
       @NotBlank String fuel_type,
       @NotBlank String number_plate,
       @NotBlank String path_image
) {
}
