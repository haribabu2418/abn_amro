package com.arm.app.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Cases implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	private String casenumber;

	@CreationTimestamp
	LocalDateTime created_at;

	@ManyToMany(mappedBy = "cases")
	Set<Entities> entities = new HashSet<>();

	public Cases() {
		
	}

	public Cases(String case_number) {
		super();
		this.casenumber = case_number;
	}
	public Cases(String case_number, Set<Entities> entities) {
		super();
		this.casenumber = case_number;
		this.entities = entities;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCase_number() {
		return casenumber;
	}

	public void setCase_number(String case_number) {
		this.casenumber = case_number;
	}

	public LocalDateTime getCreated_at() {
		return created_at;
	}

	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}

	public Set<Entities> getEntities() {
		return entities;
	}

	public void setEntities(Set<Entities> entities) {
		this.entities = entities;
	}

	public String getCasenumber() {
		return casenumber;
	}

	public void setCasenumber(String casenumber) {
		this.casenumber = casenumber;
	}

	@Override
	public String toString() {
		return "Cases [id=" + id + ", casenumber=" + casenumber + ", created_at=" + created_at + ", entities="
				+ entities + "]";
	}
	
	
}