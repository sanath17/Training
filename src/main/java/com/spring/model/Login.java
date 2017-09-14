package com.spring.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Login")
public class Login {
	
//	CREATE TABLE `login` (
//			  `id` int(11) NOT NULL,
//			  `email` varchar(45) DEFAULT NULL,
//			  `username` varchar(45) NOT NULL,
//			  `password` varchar(45) NOT NULL,
//			  `first_name` varchar(45) DEFAULT NULL,
//			  `last_name` varchar(45) DEFAULT NULL,
//			  `created_date` date NOT NULL,
//			  `updated_date` date NOT NULL,
//			  PRIMARY KEY (`id`),
//			  UNIQUE KEY `username` (`username`),
//			  UNIQUE KEY `email` (`email`)
//			) ENGINE=InnoDB DEFAULT CHARSET=utf8;

	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String username;
	
	private String password;
	
	private String first_name;
	
	private String last_name;
	
	private Date created_date;
	
	private Date updated_date;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return username;
	}

	public void setUserName(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public Date getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}

	public Date getUpdated_date() {
		return updated_date;
	}

	public void setUpdated_date(Date updated_date) {
		this.updated_date = updated_date;
	}

	@Override
	public String toString() {
		return "Login [id=" + id + ", username=" + username + ", password=" + password + ", first_name=" + first_name
				+ ", last_name=" + last_name + ", created_date=" + created_date + ", updated_date=" + updated_date
				+ "]";
	}
	
	
	
}
