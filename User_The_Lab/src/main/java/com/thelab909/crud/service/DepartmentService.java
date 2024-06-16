package com.thelab909.crud.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thelab909.crud.model.Department;
import com.thelab909.crud.model.DepartmentReq;
import com.thelab909.crud.model.Employee;
import com.thelab909.crud.repository.DepartmentRepository;
import com.thelab909.crud.repository.EmployeeRepository;

import jakarta.persistence.EntityNotFoundException;


@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private EmployeeRepository emplRepository;

    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }
    public Department saveDepartmentWithEmployee(Long departmentId,List<Employee> employees) {
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new EntityNotFoundException("Department not found"));

        for (Employee employee : employees) {
            employee.setDepartment(department);
        }

       // department.getEmployees().addAll(employees);
        departmentRepository.save(department);

        return department;
    }
    public Department saveDepartmentWithEmployees(DepartmentReq depReq) {
       Department department=new Department(depReq);
    	department=departmentRepository.save(department);
       for (String employee : depReq.getEmployees()) {
          Employee emp=new Employee();
          emp.setName(employee);
          
          emp.setDepartment(department);
          emplRepository.save(emp);
    	}
    	
    	
    	return department;
    }
//    public Department saveDepartmentWithEmployee(Department department) {
//    	department=departmentRepository.save(department);
////    	Department dep=new Department();
////    	List<Employee> employee= new  ArrayList<Employee>();    	
////    	department.getEmployees().stream().forEach(empDto ->{     
////            //here I fill the CartItem objects;     
////    		Employee empItem = new Employee();         
////    		empItem.setDepartment(dep);
////    		employee.add(empItem);                
////        });
////    	departmentRepository.save(department);
////    	dep.setEmployees(employee);    	
////    	departmentRepository.save(dep);
//    	Department dep=new Department();
//    	List<Employee> employee= new  ArrayList<Employee>();
//    	department.getEmployees().stream().forEach(empDto ->{
//    		Employee empItem = new Employee();
//    		empItem.setDepartment(dep);
//    		employee.add(empItem);
//    	});
//    	dep.setEmployees(employee);
//    	departmentRepository.save(department);
//    	return department;
//    }

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }
}
