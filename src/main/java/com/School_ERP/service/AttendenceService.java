package com.School_ERP.service;

import com.School_ERP.dto.AttendenceDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AttendenceService {

    List<AttendenceDto> getAllAttendance();

    ResponseEntity<?> getAttendenceOverViewByRollNo(long rollNo);

    ResponseEntity<?> addStudentInSheet(AttendenceDto attendenceDto);
}
