package com.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.dao.StudentDAOImpl;
import com.spring.model.Student;


@Service
public class StudentServiceIMpl implements StudentService {

	private StudentDAOImpl StudentDAO;
	
	public StudentDAOImpl getStudentDAO() {
		return StudentDAO;
	}

	public void setStudentDAO(StudentDAOImpl studentDAO) {
		StudentDAO = studentDAO;
	}

	@Override
	public List<Student> findall() {
		// TODO Auto-generated method stub
		return StudentDAO.findall();
	}

	@Override
	public Student create(Student student) {
		// TODO Auto-generated method stub
		return StudentDAO.create(student);
	}

	@Override
	public void delete(String id) {
		Student existing = StudentDAO.findById(id);
		if(existing==null){
			System.out.println("no student found to delete");
			//exception
		}
		StudentDAO.delete(existing);
	}

	@Override
	public Student update(String id) {
		Student existing = StudentDAO.findById(id);
		if(existing==null){
			System.out.println("not found");
			//exception
		}
		return existing;
	}

	
}
