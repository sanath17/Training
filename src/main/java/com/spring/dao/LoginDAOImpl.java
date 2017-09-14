package com.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.spring.model.Login;

public class LoginDAOImpl implements LoginDAO {
	private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

	public void save(Login p) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(p);
		tx.commit();
		session.close();
	}

	public List<Login> list() {
		Session session = this.sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<Login> employeeList = session.createQuery("from Login").list();
		session.close();
		//employeeList.contains("rajesh");
		return employeeList;
	}

}
