package com.spring.service;

import java.util.List;

import com.spring.model.Login;

public interface LoginService {

public void save(Login p);
	
	public List<Login> list();
}
