package com.example.demo.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity(name="users")
public class User implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String username;
	private String password;
	private String email;
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	private String role;
	
	public User(){}
	
	public User(String name, String password, String email, Date date, String role) {
		super();
		this.username = name;
		this.password = password;
		this.email = email;
		this.date = date;
		this.role = role;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [username= "+ username+ ", email= "+email+", date= "+date+", role=" +role+"]";
	}
	
	

}
