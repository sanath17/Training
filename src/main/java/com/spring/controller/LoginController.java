package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.dao.LoginDAO;
import com.spring.dao.LoginDAOImpl;
import com.spring.model.Login;
import com.spring.service.LoginServiceImpl;

@Controller
public class LoginController {

	@Autowired
	private LoginServiceImpl service;
	
	@Autowired
	private LoginDAOImpl repository;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String init(Model model) {
		model.addAttribute("msg", "Please Enter Your Login Details");
		return "login";
	}
	@SuppressWarnings("resource")
	@RequestMapping(value = "/submitForm", method = RequestMethod.POST)
	public String submit(Model model, @ModelAttribute("login") Login login) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

		LoginDAO loginDAO = context.getBean(LoginDAO.class);
		List<Login> list = loginDAO.listAllUsers();
		if (list.contains(login.getUserName())) {
			model.addAttribute("error", "User already exist");
			return "login";
		}

		context.close();

		return "success";
	}

	@RequestMapping(value = "/userlist", method = RequestMethod.GET)
	public String listUsers(ModelMap model) {
		List<Login> users = service.listAllUsers();
		model.addAttribute("users", users);
		return "allemployees";
	}

	@RequestMapping(value = { "/registeruser" }, method = RequestMethod.POST)
	public String saveEmployee(@Validated Login login, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "registration";
		}
		service.create(login);
		model.addAttribute("success", "User " + login.getUserName() + " registered successfully");
		return "success";
	}
	
	@RequestMapping(value ="/updateuser{id}", method = RequestMethod.POST)
    public String updateEmployee(@Validated Login user, BindingResult result,
            ModelMap model, @PathVariable String id) {
        if (result.hasErrors()) {
            return "registration";
        }
        service.update(id);
        model.addAttribute("success", " user " + repository.findById(id) + " updated successfully");
        return "success";
    }

	@RequestMapping(value = { "/deleteuser-{id}" }, method = RequestMethod.GET)
    public String deleteUser(@PathVariable String id) {
        service.delete(id);
        return "redirect:/userlist";
    }
	
}
