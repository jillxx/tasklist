package com.gc.tasklist.TaskList.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "find_all_tasks", query= "select i from Task i")
@Table(name = "task")
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int idtask;
	private String email;
	private String description;
	private Date duedate;
	
	private boolean status;


	public Task( String email, String description, Date duedate, boolean status) {
		super();
		
		this.email = email;
		this.description = description;
		this.duedate = duedate;
		this.status = status;

	}




	public int getIdtask() {
		return idtask;
	}




	public void setIdtask(int idtask) {
		this.idtask = idtask;
	}








	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getDescription() {
		return description;
	}




	public void setDescription(String description) {
		this.description = description;
	}




	public Date getDuedate() {
		return duedate;
	}




	public void setDuedate(Date duedate) {
		this.duedate = duedate;
	}




	public boolean isStatus() {
		return status;
	}




	public void setStatus(boolean status) {
		this.status = status;
	}








	public Task() {

	}




	@Override
	public String toString() {
		return "Task [idtask=" + idtask + ", email=" + email + ", description=" + description + ", duedate=" + duedate
				+ ", status=" + status + "]";
	}




	
	
}
