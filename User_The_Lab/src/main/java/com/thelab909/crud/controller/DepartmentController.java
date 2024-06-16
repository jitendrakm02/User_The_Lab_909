package com.thelab909.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thelab909.crud.model.Department;
import com.thelab909.crud.model.DepartmentReq;
import com.thelab909.crud.model.Employee;
import com.thelab909.crud.service.DepartmentService;


@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<Department> saveDepartment(@RequestBody Department department) {
        Department savedDepartment = departmentService.saveDepartment(department);
        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }
    @PostMapping("/{dId}/depWithEmp")
    public ResponseEntity<Department> saveDepartmentWithEmployee(@PathVariable Long dId, @RequestBody List<Employee> employees) {
    	Department savedDepartment = departmentService.saveDepartmentWithEmployee(dId,employees);
    	return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }
    @PostMapping("/depWithEmp")
    public ResponseEntity<Department> saveDepartmentWithEmployees(@RequestBody DepartmentReq employees) {
    	Department savedDepartment = departmentService.saveDepartmentWithEmployees(employees);
    	return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Department>> getAllDepartments() {
        List<Department> departments = departmentService.getAllDepartments();
        return new ResponseEntity<>(departments, HttpStatus.OK);
    }
}