package com.thelab909.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thelab909.crud.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
