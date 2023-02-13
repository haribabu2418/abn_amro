package com.arm.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.arm.app.ArmApplication;
import com.arm.app.entity.Cases;
import com.arm.app.entity.Entities;
import com.arm.app.repository.CasesRepository;
import com.arm.app.repository.EntitiesRepository;

@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes = ArmApplication.class)
public class ArmRepositoryTest {

	@Autowired
	EntitiesRepository entitRepository;

	@Autowired
	CasesRepository caseRepo;

	@Test
	public void testcreateEntities() {

		Set<Cases> cases = new HashSet<>();

		Entities entity = new Entities();
		entity.setName("Hari");
		entity.setAddress("mylocation");
		entity.setCompany_name("arm");
		entity.setEmail("hari@myorgmail.com");

		caseRepo.save(new Cases("case1"));
		cases.add(caseRepo.findByCasenumber("case1"));
		entity.setCases(cases);
		entitRepository.save(entity);

		assertNotNull(entitRepository.findById(1).get());
	}
	
	@Test
	public void findByCaseNumber() {
		
		Set<Cases> cases = new HashSet<>();
		cases.add(new Cases("case1"));
		cases.add(new Cases("case2"));
		cases.add(new Cases("case3"));
		cases.add(new Cases("case4"));
		cases.add(new Cases("case5"));
		cases.add(new Cases("case6"));
		
		caseRepo.saveAll(cases);
		
		Cases caseObj=caseRepo.findByCasenumber("case2");
		
		assertNotNull(caseObj);
		
	}
}
