package com.gc.tasklist.TaskList.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "find_all_tasks", query= "select i from Task i")
public class Task {

	private long userId;
	private String description;
	private Date date;
	private boolean status;
	
	
	public long getUserId() {
		return userId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
	public Task(long userId, String description, Date date, boolean status) {
		super();
		this.userId = userId;
		this.description = description;
		this.date = date;
		this.status = status;
	}
	public Task() {

	}
	
	
}
