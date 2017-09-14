package com.spring.dao;

import java.util.List;

import com.spring.model.Student;

public interface StudentDAO {
	
	public List<Student> findall();
	
	public Student create(Student student);
	
	public void delete(String id);
	
	public Student update(String id);
	
}
