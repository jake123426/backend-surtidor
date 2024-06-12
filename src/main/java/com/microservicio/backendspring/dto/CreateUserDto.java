package com.microservicio.backendspring.dto;


import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record CreateUserDto(@NotBlank String username,
                            @NotBlank String password,
                            @NotBlank String email,
                            @NotBlank String bomba,
                            @NotBlank List<String> roles) {
}
