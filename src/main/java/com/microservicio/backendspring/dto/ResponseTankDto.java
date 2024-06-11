package com.microservicio.backendspring.dto;

public record ResponseTankDto(
        String id,
        double fuel_quantity,
        double cap_max,
        double cap_min
) {
}
