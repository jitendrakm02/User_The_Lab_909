package com.thelab909.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thelab909.crud.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
