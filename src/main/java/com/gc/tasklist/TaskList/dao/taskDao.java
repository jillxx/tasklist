package com.gc.tasklist.TaskList.dao;

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
	
	public List<Task> listTasks(int id) {
//		System.out.println(id);
		Query query = em.createQuery("SELECT t FROM Task t WHERE userid = "+ id);
		
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
