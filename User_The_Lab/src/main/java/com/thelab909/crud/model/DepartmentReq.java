package com.thelab909.crud.model;

import java.util.List;

public class DepartmentReq {
    private String name;
    private List<String> employees;
	public DepartmentReq(String name, List<String> employees) {
		super();
		this.name = name;
		this.employees = employees;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getEmployees() {
		return employees;
	}
	public void setEmployees(List<String> employees) {
		this.employees = employees;
	}
    
    
}
