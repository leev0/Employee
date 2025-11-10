package com.example.demo.service;

import com.example.demo.dto.EmployeeListResponse;
import com.example.demo.dto.EmployeeResponse;
import com.example.demo.dto.InputDto;
import com.example.demo.dto.SecondHighestSalaryResponse;
import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository repository;
    private final PasswordEncoder passwordEncoder;

    /**
     * Registers a new employee.
     */

    @CachePut(value = "employees", key = "#result.id")
    public EmployeeResponse createEmployee(InputDto req) {
        if (repository.existsByUsername(req.getUsername())) {
            throw new IllegalArgumentException("username already exists");
        }

        Employee employee = new Employee();
        employee.setName(req.getName());
        employee.setUsername(req.getUsername());
        employee.setPassword(passwordEncoder.encode(req.getPassword()));
        employee.setExpectedSalary(req.getExpectedSalary());

        Employee saved = repository.save(employee);

        return new EmployeeResponse(
                saved.getId(),
                saved.getName(),
                saved.getUsername(),
                saved.getExpectedSalary()
        );
    }

    @Cacheable("employees")
    public Optional<SecondHighestSalaryResponse> getSecondHighestSalary() {
        List<Double> distinctSalaries = repository.findDistinctExpectedSalariesDesc();

        if (distinctSalaries.size() < 2) {
            // less than two distinct salaries → no second-highest
            return Optional.empty();
        }

        Double secondHighest = distinctSalaries.get(1);
        List<Employee> employees = repository.findByExpectedSalary(secondHighest);

        List<EmployeeListResponse> employeeDtos = new ArrayList<>();
        for (Employee e : employees) {
            employeeDtos.add(new EmployeeListResponse(
                    e.getId(),
                    e.getName(),
                    e.getUsername(),
                    e.getExpectedSalary()
            ));
        }

        SecondHighestSalaryResponse response = new SecondHighestSalaryResponse(secondHighest, employeeDtos);
        return Optional.of(response);
    }
}
