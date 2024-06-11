package com.School_ERP.service;

import com.School_ERP.dto.AttendenceDto;
import com.School_ERP.entity.Attendence;
import org.springframework.http.ResponseEntity;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@Service
public interface AttendenceService {

    List<AttendenceDto> getAllAttendance();

    List<AttendenceDto> getAttendanceByRollNo();

    ResponseEntity<?> getOverView(long rollNo);
}
