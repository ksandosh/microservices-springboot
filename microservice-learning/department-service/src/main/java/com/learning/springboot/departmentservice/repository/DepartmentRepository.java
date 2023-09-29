package com.learning.springboot.departmentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.springboot.departmentservice.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    Department findByDepartmentCode(String departmentCode);
}
