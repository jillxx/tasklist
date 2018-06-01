package com.gc.tasklist.TaskList.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.gc.tasklist.TaskList.entity.User;

@Repository
@Transactional
public class userDao {

	@PersistenceContext
	EntityManager em;
	
	public User addUser(User p) {
		return em.merge(p);
	}
	
	public User findUser(String uName) {
		return em.find(User.class, uName);
	}
	
	public boolean checkUser(String uname, String pass) {
		User p = findUser(uname);
		if(p == null) {
			return false;
		}
		if (p.getPassword().equals(pass)) {
			return true;
		} else
			return false;	
	}
	
}
