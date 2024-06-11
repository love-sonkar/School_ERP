package com.School_ERP.controller;


import com.School_ERP.dto.AttendenceDto;
import com.School_ERP.entity.Attendence;
import com.School_ERP.repository.AttendenceRepository;
import com.School_ERP.service.AttendenceService;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

@RestController
@Tag(name = "Attendence", description = "API for Attendence sheet")
public class AttendenceController {

    @Autowired
    private AttendenceRepository  attendenceRepository;

    @Autowired
    private AttendenceService attendenceService;

    @Operation(summary = "marking only present student")
    @PostMapping("/present/{rollNo}")
    public ResponseEntity<?> markPresent(@PathVariable String rollNo, @RequestBody LocalDate date) {
        Attendence attendence =new Attendence();
        attendence.setRollNo(Long.parseLong(rollNo));
        attendence.setPresentDays(1);
        attendence.setDate(date);
       Attendence savedStudent = attendenceRepository.save(attendence);
       return ResponseEntity.ok("present student");
    }

    @Operation(summary = "marking abesent students")
    @PostMapping("/absent/{rollNo}")
    public ResponseEntity<?> markAbsent(@PathVariable String rollNo, @RequestBody LocalDate date){
        Attendence attendence =new Attendence();
        attendence.setRollNo(Long.parseLong(rollNo));
        attendence.setAbsent(1);
        attendence.setDate(date);
        Attendence savedStudent = attendenceRepository.save(attendence);
        return ResponseEntity.ok("absent student");
    }

    @Operation(summary = "adding the leaves")
    @PostMapping("/leaves/{rollNo}")
    public ResponseEntity<?> markLeave(@PathVariable String rollNo, @RequestBody LocalDate date){
        Attendence attendence =new Attendence();
        attendence.setRollNo(Long.parseLong(rollNo));
        attendence.setTotalLeaves(1);
        attendence.setDate(date);
        Attendence savedStudent = attendenceRepository.save(attendence);
        return ResponseEntity.ok("leave added");
    }


    @Operation(summary = "Get an attendence by rollNo")
    @GetMapping("/{rollNo}")
    public ResponseEntity<?> getAttendanceByRollNo(@PathVariable String rollNo) {
        return attendenceService.getAttendenceOverViewByRollNo(Long.parseLong(rollNo));
    }

    @Operation(summary = "Get all attendence")
    @GetMapping("/all")
    public List<Attendence> getAllAttendance() {
        return attendenceRepository.findAll();
    }

    @Operation(summary = "Add Student in attendence Sheet")
    @PostMapping("/add")
    public ResponseEntity<?> addStudent(@RequestBody AttendenceDto attendenceDto){
        return attendenceService.addStudentInSheet(attendenceDto);
    }
}
