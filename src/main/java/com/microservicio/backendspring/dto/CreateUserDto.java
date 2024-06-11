package com.microservicio.backendspring.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record CreateUserDto(@NotBlank String username,
                            @NotBlank String password,
                            @NotBlank String email,
                            @NotBlank List<String> roles) {
}
