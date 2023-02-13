package com.arm.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arm.app.entity.Cases;
import com.arm.app.entity.Entities;
import com.arm.app.repository.EntitiesRepository;
import com.arm.exception.ResourceNotFoundException;

@Service
public class EntitiesServiceImpl implements EntityService{

	@Autowired
	EntitiesRepository entityRepository;
	
	

	@Override
	public void saveEntitis(Entities entity) {
		 entityRepository.save(entity);
	}

	@Override
	public int getCountByCaseNumber(Cases cases) {
		int count=entityRepository.countByCases(cases);
		return count;
	}

	@Override
	public Entities findById(int id) throws ResourceNotFoundException {
		
		return entityRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("no entities found with id:"+id));
	}

	

}
