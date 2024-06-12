package com.School_ERP.controller;


import com.School_ERP.dto.AttendenceDto;
import com.School_ERP.entity.Attendence;
import com.School_ERP.links.AttendenceLinks;
import com.School_ERP.repository.AttendenceRepository;
import com.School_ERP.service.AttendenceService;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(AttendenceLinks.ATTENDENCE)
@Tag(name = "Attendence", description = "API for Attendence sheet")
public class AttendenceController {

    @Autowired
    private AttendenceRepository  attendenceRepository;

    @Autowired
    private AttendenceService attendenceService;

    @Operation(summary = "marking only present student")
    @PostMapping(AttendenceLinks.MARK_PRESENT)
    public ResponseEntity<?> markPresent(@PathVariable String rollNo, @RequestBody LocalDate date) {
        return attendenceService.markPresentStudent(Long.parseLong(rollNo),date);
    }

    @Operation(summary = "marking abesent students")
    @PostMapping(AttendenceLinks.MARK_ABSENT)
    public ResponseEntity<?> markAbsent(@PathVariable String rollNo, @RequestBody LocalDate date){
        return attendenceService.markAbsentStudent(Long.parseLong(rollNo),date);
    }

    @Operation(summary = "adding the leaves")
    @PostMapping(AttendenceLinks.MARK_LEAVE)
    public ResponseEntity<?> markLeave(@PathVariable String rollNo, @RequestBody LocalDate date){
        return attendenceService.markleaves(Long.parseLong(rollNo), date);
    }


    @Operation(summary = "Get an attendence by rollNo")
    @GetMapping(AttendenceLinks.GET_ATTENDENCE_BY_ROLLNO)
    public ResponseEntity<?> getAttendanceByRollNo(@PathVariable String rollNo) {
        return attendenceService.getAttendenceOverViewByRollNo(Long.parseLong(rollNo));
    }

    @Operation(summary = "Get all attendence")
    @GetMapping(AttendenceLinks.GET_ALL_ATTENDENCE)
    public List<AttendenceDto> getAllAttendance() {
        return attendenceService.getAllAttendance();
    }

    @Operation(summary = "Add Student in attendence Sheet")
    @PostMapping(AttendenceLinks.ADD_STUDENT)
    public ResponseEntity<?> addStudent(@RequestBody AttendenceDto attendenceDto){
        return attendenceService.addStudentInSheet(attendenceDto);
    }

    @Operation(summary = "Check Attendence by Date")
    @PostMapping(AttendenceLinks.CHECK_ATTENDENCE_BY_DATE)
    public ResponseEntity<?> checkAttendenceByDate(@PathVariable String rollNo,@PathVariable LocalDate date){
        return attendenceService.checkAttendenceByDate(Long.parseLong(rollNo),date);
    }


}
