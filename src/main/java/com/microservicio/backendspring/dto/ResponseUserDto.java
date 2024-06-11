package com.microservicio.backendspring.dto;

import com.microservicio.backendspring.model.Roles;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record ResponseUserDto(
        String id,
        String name,
        String password,
        String email,
        String bomba,
        List<String> roles,
        List<String> permisos
) {
}
