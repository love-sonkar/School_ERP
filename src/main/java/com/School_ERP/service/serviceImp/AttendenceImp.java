package com.School_ERP.service.serviceImp;

import com.School_ERP.dto.AttendenceDto;
import com.School_ERP.dto.LibraryDto;
import com.School_ERP.entity.Attendence;
import com.School_ERP.repository.AttendenceRepository;
import com.School_ERP.service.AttendenceService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.coyote.Response;
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
    public ResponseEntity<?> getOverView(long rollNo) {
        Attendence existingStudent = attendenceRepository.findByRollNo(rollNo);
        if(existingStudent == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Student Not Found");
        }
        AttendenceDto dto = new AttendenceDto();
        dto.setRollNo(rollNo);
        dto.setAbsent(attendenceRepository.countByAbsent(1));
        dto.setPresentDays(attendenceRepository.countByPresentDays(1));
        dto.setTotalLeaves(attendenceRepository.countBytotalLeaves(1));
        dto.setTotalDays(existingStudent.getTotalDays());
        return ResponseEntity.ok(dto);
    }


}
