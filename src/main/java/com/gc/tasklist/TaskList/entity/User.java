package com.gc.tasklist.TaskList.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {


	@Column(name="userid")
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int id;
	@Id
	private String email;
	private String password;
	
	
	public int getId() {
		return id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public User(int id, String email, String password) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
	}
	public User() {

	}
	public User(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	
}
