package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO returned after registering or fetching employee data.
 * Keeps sensitive data like password hidden.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponse implements Serializable {
    private Long id;
    private String name;
    private String username;
    private Double expectedSalary;
}

