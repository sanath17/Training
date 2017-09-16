package com.spring.controller;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.model.Batch;
import com.spring.service.BatchService;

@Controller
public class BatchController {
	
	@RequestMapping(value = "/batch", method = RequestMethod.GET)
	public String init(Model model) {
		model.addAttribute("msg", "Please Enter Your Login Details");
		return "batch";
	}
	
	@RequestMapping(value = "/batchview", method = RequestMethod.GET)
	public String batchlist(Model model) {
		model.addAttribute("msg", "Please Enter Your Login Details");
		return "batchview";
	}
	
		@SuppressWarnings("resource")
		@RequestMapping(value = { "/registerbatch"} , method = RequestMethod.POST)
		public String saveUser(ModelMap model, @ModelAttribute("login") Batch batch) {
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
			Batch BatchUser = new Batch();
			BatchService service = context.getBean(BatchService.class);
			BatchUser.setBatch_id(batch.getBatch_id());
			BatchUser.setCourse(batch.getCourse());
			BatchUser.setProgram(batch.getProgram());
			BatchUser.setTrainer_name(batch.getTrainer_name());
			BatchUser.setStudent_count(batch.getStudent_count());
			BatchUser.setCreated_date(batch.getCreated_date());
			BatchUser.setUpdated_date(batch.getUpdated_date());
			service.create(BatchUser);
			model.addAttribute("success", "program " + BatchUser.getProgram() + " registered successfully");
			return "success";	
		}
		
		@SuppressWarnings("resource")
		@RequestMapping(value = "/listbatch", method = RequestMethod.GET) 
	    public ModelAndView listbatches(){ 
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
			BatchService service = context.getBean(BatchService.class);
//			List<Batch> listbatch = service.findall();
//			 for(Batch model : listbatch) {
//		            System.out.println(model.toString());
//		        }
			 return new ModelAndView("listbatches","listBatch",service.findall());
		}
}
