package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.BatchDAOImpl;
import com.spring.model.Batch;


@Service("batchService")
public class BatchServiceImpl implements BatchService{
	
	@Autowired
	private BatchDAOImpl repository;

	@Override
	public List<Batch> findall() {
		// TODO Auto-generated method stub
		return repository.findall();
	}

	@Override
	public Batch create(Batch student) {
		// TODO Auto-generated method stub
		return repository.create(student);
	}

	@Override
	public void delete(String id) {
		Batch existing = repository.findById(id);
		if(existing==null){
			System.out.println("no batch found to delete");
			//exception
		}
		repository.delete(existing);
	}

	@Override
	public Batch update(String id) {
		Batch existing = repository.findById(id);
		if(existing==null){
			System.out.println("not found");
			//exception
		}
		return existing;
	}

}
