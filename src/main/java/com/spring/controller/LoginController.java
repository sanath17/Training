package com.spring.controller;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.dao.LoginDAO;
import com.spring.model.Employee;
import com.spring.model.LoginBean;

@Controller
public class LoginController {
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String init(Model model) {
		model.addAttribute("msg", "Please Enter Your Login Details");
		return "login";
	}

	// Bhanu,Sanath,Sriram..

	// ToDo

	// Once controll comes here go ahead and integrate our hibernate stuff

	//

	@SuppressWarnings("resource")
	@RequestMapping(value = "/submitForm", method = RequestMethod.POST)
	public String submit(Model model, @ModelAttribute("loginBean") LoginBean loginBean) {
		/*
		 * if (loginBean != null && loginBean.getUserName() != null &
		 * loginBean.getPassword() != null) { if
		 * (loginBean.getUserName().equals("rajesh") &&
		 * loginBean.getPassword().equals("rajesh123")) {
		 * model.addAttribute("msg", loginBean.getUserName()); return "success";
		 * } else { model.addAttribute("error", "Invalid Details"); return
		 * "login"; } } else { model.addAttribute("error",
		 * "Please enter Details"); return "login"; }
		 */

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

		LoginDAO loginDAO = context.getBean(LoginDAO.class);
		List<Employee> list = loginDAO.list();
		if(list.contains(loginBean.getUserName())){
			model.addAttribute("error", "User already exist"); 
			return "login"; 
		}
	
		Employee employee = new Employee();
		employee.setUserName(loginBean.getUserName());
		employee.setPassword(loginBean.getPassword());

		loginDAO.save(employee);

		System.out.println("Person::" + employee);
		

		for (Employee p : list) {
			System.out.println("Person List::" + p);
		}
		
		model.addAttribute("msg", loginBean.getUserName()); 
		
		context.close();
		
		return "success";
	}
}
