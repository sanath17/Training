package com.spring.controller;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.model.Student;
import com.spring.service.StudentService;

@Controller
public class StudentController {
	
	@RequestMapping(value = "/student", method = RequestMethod.GET)
	public String init(Model model) {
		model.addAttribute("msg", "Please Enter Your Login Details");
		return "student";
	}
	
		@SuppressWarnings("resource")
		@RequestMapping(value = { "/registerstudent"} , method = RequestMethod.POST)
		public String saveUser(ModelMap model, @ModelAttribute("student") Student student) {
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
			Student StudentUser = new Student();
			StudentService service = context.getBean(StudentService.class);
			StudentUser.setBatch_id(student.getBatch_id());
			StudentUser.setName(student.getName());
			StudentUser.setEmail(student.getEmail());
			StudentUser.setContact(student.getContact());
			StudentUser.setCost(student.getCost());
			StudentUser.setVisa_status(student.getVisa_status());
			StudentUser.setCreated_date(student.getCreated_date());
			StudentUser.setUpdated_date(student.getCreated_date());
			service.create(StudentUser);
			model.addAttribute("success", "student " + StudentUser.getName() + " registered successfully");
			List<Student> list = 	service.findall();
			for (Student p : list) {
				System.out.println("Student List::" + p);
			}
			model.addAttribute("msg", list); 
			context.close();
			return "studentview";
		}
		
		@SuppressWarnings("resource")
		@RequestMapping(value = "/studentview", method = RequestMethod.GET) 
		public String listBatch(ModelMap model, @ModelAttribute("student") Student student){
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
			StudentService service = context.getBean(StudentService.class);
			List<Student> list = 	service.findall();
			for (Student p : list) {
				System.out.println("Student List::" + p);
			}
			model.addAttribute("msg", list); 
			context.close();
			return "studentview";
		}
	
}