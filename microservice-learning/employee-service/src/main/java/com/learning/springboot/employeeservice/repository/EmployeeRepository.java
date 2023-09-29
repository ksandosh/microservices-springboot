package com.learning.springboot.employeeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.springboot.employeeservice.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
