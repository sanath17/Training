package com.spring.service;

import java.util.List;

import com.spring.model.Student;

public interface StudentService {
	
	public List<Student> findall();
	
	public Student create(Student student);
	
	public void delete(String id);
	
	public Student update(String id);
	
}
