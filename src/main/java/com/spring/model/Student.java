package com.spring.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Student")
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
	@GenericGenerator(name = "customUUID", strategy = "uuid2")
	@GeneratedValue(generator = "customUUID")
	private String id;
	
	private String batch_id;
	
	private String name;
	
	@Column(unique = true)
	private String email;
	
	@Column(name="contact")
	private String contact;
	
	private String visa_status;
	
	private int cost;
	
	private Date created_date;
	
	private Date updated_date;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBatch_id() {
		return batch_id;
	}

	public void setBatch_id(String batch_id) {
		this.batch_id = batch_id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
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

	@Override
	public String toString() {
		return "Student [id=" + id + ", batch_id=" + batch_id + ", name=" + name + ", email=" + email + ", contact="
				+ contact + ", visa_status=" + visa_status + ", cost=" + cost + ", created_date=" + created_date
				+ ", updated_date=" + updated_date + "]";
	}
	
}

