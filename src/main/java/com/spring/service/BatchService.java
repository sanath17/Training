package com.spring.service;

import java.util.List;

import com.spring.model.Batch;

public interface BatchService {
	

	public List<Batch> findall();
	
	public Batch create(Batch student);
	
	public void delete(String batch_id);
	
	public Batch update(String batch_id);
	

}
