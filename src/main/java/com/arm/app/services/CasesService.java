package com.arm.app.services;

import com.arm.app.entity.Cases;
import com.arm.exception.ResourceNotFoundException;

public interface CasesService {

	void saveCases(Cases cases);
	
	Cases findbyId(int id) throws ResourceNotFoundException;
	
	Cases findByCaseNumber(String caseNumber);
}
