package com.spring.dao;

import java.util.List;

import com.spring.model.Login;

public interface LoginDAO {

	public List<Login> listAllUsers();
	
	public Login findById(String id);

	public Login create(Login login);

	public Login update(Login login);

	public void delete(Login login);
}
