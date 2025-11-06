package com.example.demo.repository;

import com.example.demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findByUsername(String username);
    boolean existsByUsername(String username);

    @Query("SELECT DISTINCT e.expectedSalary FROM Employee e ORDER BY e.expectedSalary DESC")
    List<Double> findDistinctExpectedSalariesDesc();

    List<Employee> findByExpectedSalary(Double expectedSalary);
}
