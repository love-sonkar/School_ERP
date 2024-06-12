package com.School_ERP.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.School_ERP.entity.Student;

public interface StudentRepo extends CrudRepository<Student, Integer> {
	// Override and change return type Optional<> to Student
	public Student findById(int id);
	
	public List<Student> findAll();

	Student findByAdmNo(int admNo);
	
}
