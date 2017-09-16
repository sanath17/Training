package com.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.spring.model.Student;


@Repository
@EnableTransactionManagement
public class StudentDAOImpl implements StudentDAO {
	

	private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

	@Override
	@SuppressWarnings("unchecked")
	public List<Student> findall() {
		Session session = this.sessionFactory.openSession();
		List<Student> users = session.createQuery("from Student").list();
		session.close();
		return users;
	}

	@Override
	@Transactional
	public Student create(Student student) {
		Session session = this.sessionFactory.openSession();
		session.persist(student);
		session.close();
		return student;
	}

	@Override
	@Transactional
	public void delete(Student student) {
		Session session = this.sessionFactory.openSession();
		session.delete(student);
		session.close();
	}

	@Override
	@Transactional
	public Student update(Student student) {
		Session session = this.sessionFactory.openSession();
		session.update(student);
		session.close();
		return  student;
	}

	@Override
	public Student findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
