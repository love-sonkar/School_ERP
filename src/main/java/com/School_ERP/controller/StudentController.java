package com.School_ERP.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.School_ERP.service.serviceImp.StudentServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.School_ERP.dto.StudentDto;
import com.School_ERP.links.StudentLinks;

@RestController
@RequestMapping(path = StudentLinks.STUDENT_PATH)
@Tag(name = "student" , description = "Student API's")
public class StudentController {
	
	@Autowired
	private StudentServiceImpl studentService;
	
	// Get all the student
	@GetMapping(path = StudentLinks.GET_ALL_STUDENT)
	@Operation(summary = "Get  all students")
	public ResponseEntity<List<StudentDto>> getAllStudent(){
		try {
			List<StudentDto> list = this.studentService.getAllStudent();
			if(list.size() <= 0) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
			return ResponseEntity.of(Optional.of(list));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	// Get student data by id
	@GetMapping(path = StudentLinks.GET_STUDENT_BY_ID)
	@Operation(summary = "Get student by id")
	public ResponseEntity<StudentDto> getStudentById(@PathVariable("studentId") int id){
		try {
			StudentDto student =  this.studentService.getStudentById(id);
			if(student == null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
			return ResponseEntity.of(Optional.of(student));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	// Add student
	@PostMapping(path = StudentLinks.ADD_STUDENT)
	@Operation(summary = "Add new student")
	public ResponseEntity<String> addStudent(@RequestBody StudentDto std){
		try {
			std.setAdm_date(LocalDate.now());
			String response = this.studentService.addStudent(std);
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	// Update student details
	@PutMapping(path = StudentLinks.UPDATE_STUDENT_DATA)
	@Operation(summary = "Update student details")
	public ResponseEntity<String> updateStudent(@RequestBody StudentDto std, @PathVariable("studentId") int id){
		try {
			if(std == null) {
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			}
			String response = this.studentService.updateDetails(std, id);
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	// Delete student data
	@DeleteMapping(path = StudentLinks.DELETE_STUDENT_DATA)
	@Operation(summary = "remove student ")
	public ResponseEntity<String> deleteStudent(@PathVariable("studentId") int id){
		try {
			String response = this.studentService.deleteStudent(id);
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
}
