package com.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.spring.model.Employee;

public class LoginDAOImpl implements LoginDAO {
	private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

	public void save(Employee p) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(p);
		tx.commit();
		session.close();
	}

	public List<Employee> list() {
		Session session = this.sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<Employee> employeeList = session.createQuery("from Employee").list();
		session.close();
		//employeeList.contains("rajesh");
		return employeeList;
	}

}
