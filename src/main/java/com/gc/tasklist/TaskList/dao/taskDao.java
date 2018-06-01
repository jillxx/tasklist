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
	
	public Task addTask(Task p) {
		return em.merge(p);
	}
	
	public List<Task> listTasks() {
		TypedQuery<Task> namedQuery = em.createNamedQuery("find_all_tasks", Task.class);
		return namedQuery.getResultList();
	}
	
	public List<Task> listTasks(long id) {
		Query namedQuery = em.createQuery("FROM tasklist WHERE id=" + id);
		return namedQuery.getResultList();
	}
	
	public Task update(Task p) {
		return em.merge(p);
	}
	
	public void deleteByName(String p) {
		em.remove(p);
	}
}
