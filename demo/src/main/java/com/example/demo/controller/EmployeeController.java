package com.example.demo.controller;

import com.example.demo.dto.EmployeeResponse;
import com.example.demo.dto.InputDto;
import com.example.demo.dto.SecondHighestSalaryResponse;
import com.example.demo.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@Tag(name = "Employee", description = "Employee operations")
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/employee/new")
    @Operation(summary = "Insert employee info")
    public ResponseEntity<EmployeeResponse> createEmployee(@Valid @RequestBody InputDto req) {
        EmployeeResponse response = employeeService.createEmployee(req);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/employee/second-highest")
    @Operation(summary = "Get second highest Salaray employee info")
    public ResponseEntity<SecondHighestSalaryResponse> getSecondHighestSalary() {
        // Get the result from service
        Optional<SecondHighestSalaryResponse> optionalResponse = employeeService.getSecondHighestSalary();

        if (optionalResponse.isPresent()) {
            SecondHighestSalaryResponse response = optionalResponse.get();
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
