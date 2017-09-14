package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.StudentDAOImpl;
import com.spring.model.Student;


@Service
public class StudentServiceIMpl implements StudentService {

	@Autowired
	private StudentDAOImpl repository;
	
	@Override
	public List<Student> findall() {
		// TODO Auto-generated method stub
		return repository.findall();
	}

	@Override
	public Student create(Student student) {
		// TODO Auto-generated method stub
		return repository.create(student);
	}

	@Override
	public void delete(String id) {
		Student existing = repository.findById(id);
		if(existing==null){
			System.out.println("no student found to delete");
			//exception
		}
		repository.delete(existing);
	}

	@Override
	public Student update(String id) {
		Student existing = repository.findById(id);
		if(existing==null){
			System.out.println("not found");
			//exception
		}
		return existing;
	}

}
