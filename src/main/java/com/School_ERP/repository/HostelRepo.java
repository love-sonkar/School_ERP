package com.School_ERP.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.School_ERP.entity.Hostel;

public interface HostelRepo extends CrudRepository<Hostel, Integer> {
	
	public Hostel findById(int id);
	
	public List<Hostel> findAll();
}
