package com.arm.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arm.app.entity.Cases;
import com.arm.app.repository.CasesRepository;
import com.arm.exception.ResourceNotFoundException;

@Service
public class CasesServiceImpl implements CasesService {

	@Autowired
	CasesRepository casesRepository;

	@Override
	public void saveCases(Cases cases) {
		casesRepository.save(cases);
	}

	@Override
	public Cases findByCaseNumber(String caseNumber) {
		Cases cases = casesRepository.findByCasenumber(caseNumber);
		return cases;
	}

	@Override
	public Cases findbyId(int id) throws ResourceNotFoundException {
		
		return casesRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("no cases found with id:"+id));
	}

}
