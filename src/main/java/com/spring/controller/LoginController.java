package com.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

import com.spring.model.Login;
import com.spring.service.LoginService;


@Controller
public class LoginController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String init(Model model) {
		model.addAttribute("msg", "Please Enter Your Login Details");
		return "login";
	}
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerUser(Model model) {
		model.addAttribute("msg", "Please Enter Your Login Details");
		return "register";
	}
	
	@SuppressWarnings({ "resource", "null" })
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	  public String loginProcess(Model model,HttpServletRequest request, HttpServletResponse response,
	  @ModelAttribute("login") Login login) {
	    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		LoginService loginDAO = context.getBean(LoginService.class);
	    Login loginUser = loginDAO.validateUser(login);
	    if (null != loginUser) {
	    	 String redirectUrl = "/batchview";
	         return "redirect:" + redirectUrl;
	    }else{
	    model.addAttribute("msg", loginUser.getUserName()); 
	    String redirectUrl = "/login";
        return "redirect:" + redirectUrl;
	    }
	  }
	
	
	@SuppressWarnings("resource")
	@RequestMapping(value = "/userlist", method = RequestMethod.GET)
	public String listUsers(ModelMap model) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		LoginService service = context.getBean(LoginService.class);
		List<Login> users = service.listAllUsers();
		model.addAttribute("users", users);
		return "allusers";
	}
	
	@SuppressWarnings("resource")
	@RequestMapping(value = { "/registeruser" }, method = RequestMethod.POST)
	public String saveUser(ModelMap model, @ModelAttribute("login") Login login) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		Login loginUser = new Login();
		LoginService service = context.getBean(LoginService.class);
		loginUser.setUserName(login.getUserName());
		loginUser.setPassword(login.getPassword());
		loginUser.setEmail(login.getEmail());
		loginUser.setFirst_name(login.getFirst_name());
		loginUser.setLast_name(login.getLast_name());
		loginUser.setCreated_date(login.getCreated_date());
		loginUser.setUpdated_date(login.getUpdated_date());
		service.create(loginUser);
		model.addAttribute("success", "User " + loginUser.getUserName() + " registered successfully");
		return "success";	
	}

	
	@SuppressWarnings("resource")
	@RequestMapping(value ="/updateuser{id}", method = RequestMethod.POST)
    public String updateUser(@Validated Login user, BindingResult result,
            ModelMap model, @PathVariable String id) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		LoginService service = context.getBean(LoginService.class);
        if (result.hasErrors()) {
            return "registration";
        }
        service.update(id);
//        model.addAttribute("success", " user " + repository.findById(id) + " updated successfully");
        model.addAttribute("success", " user  updated successfully");
        return "success";
    }
	
	@SuppressWarnings("resource")
	@RequestMapping(value = { "/deleteuser-{id}" }, method = RequestMethod.GET)
    public String deleteUser(@PathVariable String id) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		LoginService service = context.getBean(LoginService.class);
        service.delete(id);
        return "redirect:/userlist";
    }
	
}
