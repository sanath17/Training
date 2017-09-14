package com.spring.controller;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.dao.LoginDAO;
import com.spring.model.Login;

@Controller
public class LoginController {
	
//	@RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
//    public String listUsers(ModelMap model) {
// 
//        List<User> users = userService.findAllUsers();
//        model.addAttribute("users", users);
//        return "userslist";
//    }
//	  /**
//     * This method will provide the medium to add a new user.
//     */
//    @RequestMapping(value = { "/newuser" }, method = RequestMethod.GET)
//    public String newUser(ModelMap model) {
//        User user = new User();
//        model.addAttribute("user", user);
//        model.addAttribute("edit", false);
//        return "registration";
//    }
// 
//    /**
//     * This method will be called on form submission, handling POST request for
//     * saving user in database. It also validates the user input
//     */
//    @RequestMapping(value = { "/newuser" }, method = RequestMethod.POST)
//    public String saveUser(@Valid User user, BindingResult result,
//            ModelMap model) {
// 
//        if (result.hasErrors()) {
//            return "registration";
//        }
// 
//	
	
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
		List<Login> list = loginDAO.list();
		if(list.contains(login.getUserName())){
			model.addAttribute("error", "User already exist"); 
			return "login"; 
		}
		
		context.close();
		
		return "success";
	}
}


