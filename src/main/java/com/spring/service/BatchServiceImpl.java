package com.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.dao.BatchDAOImpl;
import com.spring.model.Batch;


@Service
public class BatchServiceImpl implements BatchService{
	
private BatchDAOImpl BatchDAO;

public BatchDAOImpl getBatchDAO() {
	return BatchDAO;
}

public void setBatchDAO(BatchDAOImpl batchDAO) {
	BatchDAO = batchDAO;
}
	
	
	@Override
	public List<Batch> findall() {
		// TODO Auto-generated method stub
		return BatchDAO.findall();
	}

	@Override
	public Batch create(Batch student) {
		// TODO Auto-generated method stub
		return BatchDAO.create(student);
	}

	@Override
	public void delete(String id) {
		Batch existing = BatchDAO.findById(id);
		if(existing==null){
			System.out.println("no batch found to delete");
			//exception
		}
		BatchDAO.delete(existing);
	}
	
	@Override
	public Batch update(String id) {
		Batch existing = BatchDAO.findById(id);
		if(existing==null){
			System.out.println("not found");
			//exception
		}
		return existing;
	}

}
