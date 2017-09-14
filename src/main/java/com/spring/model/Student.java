package com.spring.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Student {
//	CREATE TABLE `student` (
//			  `id` int(11) NOT NULL,
//			  `batch_id` int(11) NOT NULL,
//			  `email` varchar(45) DEFAULT NULL,
//			  `contact` int(11) DEFAULT NULL,
//			  `visa_status` varchar(45) DEFAULT NULL,
//			  `cost` int(11) DEFAULT NULL,
//			  `created_date` date NOT NULL,
//			  `updated_date` date NOT NULL,
//			  PRIMARY KEY (`id`),
//			  KEY `batch_id` (`batch_id`),
//			  CONSTRAINT `student_ibfk_1` FOREIGN KEY (`batch_id`) REFERENCES `batch` (`id`)
//			) ENGINE=InnoDB DEFAULT CHARSET=utf8;
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private int batch_id;
	
	@Column(unique = true)
	private String email;
	
	private int contact;
	
	private String visa_status;
	
	private int cost;
	
	private Date created_date;
	
	private Date updated_date;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBatch_id() {
		return batch_id;
	}

	public void setBatch_id(int batch_id) {
		this.batch_id = batch_id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getContact() {
		return contact;
	}

	public void setContact(int contact) {
		this.contact = contact;
	}

	public String getVisa_status() {
		return visa_status;
	}

	public void setVisa_status(String visa_status) {
		this.visa_status = visa_status;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
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
	
	
}

