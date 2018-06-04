package com.gc.tasklist.TaskList.dao;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.gc.tasklist.TaskList.entity.Task;


@Repository
@Transactional
public class taskDao {

	@PersistenceContext
	EntityManager em;
	
	public Task addTask(Task t) {
		return em.merge(t);
	}
	
	public List<Task> listTasks() {
		TypedQuery<Task> namedQuery = em.createNamedQuery("find_all_tasks", Task.class);
		return namedQuery.getResultList();
	}
	
	public List<Task> listTasks(String email) {
	//	System.out.println(email);
		Query query = em.createQuery("SELECT t FROM Task t WHERE email = '"+ email+ "'");
		
		return query.getResultList();
	}
	
	public List<Task> searchByD8(String email, Date duedate) {
	//	System.out.println(email);
		Query query = em.createQuery("SELECT t FROM Task t WHERE email = '"+ email+ "'" + "AND duedate = '" + duedate + "'");
		
		return query.getResultList();
	}
	public List<Task> searchByDescrip(String email, String description) {
	//	System.out.println(email);
		Query query = em.createQuery("SELECT t FROM Task t WHERE email = '"+ email+ "'" + "AND description CONTAINS '" + description + "'");
		
		return query.getResultList();
	}
	
	public List<Task> searchByStatus(String email, boolean status) {
	//	System.out.println(email);
		Query query = em.createQuery("SELECT t FROM Task t WHERE email = '"+ email+ "'" + "AND status = '" + status + "'");
		
		return query.getResultList();
	}
	
	public Task update(Task p) {
		return em.merge(p);
	}
	
	public Task findById(int idtask) {
		
        //(pojo ,  matching varible)
		return em.find(Task.class, idtask);
}

	
	
	public void deleteById(int idtask) {
		
		em.remove(findById(idtask));
	}
}
