package com.arm.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arm.app.entity.Cases;

@Repository
public interface CasesRepository extends JpaRepository<Cases, Integer> {

	
	Cases findByCasenumber(String casenumber);
}
