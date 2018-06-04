package com.gc.tasklist.TaskList;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gc.coffeeshop.entity.Items;
import com.gc.tasklist.TaskList.dao.taskDao;
import com.gc.tasklist.TaskList.dao.userDao;
import com.gc.tasklist.TaskList.entity.Task;
import com.gc.tasklist.TaskList.entity.User;

@Controller
public class HomeController {

	@Autowired
	private userDao userDao;
	@Autowired
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
		System.out.println(email);
		User user = new User(email, password);
		userDao.addUser(user);
		return new ModelAndView("redirect:/");
	}

	@RequestMapping("/login")
	public ModelAndView login(@RequestParam("email") String email, @RequestParam("password") String password) {

		if (userDao.checkUser(email, password)) {
				//int id = userDao.findUser(email).getId();

			List<Task> tasklist = taskDao.listTasks(email);
			System.out.println("test for finding tasklist");
			System.out.println(tasklist);//good

			return new ModelAndView("task", "tasklist", tasklist);
		} else {
				System.out.println("not match");
			return new ModelAndView("index");
		}
	}

	@RequestMapping("/addtask")
	public ModelAndView addfrom(@RequestParam("email")String email) {
		return new ModelAndView("addtask","useremail",email);
	}

	@RequestMapping("/add")
	public ModelAndView add(@RequestParam("description") String description, @RequestParam("duedate") Date duedate,
			@RequestParam("status") boolean status, @RequestParam("email") String email) {
		Task task = new Task(email, description, duedate, status);
		System.out.println(task);
		taskDao.addTask(task);
		return new ModelAndView("task", "tasklist",taskDao.listTasks(email));
	}
	
	@RequestMapping("/delete")
	public ModelAndView delete(@RequestParam("idtask") int idtask, @RequestParam("email")String email) {

		taskDao.deleteById(idtask);
		return new ModelAndView("task", "tasklist", taskDao.listTasks(email));
	}

	@RequestMapping("/search")
	public ModelAndView search(@RequestParam("words") String words, @RequestParam("email") String email) {
		List<Task> searchTasks = taskDao.search(words);
		return new ModelAndView("searchresults", "searchTasks", searchTasks);
	}
}
