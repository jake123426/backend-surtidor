package com.microservicio.backendspring.dto;


public record ResponsePumpDto(
        String id,
        String name,
        String description,
        String fuel_type,
        String tank
) {
}
