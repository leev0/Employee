package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class InputDto {
    @NotBlank(message = "firstName is required")
    private String name;

    @NotBlank(message = "username is required")
    private String username;

    @NotBlank(message = "password is required")
    private String password;

    @NotNull(message = "expectedSalary is required")
    private Double expectedSalary;
}