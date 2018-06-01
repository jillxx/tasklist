package com.gc.tasklist.TaskList;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gc.tasklist.TaskList.dao.taskDao;
import com.gc.tasklist.TaskList.dao.userDao;
import com.gc.tasklist.TaskList.entity.Task;
import com.gc.tasklist.TaskList.entity.User;

@Controller
public class HomeController {

	@Autowired
	private userDao userDao;
	private taskDao taskDao;

	@RequestMapping("/")
	public ModelAndView index() {
		return new ModelAndView("index");
	}

	@RequestMapping("/preRegister")
	public String form() {
		return "register";
	}

	@RequestMapping("/register")
	public ModelAndView register(@RequestParam("email") String email, @RequestParam("password") String password) {
		User user = new User(email, password);
		userDao.addUser(user);
		return new ModelAndView("redirect:/");
	}

	@RequestMapping("/login")
	public ModelAndView login(@RequestParam("email") String email, @RequestParam("password") String password) {

		if (userDao.checkUser(email, password)) {
				int id = userDao.findUser(email).getId();
			List<Task> tasklist = taskDao.listTasks(id);

			return new ModelAndView("task", "tasklist", tasklist);
		} else {
				System.out.println("not match");
			return new ModelAndView("index");
		}
	}

	@RequestMapping("/addItem")
	public String addfrom() {
		return "addItem";
	}

	@RequestMapping("/add")
	public ModelAndView add(@RequestParam("userid")int userid,@RequestParam("description") String description, @RequestParam("duedate") Date duedate,
			@RequestParam("status") boolean status) {

		Task task = new Task(userid, description, duedate, status);
		taskDao.addTask(task);
		return new ModelAndView("task", "tasklist",taskDao.listTasks(userid));
	}
	
	@RequestMapping("/delete")
	public ModelAndView delete(@RequestParam("name") String name, @RequestParam("userid")int userid) {

		taskDao.deleteByName(name);
		return new ModelAndView("task", "tasklist", taskDao.listTasks(userid));
	}

}
