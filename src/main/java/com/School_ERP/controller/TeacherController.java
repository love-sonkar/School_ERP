package com.School_ERP.controller;

import com.School_ERP.dto.TeacherDto;
import com.School_ERP.links.TeacherLinks;

import com.School_ERP.service.serviceImp.TeacherServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/api/teacher")
public class TeacherController {
	@Autowired
	private TeacherServiceImp  teacherService;
	
	// Get all the teacher
	@GetMapping(path = TeacherLinks.GET_ALL_Teacher)
	public ResponseEntity<List<TeacherDto>> getAllTeacher(){
		try {
			List<TeacherDto> list = this.teacherService.getAllTeacher();
			if(list.size() <= 0) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
			return ResponseEntity.of(Optional.of(list));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	// Get teacher data by id
	@GetMapping(path = TeacherLinks.GET_Teacher_BY_ID)
	public ResponseEntity<TeacherDto> getTeacherById(@PathVariable("Id") int id){
		try {
			TeacherDto teacherDto =  this.teacherService.getTeacherById(id);
			if(teacherDto == null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
			return ResponseEntity.of(Optional.of(teacherDto));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	// Add teacher
	@PostMapping(path = TeacherLinks.ADD_Teacher)
	public ResponseEntity<String> addTeacher(@RequestBody TeacherDto teacherDto){
		try {
			teacherDto.setJoinDate(LocalDate.now());
			String response = this.teacherService.addTeacher(teacherDto);
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	// Update teacher details
	@PutMapping(path = TeacherLinks.UPDATE_Teacher_DATA)
	public ResponseEntity<String> updateTeacher(@RequestBody TeacherDto teacherDto, @PathVariable("Id") int id){
		try {
			if(teacherDto == null) {
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			}
			String response = this.teacherService.updateDetails(teacherDto, id);
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	// Delete teacher data
	@DeleteMapping(path = TeacherLinks.DELETE_Teacher_DATA)
	public ResponseEntity<String> deleteTeacher(@PathVariable("Id") int id){
		try {
			String response = this.teacherService.deleteTeacher(id);
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
}