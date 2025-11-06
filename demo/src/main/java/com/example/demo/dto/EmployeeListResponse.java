package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Lightweight response for lists (can be extended later).
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeListResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private Double expectedSalary;
}
