package com.School_ERP.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.School_ERP.entity.Student;
import com.School_ERP.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
	
public Teacher findById(int id);
	
	public List<Teacher> findAll();
}
