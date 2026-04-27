package com.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.model.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long>{

}
