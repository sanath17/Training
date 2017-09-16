package com.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.spring.model.Batch;


@Repository
@EnableTransactionManagement
public class BatchDAOImpl implements BatchDAO{
	
	private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

	@Override
	@SuppressWarnings("unchecked")
	public List<Batch> findall() {
		Session session = this.sessionFactory.openSession();
		List<Batch> users = session.createQuery("from Batch").list();
		session.close();
		return users;
	}

	@Override
	@Transactional
	public Batch create(Batch batch) {
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		session.save(batch);
		session.getTransaction().commit();
		return batch;
	}

	@Override
	public void delete(Batch batch) {
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		session.delete(batch);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	@Transactional
	public Batch update(Batch batch) {
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		session.update(batch);
		session.getTransaction().commit();
		session.close();
		return  batch;
	}

	@Override
	public Batch findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
