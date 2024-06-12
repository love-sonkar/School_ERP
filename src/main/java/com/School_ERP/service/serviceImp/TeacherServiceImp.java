package com.School_ERP.service.serviceImp;

import com.School_ERP.dto.TeacherDto;
import com.School_ERP.entity.Teacher;
import com.School_ERP.repository.TeacherRepository;
import com.School_ERP.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TeacherServiceImp implements TeacherService {

    @Autowired
    private TeacherRepository repository;

    @Override
    public ResponseEntity<?> saveTeacher(TeacherDto teacherDto) {
    	
    	if(teacherDto.getFname()==null||teacherDto.getFname().isEmpty()) {
    		
    		
    		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("First Name not added");
    	}
    	
    	
        Teacher teacher = convertToEntity(teacherDto);
        repository.save(teacher);
        
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Teacher Added Successfully");
    }

    @Override
    public List<TeacherDto> findAll() {
        return repository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<TeacherDto> findById(int id) {
        Optional<Teacher> teacher = repository.findById(id);
        return teacher.map(this::convertToDto);
    } 
    
      public ResponseEntity<?>addTacherService(TeacherDto teacherDto){
    	  if(teacherDto.getFname()==null||teacherDto.getFname().isEmpty()) {
    		  
    		  return ResponseEntity.status(HttpStatus.NOT_FOUND).body("First Name not Found");
    	  }
    	  
    	  if(teacherDto.getLname()==null ||teacherDto.getLname().isEmpty()) {
    		  
    		  return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Last Name not Found");
    	  }
    	  
    	  
    	  
    	  
    	  
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Teacher not added");
    	  
      }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }

    @Override
    public void updateById(int id, TeacherDto teacherDto) {
        Optional<Teacher> optionalTeacher = repository.findById(id);
        if (optionalTeacher.isPresent()) {
            Teacher teacher = convertToEntity(teacherDto);
            teacher.setEmpId(id);  // Ensure the ID is correctly set for the update
            repository.save(teacher);
        }
    }

    private TeacherDto convertToDto(Teacher teacher) {
        TeacherDto teacherDto = new TeacherDto();
        teacherDto.setEmpId(teacher.getEmpId());
        teacherDto.setFname(teacher.getFname());
        teacherDto.setLname(teacher.getLname());
        teacherDto.setAge(teacher.getAge());
        teacherDto.setGender(teacher.getGender());
        teacherDto.setQualification(teacher.getQualification());
        teacherDto.setBloodGroup(teacher.getBloodGroup());
        teacherDto.setContact(teacher.getContact());
        teacherDto.setEmail(teacher.getEmail());
        teacherDto.setAddress(teacher.getAddress());
        teacherDto.setJoinDate(teacher.getJoinDate());
        return teacherDto;
    }

    private Teacher convertToEntity(TeacherDto teacherDto) {
        Teacher teacher = new Teacher();
        teacher.setEmpId(teacherDto.getEmpId());
        teacher.setFname(teacherDto.getFname());
        teacher.setLname(teacherDto.getLname());
        teacher.setAge(teacherDto.getAge());
        teacher.setGender(teacherDto.getGender());
        teacher.setQualification(teacherDto.getQualification());
        teacher.setBloodGroup(teacherDto.getBloodGroup());
        teacher.setContact(teacherDto.getContact());
        teacher.setEmail(teacherDto.getEmail());
        teacher.setAddress(teacherDto.getAddress());
        teacher.setJoinDate(teacherDto.getJoinDate());
        return teacher;
    }
}
