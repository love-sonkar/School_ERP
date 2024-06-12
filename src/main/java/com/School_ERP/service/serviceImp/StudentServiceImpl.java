package com.School_ERP.service.serviceImp;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.School_ERP.dto.StudentDto;
import com.School_ERP.entity.Student;
import com.School_ERP.repository.StudentRepo;
import com.School_ERP.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepo studentRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	// Get all the student
	public List<StudentDto> getAllStudent(){
		List<Student> allStudent = this.studentRepo.findAll();
		List<StudentDto> list = allStudent.stream().map(student ->{
			StudentDto dto = this.modelMapper.map(student, StudentDto.class);
			return dto;
		}).collect(Collectors.toList());
		return list;
	}
	
	// Get student by id
	public StudentDto getStudentById(int id) {
		Student student = this.studentRepo.findById(id);
		StudentDto studentDto = this.modelMapper.map(student, StudentDto.class);
		return studentDto;
	}
	
	// Add student
	public String addStudent(StudentDto std) {
		// Change dto class to entity class
		Student student = this.modelMapper.map(std, Student.class);
		// Save data
		this.studentRepo.save(student);
		return "1 Student added successfully!";
	}
	
	// Update student
	@Override
	public String updateDetails(StudentDto std, int id) {
		Optional<Student> studentOpt = Optional.ofNullable(this.studentRepo.findById(id));
		if (studentOpt.isPresent()) {
			Student previousDetails = studentOpt.get();
			Student currentDetails = this.modelMapper.map(std, Student.class);

			// Update student details
			previousDetails.setFname(currentDetails.getFname());
			previousDetails.setLname(currentDetails.getLname());
			previousDetails.setContact(currentDetails.getContact());
			previousDetails.setAddress(currentDetails.getAddress());
			previousDetails.setEmail(currentDetails.getEmail());
			previousDetails.setGender(currentDetails.getGender());
			previousDetails.setBlood_group(currentDetails.getBlood_group());
			previousDetails.setFather_name(currentDetails.getFather_name());
			previousDetails.setMother_name(currentDetails.getMother_name());
			previousDetails.setDob(currentDetails.getDob());
			previousDetails.setSection(currentDetails.getSection());
			previousDetails.setStandard(currentDetails.getStandard());
			previousDetails.setHostel_facility(currentDetails.getHostel_facility());

			// Set hostel ID
			if (currentDetails.getHostel() != null) {
				previousDetails.setHostel(currentDetails.getHostel());
			}

			 // Set medical details
	        if (currentDetails.getMedical() != null) {
	            previousDetails.setMedical(currentDetails.getMedical());
	        }

			this.studentRepo.save(previousDetails);

			return "Student data updated successfully!";
		} else {
			return "Student not found!";
		}
	}

	

	// Delete student data
	public String deleteStudent(int id) {
		this.studentRepo.deleteById(id);
		return "Student data deleted successfully!";
	}
}
