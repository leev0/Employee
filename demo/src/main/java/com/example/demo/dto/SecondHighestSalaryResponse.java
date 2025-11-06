package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SecondHighestSalaryResponse {
    private Double secondHighestSalary;
    private List<EmployeeListResponse> employees;
}
