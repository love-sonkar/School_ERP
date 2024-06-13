package com.School_ERP.service;

import com.School_ERP.dto.TeacherDto;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

public interface TeacherService {
	// Get student details by id
			public TeacherDto getTeacherById(int id);
			
			// Add Teacher
			public String addTeacher(TeacherDto teacherDto);
			
			// Get all the Teacher
			public List<TeacherDto> getAllTeacher();
			
			// Update Teacher details
			public String updateDetails(TeacherDto teacherDto, int id);
			
//			// Delete Teacher data
			public String deleteTeacher(int id);
}
