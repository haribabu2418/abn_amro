package com.arm.app.services;

import com.arm.app.entity.Cases;
import com.arm.app.entity.Entities;
import com.arm.exception.ResourceNotFoundException;

public interface EntityService {

	void saveEntitis(Entities entity);
	
	Entities findById(int id) throws ResourceNotFoundException;

	int getCountByCaseNumber(Cases cases);
}
