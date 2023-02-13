package com.arm.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arm.app.entity.Cases;
import com.arm.app.entity.Entities;
import com.arm.app.services.CasesService;
import com.arm.app.services.EntityService;
import com.arm.exception.ResourceNotFoundException;

@RestController
@RequestMapping("/cases")
public class ArmController {

	@Autowired
	EntityService entityService;

	@Autowired
	CasesService caseService;

	@PostMapping("/entities")
	public ResponseEntity<String> createEntities(@RequestBody Entities entities) {

		
			entityService.saveEntitis(entities);
			return new ResponseEntity<>("Entities Created Successfully",HttpStatus.CREATED);
		
	}
	
	@PostMapping("/cases")
	public ResponseEntity<String> createEntities(@RequestBody Cases cases) {

		
			caseService.saveCases(cases);
			return new ResponseEntity<>(HttpStatus.CREATED);
		
	}

	@PutMapping("/entities/{entityid}/{caseid}")
	public ResponseEntity<Void> modifyRelation(@PathVariable int entityid, @PathVariable int caseid) throws ResourceNotFoundException {

		
			Entities entity = entityService.findById(entityid);
			Cases cases = caseService.findbyId(caseid);

			if (entity == null || cases == null) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			entity.getCases().add(cases);
			cases.getEntities().add(entity);
			entityService.saveEntitis(entity);
			caseService.saveCases(cases);
			return new ResponseEntity<>(HttpStatus.OK);
		
	}

	@GetMapping("/{casenumber}/entites")
	public ResponseEntity<String> getCount(@PathVariable String casenumber) {

		
			Cases findByCasenumber = caseService.findByCaseNumber(casenumber);
			int countByCase = entityService.getCountByCaseNumber(findByCasenumber);
			
			return new ResponseEntity<>(countByCase+"",HttpStatus.OK);
		
	}

}