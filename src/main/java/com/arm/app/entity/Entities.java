package com.arm.app.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Entities implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	String name;

	String address;

	String email;

	String company_name;

	boolean is_company;

	@CreationTimestamp
	LocalDateTime created_at;

	@ManyToMany
	@JoinTable(name = "ENTITIES_TO_CASES", joinColumns = @JoinColumn(name = "Entities_id"),
	inverseJoinColumns = @JoinColumn(name = "cases_id"))
	Set<Cases> cases = new HashSet<>();

	public Entities() {
		
	}

	public Entities(String name, String address, String email, String company_name, boolean is_company,
			Set<Cases> cases) {
		super();
		this.name = name;
		this.address = address;
		this.email = email;
		this.company_name = company_name;
		this.is_company = is_company;
		this.cases = cases;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public boolean isIs_company() {
		return is_company;
	}

	public void setIs_company(boolean is_company) {
		this.is_company = is_company;
	}

	public LocalDateTime getCreated_at() {
		return created_at;
	}

	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}

	public Set<Cases> getCases() {
		return cases;
	}

	public void setCases(Set<Cases> cases) {
		this.cases = cases;
	}

	@Override
	public String toString() {
		return "Entities [id=" + id + ", name=" + name + ", address=" + address + ", email=" + email + ", company_name="
				+ company_name + ", is_company=" + is_company + ", created_at=" + created_at + ", cases=" + cases + "]";
	}
	
	

	
}
