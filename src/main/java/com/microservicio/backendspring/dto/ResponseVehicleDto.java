package com.microservicio.backendspring.dto;

public record ResponseVehicleDto(
        String id,
        String brand,
        String model,
        String fuel_type,
        String number_plate,
        String path_image,
        int status
) {
}
