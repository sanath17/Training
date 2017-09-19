package com.spring.service;

import java.util.List;

import com.spring.model.Login;

public interface LoginService {

	
	public List<Login> listAllUsers();
	
	public Login create(Login login);
	
	public Login update(String id);
	
	public void delete(String id);

	public Login validateUser(Login login);
		
}
