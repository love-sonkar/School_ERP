package com.School_ERP.service.serviceImp;

import com.School_ERP.dto.AttendenceDto;
import com.School_ERP.entity.Attendence;
import com.School_ERP.repository.AttendenceRepository;
import com.School_ERP.service.AttendenceService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AttendenceImp implements AttendenceService {

    @Autowired
    AttendenceRepository attendenceRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<AttendenceDto> getAllAttendance() {
        List<Attendence> attendenceList = attendenceRepository.findAll();
        List<AttendenceDto> list = attendenceList.stream().map(attendance -> {
            AttendenceDto dto = null;
            dto = this.modelMapper.map(attendance, AttendenceDto.class);
            return dto;
        }).collect(Collectors.toList());
        return list;
    }

    @Override
    public ResponseEntity<?> getAttendenceOverViewByRollNo(long rollNo) {
        List<Attendence> existingStudent = attendenceRepository.findByRollNo(rollNo);
        if(existingStudent.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Student Not Found");
        }
        AttendenceDto dto = new AttendenceDto();
        int leaves = attendenceRepository.countBytotalLeaves(1);
        int absent = attendenceRepository.countByAbsent(1);
        dto.setRollNo(rollNo);
        dto.setAbsent(absent);
        dto.setTotalLeaves(leaves);
        int totalPresentdays = attendenceRepository.countByPresentDays(1) - leaves - absent;
        if(totalPresentdays <= 0){
            dto.setPresentDays(0);
        }else {
            dto.setPresentDays(totalPresentdays);
        }
        dto.setTotalDays(existingStudent.get(0).getTotalDays());
        return ResponseEntity.ok(dto);
    }

    @Override
    public ResponseEntity<?> addStudentInSheet(AttendenceDto attendenceDto) {
        Attendence attendence = new Attendence();
        if(attendenceDto != null){
            if(attendenceDto.getRollNo() != 0) {
                attendence.setRollNo(attendenceDto.getRollNo());
            }
            if(attendenceDto.getTotalDays() != 0){
                attendence.setTotalDays(attendenceDto.getTotalDays());
            }
            Attendence savedStudent = attendenceRepository.save(attendence);
            AttendenceDto convertDto = this.modelMapper.map(savedStudent, AttendenceDto.class);
            return ResponseEntity.ok(convertDto);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something went Wrong");
    }

    @Override
    public ResponseEntity<?> markPresentStudent(long rollNo, LocalDate date) {
        Attendence attendence =new Attendence();
        attendence.setRollNo(rollNo);
        attendence.setPresentDays(1);
        attendence.setDate(date);
        attendenceRepository.save(attendence);
        return ResponseEntity.ok("present student");
    }

    @Override
    public ResponseEntity<?> markAbsentStudent(long rollNo, LocalDate date) {
        Attendence attendence =new Attendence();
        attendence.setRollNo(rollNo);
        attendence.setAbsent(1);
        attendence.setDate(date);
        attendenceRepository.save(attendence);
        return ResponseEntity.ok("absent student");
    }

    @Override
    public ResponseEntity<?> markleaves(long rollNo, LocalDate date) {
        Attendence attendence =new Attendence();
        attendence.setRollNo(rollNo);
        attendence.setTotalLeaves(1);
        attendence.setDate(date);
        attendenceRepository.save(attendence);
        return ResponseEntity.ok("leave added");
    }

    @Override
    public ResponseEntity<?> checkAttendenceByDate(long rollNo, LocalDate date) {
        Attendence attendence = attendenceRepository.findByRollNoAndDate(rollNo, date);
        if(attendence == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Student Not found in attendence list");
        }
        Map<String,String> responseMap = new HashMap<>();
        if(attendence.getAbsent() == 1){
            responseMap.put("message", "Student is Absent");
        }
        if(attendence.getPresentDays() == 1){
            responseMap.put("message", "Student is Present");
        }
        if(attendence.getTotalLeaves() == 1){
            responseMap.put("message", "Student is in Leave");
        }
        return ResponseEntity.ok(responseMap);
    }


}
