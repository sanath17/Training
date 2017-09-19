package com.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.spring.model.Login;

@Repository
@EnableTransactionManagement
public class LoginDAOImpl implements LoginDAO {
	

	 private SessionFactory sessionFactory;
	
	 public void setSessionFactory(SessionFactory sessionFactory){
	     this.sessionFactory = sessionFactory;
	  }
	 

//	public List<Login> list() {
//		Session session = this.sessionFactory.openSession();
//		@SuppressWarnings("unchecked")
//		List<Login> employeeList = session.createQuery("from Login").list();
//		session.close();
//		//employeeList.contains("rajesh");
//		return employeeList;
//	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Login> listAllUsers() {
		Session session = this.sessionFactory.openSession();
		List<Login> users = session.createQuery("from Login").list();
		session.close();
		return users;
	}

	@Override
	@Transactional
	public Login create(Login login) {
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		session.save(login);
		session.getTransaction().commit();
		session.close();
		return login;
	}

	@Override
	@Transactional
	public Login update(Login login) {
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		session.update(login);
		session.getTransaction().commit();
		session.close();
		return  login;
	}

	@Override
	public void delete(Login login) {
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		session.delete(login);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public Login findById(String id) {
//		Session session = this.sessionFactory.openSession();
//List<Login> users = session.createQuery("") need query to retrieve one user based on id 
//		                                      where id is passed as a argument
//		if (users != null && users.size() == 1)
//			return users.get(0);
		return null;
	}


	@Override
	@SuppressWarnings("unchecked")
	public Login validateUser(Login login) {
		Session session = this.sessionFactory.openSession();
		String username =login.getUserName();
		String password =login.getPassword();
		String sql=" From Login l where l.username='"+ username +"' and l.password='"+password+"'";
		List<Login> employeeList = session.createQuery(sql).list();
		return employeeList.size() > 0 ? employeeList.get(0) : null;
	}
}
