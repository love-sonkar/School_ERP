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

import java.util.List;
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
            try {
                dto = new ObjectMapper().readValue(attendance.toString(), AttendenceDto.class);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
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


}
