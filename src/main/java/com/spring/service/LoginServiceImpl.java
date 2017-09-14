package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.LoginDAOImpl;
import com.spring.model.Login;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginDAOImpl repository;
	
	
	@Override
	public List<Login> listAllUsers() {
		// TODO Auto-generated method stub
		return repository.listAllUsers();
	}

	@Override
	public Login create(Login login) {
		return repository.create(login);
	}

	@Override
	public Login update(String id) {
		Login existing = repository.findById(id);
		if(existing==null){
			System.out.println("not found");
			//exception
		}
		return existing;
	}

	@Override
	public void delete(String id) {
		Login existing = repository.findById(id);
		if(existing==null){
			System.out.println("no user found to delete");
			//exception
		}
		repository.delete(existing);
	}

}
