package com.thelab909.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thelab909.crud.model.Employee;
import com.thelab909.crud.repository.DepartmentRepository;
import com.thelab909.crud.repository.EmployeeRepository;


@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private DepartmentRepository departmentRepository;

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
    
    public Employee saveEmployees(Long dId,Employee employee) {
    	Optional<Object> emp=departmentRepository.findById(dId)
    			.map(empl->{employee.setDepartment(empl);return employeeRepository.save(employee);});
    	
    	return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
}