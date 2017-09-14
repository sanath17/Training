package com.spring.dao;

import java.util.List;

import com.spring.model.Employee;

public interface LoginDAO {

public void save(Employee p);
	
	public List<Employee> list();
}
