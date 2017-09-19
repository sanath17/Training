package com.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.LoginDAOImpl;
import com.spring.model.Login;

@Service
@EnableTransactionManagement
public class LoginServiceImpl implements LoginService {
	

	private LoginDAOImpl loginDAO;
	
	public LoginDAOImpl getLoginDAO() {
		return loginDAO;
	}

	public void setLoginDAO(LoginDAOImpl loginDAO) {
		this.loginDAO = loginDAO;
	}

	@Override
	public List<Login> listAllUsers() {
		// TODO Auto-generated method stub
		return loginDAO.listAllUsers();
	}

	@Override
	@Transactional
	public Login create(Login login) {
		return loginDAO.create(login);
	}

	@Override
	@Transactional
	public Login update(String id) {
		Login existing = loginDAO.findById(id);
		if(existing==null){
			System.out.println("not found");
			//exception
		}
		return existing;
	}

	@Override
	public void delete(String id) {
		Login existing = loginDAO.findById(id);
		if(existing==null){
			System.out.println("no user found to delete");
			//exception
		}
		loginDAO.delete(existing);
	}

	@Override
	public Login validateUser(Login login) {
		// TODO Auto-generated method stub
		return loginDAO.validateUser(login);
	}

	
}
