package com.gc.tasklist.TaskList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gc.coffeeshop.entity.Items;

@Controller
public class HomeController {

	@Autowired
	private UserDao userDao;
	private TaskDao taskDao;
	
	@RequestMapping("/")
	public ModelAndView index() {
		return new ModelAdnView ("index");
	}
	
	@RequestMapping("/preRegister")
	public String form() {
		return "register";
	}
	
	@RequestMapping("/register")
	public ModelAndView register(@RequestParam("email") String email, @RequestParam("password") String password) {
		User user = new User(email, password);
		userDao.addUser(user);
		return new ModelAndView ("redirect:/");
	}
	
	@RequestMapping("/login")
	public ModelAndView login(@RequestParam("email") String email, @RequestParam("password") String password) {
		List<Task> tasklist = taskDao.findList(email, password);
		
		return new ModelAdnView ("task", "tasklist", tasklist);
	}

	@RequestMapping("/addItem")
	public String addfrom() {
		return "addItem";
	}

	@RequestMapping("/add")
	public ModelAndView add(@RequestParam("description") String description, @RequestParam("duedate") String duedate,
			@RequestParam("status") String status) {
		
		Task task = new Task(description, duedate, status);
		taskDao.update(task);
		return new ModelAndView("index", "tasklist", taskDao.findlist());
	}

	
}
