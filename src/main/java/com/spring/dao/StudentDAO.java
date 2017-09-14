package com.spring.dao;

import java.util.List;

import com.spring.model.Student;

public interface StudentDAO {
	
	public List<Student> findall();
	
	public Student findById(String id);
	
	public Student create(Student student);
	
	public void delete(Student student);
	
	public Student update(Student student);
	
}
