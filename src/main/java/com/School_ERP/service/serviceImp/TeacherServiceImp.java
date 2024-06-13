package com.School_ERP.service.serviceImp;

import com.School_ERP.dto.TeacherDto;

import com.School_ERP.entity.Teacher;
import com.School_ERP.repository.TeacherRepository;
import com.School_ERP.service.TeacherService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

import java.util.stream.Collectors;

@Service
public class TeacherServiceImp implements TeacherService {

	@Autowired
	private TeacherRepository repository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	// Get all the Teacher
		public List<TeacherDto> getAllTeacher(){
			List<Teacher> allTeacher = this.repository.findAll();
			List<TeacherDto> list = allTeacher.stream().map(teacher ->{
				TeacherDto dto = this.modelMapper.map(teacher, TeacherDto.class);
				return dto;
			}).collect(Collectors.toList());
			return list;
		}
		// Get student by id
		public TeacherDto getTeacherById(int id) {
			Teacher teacher = this.repository.findById(id);
			TeacherDto teacherDto = this.modelMapper.map(teacher, TeacherDto.class);
			return teacherDto;
		}
		// Add Teacher
		public String addTeacher(TeacherDto teacherDto) {
			// Change dto class to entity class
			Teacher teacher = this.modelMapper.map(teacherDto, Teacher.class);
			// Save data
			this.repository.save(teacher);
			return "1 teacher added successfully!";
		}
		
		// Update Teacher
		public String updateDetails(TeacherDto teacherDto, int id) {
			Teacher previousDetails = this.repository.findById(id);
			Teacher currentDetails = this.modelMapper.map(teacherDto, Teacher.class);
			// Set new data to the old data
			previousDetails.setFname(currentDetails.getFname());
			previousDetails.setLname(currentDetails.getLname());
			previousDetails.setContact(currentDetails.getContact());
			previousDetails.setAddress(currentDetails.getAddress());
			previousDetails.setEmail(currentDetails.getEmail());
			previousDetails.setGender(currentDetails.getGender());
			previousDetails.setBloodGroup(currentDetails.getBloodGroup());
			previousDetails.setQualification(currentDetails.getQualification());
		    previousDetails.setContact(currentDetails.getContact());
			previousDetails.setEmail(currentDetails.getEmail());
			previousDetails.setAddress(currentDetails.getAddress());
			previousDetails.setJoinDate(currentDetails.getJoinDate());
			
			
	        if (currentDetails.getSubject() != null) {
	            previousDetails.setSubject(currentDetails.getSubject());
	        }
			
			// Save the updated data
			this.repository.save(previousDetails);
			
			return "Teacher data updated successfully!";
		}
		
		// Delete Teacher data
		public String deleteTeacher(int id) {
			this.repository.deleteById(id);
			return "teacher data deleted successfully!";
		}
}