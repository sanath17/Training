package com.spring.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Batch")
public class Batch {
	
//	batch
//	CREATE TABLE `batch` (
//	  `id` int(11) NOT NULL,
//	  `batch_id` varchar(45) NOT NULL,
//	  `program` varchar(45) DEFAULT NULL,
//	  `trainer_name` varchar(45) DEFAULT NULL,
//	  `student_count` int(11) DEFAULT NULL,
//	  `course` varchar(45) DEFAULT NULL,
//	  `created_date` date NOT NULL,
//	  `updated_date` date NOT NULL,
//	  PRIMARY KEY (`id`),
//	  UNIQUE KEY `batch_id` (`batch_id`)
//	) ENGINE=InnoDB DEFAULT CHARSET=utf8;
	
	@Id
	@GenericGenerator(name = "customUUID", strategy = "uuid2")
	@GeneratedValue(generator = "customUUID")
	private String id;
	
//	@OneToMany
//	private Student student;
	
	private String batch_id;
	
	private String program;
	
	private String trainer_name;
	
	private int student_count;
	
	private String course;
	
	private Date created_date;
	
	private Date updated_date;
//
//	public Student getStudent() {
//		return student;
//	}
//
//	public void setStudent(Student student) {
//		this.student = student;
//	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProgram() {
		return program;
	}

	public void setProgram(String program) {
		this.program = program;
	}

	public String getTrainer_name() {
		return trainer_name;
	}

	public void setTrainer_name(String trainer_name) {
		this.trainer_name = trainer_name;
	}

	public int getStudent_count() {
		return student_count;
	}

	public void setStudent_count(int student_count) {
		this.student_count = student_count;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
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
		return "Batch [id=" + id + ", program=" + program + ", trainer_name=" + trainer_name + ", student_count="
				+ student_count + ", course=" + course + ", created_date=" + created_date + ", updated_date="
				+ updated_date + "]";
	}

	public String getBatch_id() {
		return batch_id;
	}

	public void setBatch_id(String batch_id) {
		this.batch_id = batch_id;
	}

	
	
	
}
