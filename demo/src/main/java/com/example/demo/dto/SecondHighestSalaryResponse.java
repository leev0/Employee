package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SecondHighestSalaryResponse implements Serializable {
    private Double secondHighestSalary;
    private List<EmployeeListResponse> employees;
}
