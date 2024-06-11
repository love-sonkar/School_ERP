package com.School_ERP.service;

import com.School_ERP.dto.AttendenceDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AttendenceService {

    List<AttendenceDto> getAllAttendance();

    ResponseEntity<?> getOverView(long rollNo);
}
