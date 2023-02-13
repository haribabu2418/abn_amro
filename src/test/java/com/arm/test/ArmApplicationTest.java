package com.arm.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.arm.app.ArmApplication;
import com.arm.app.controller.ArmController;
import com.arm.app.entity.Entities;
import com.arm.app.repository.CasesRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes = ArmApplication.class)
public class ArmApplicationTest {

	@Autowired
	ArmController controller;

	@Autowired
	MockMvc mockMvc;

	@Autowired
	CasesRepository caseRepo;

	protected String mapToJson(Object obj) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(obj);
	}

	@Test
	public void createProduct() throws Exception {
		String uri = "/cases/entities";
		Entities entities = new Entities();
		entities.setName("vinod");
		entities.setCompany_name("infy");
		entities.setEmail("hari@infy");
		entities.setIs_company(true);
		entities.setAddress("UK");

		String inputJson = mapToJson(entities);
		MvcResult mvcResult = mockMvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "Entities Created Successfully");
	}

	@Test
	public void modifyEntities() throws Exception {

		String uri = "/entities/1/2";
		MvcResult mvcResult = mockMvc
				.perform(MockMvcRequestBuilders.put(uri).contentType(MediaType.APPLICATION_JSON_VALUE)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(201, status);

	}

	@Test
	public void GetCountOfEntitiesByCase() throws Exception {

		String uri = "/AAA-BBB-VVV/entites";
		MvcResult mvcResult = mockMvc
				.perform(MockMvcRequestBuilders.get(uri).contentType(MediaType.APPLICATION_JSON_VALUE)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);

	}

}
