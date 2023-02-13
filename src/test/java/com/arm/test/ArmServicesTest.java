package com.arm.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.arm.app.ArmApplication;
import com.arm.app.entity.Entities;
import com.arm.app.repository.EntitiesRepository;
import com.arm.app.services.EntitiesServiceImpl;

@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes = ArmApplication.class)
public class ArmServicesTest {

	/*
	 * @InjectMocks EntityService entityServie;
	 */

	@InjectMocks
	EntitiesServiceImpl entityService;
	@Mock
	EntitiesRepository repository;

	@Test
	public void testEntityService() {

		Entities entity = new Entities();
		entity.setName("Hari");
		entity.setAddress("mylocation");
		entity.setCompany_name("arm");
		entity.setEmail("hari@myorgmail.com");

		entityService.saveEntitis(entity);

		assertNotNull(repository.findById(1));

	}

}
