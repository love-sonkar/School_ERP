package com.School_ERP.service;

import java.util.List;

import com.School_ERP.dto.StudentDto;

public interface StudentService {
	// Get student details by id
	public StudentDto getStudentById(int id);
	
	// Add students
	public String addStudent(StudentDto std);
	
	// Get all the student
	public List<StudentDto> getAllStudent();
	
	// Update student details
	public String updateDetails(StudentDto std, int id);
	
//	// Delete student data
	public String deleteStudent(int id);
}
