package com.spring.dao;

import java.util.List;

import com.spring.model.Batch;

public interface BatchDAO {
	

	public List<Batch> findall();
	
	public Batch findById(String id);
	
	public Batch create(Batch student);
	
	public void delete(Batch batch);
	
	public Batch update(Batch batch);
	

}
