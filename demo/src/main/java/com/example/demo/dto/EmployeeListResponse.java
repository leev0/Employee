package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Lightweight response for lists (can be extended later).
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeListResponse implements Serializable {
    private Long id;
    private String name;
    private String userName;
    private Double expectedSalary;
}
