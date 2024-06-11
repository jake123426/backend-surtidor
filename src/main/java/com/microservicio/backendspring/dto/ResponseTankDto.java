package com.microservicio.backendspring.dto;

public record ResponseTankDto(
        String id,
        String name,
        double fuel_quantity,
        double cap_max,
        double cap_min,
        String fuel
) {
}
