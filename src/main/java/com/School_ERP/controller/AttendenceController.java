package com.School_ERP.controller;


import com.School_ERP.dto.AttendenceDto;
import com.School_ERP.entity.Attendence;
import com.School_ERP.repository.AttendenceRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@Tag(name = "Attendence", description = "API for Attendence sheet")
public class AttendenceController {

    @Autowired
    private AttendenceRepository  attendenceRepository;


    @Operation(summary = "marking only present student")
    @PostMapping("/present/{rollNo}")
    public ResponseEntity<?> markPresent(@PathVariable String rollNo) {
        Attendence attendence =new Attendence();
        attendence.setRollNo(Long.parseLong(rollNo));
        attendence.setPresentDays(1);
        long time = new Timestamp(System.currentTimeMillis()).getTime();
        attendence.setDate(time);
       Attendence savedStudent = attendenceRepository.save(attendence);
       return ResponseEntity.ok("present student");
    }

    @Operation(summary = "marking abesent students")
    @PostMapping("/absent/{rollNo}")
    public ResponseEntity<?> markAbsent(@PathVariable String rollNo){
        Attendence attendence =new Attendence();
        attendence.setRollNo(Long.parseLong(rollNo));
        attendence.setAbsent(1);
        Long time = new Timestamp(System.currentTimeMillis()).getTime();
        attendence.setDate(time);
        Attendence savedStudent = attendenceRepository.save(attendence);
        return ResponseEntity.ok("absent student");
    }

    @Operation(summary = "adding the leaves")
    @PostMapping("/leaves/{rollNo}")
    public ResponseEntity<?> markLeave(@PathVariable String rollNo){
        Attendence attendence =new Attendence();
        attendence.setRollNo(Long.parseLong(rollNo));
        attendence.setTotalLeaves(1);
        long time = new Timestamp(System.currentTimeMillis()).getTime();
        attendence.setDate(time);
        Attendence savedStudent = attendenceRepository.save(attendence);
        return ResponseEntity.ok("leave added");
    }


    @Operation(summary = "Get an attendence by rollNo")
    @GetMapping("/{rollNo}")
    public Attendence getAttendanceByRollNo(@PathVariable String rollNo) {
        return attendenceRepository.findByRollNo(Long.parseLong(rollNo));
    }

    @Operation(summary = "Get all attendence")
    @GetMapping("/all")
    public List<Attendence> getAllAttendance() {
        return attendenceRepository.findAll();
    }

    @Operation(summary = "update an attendence")
    @PutMapping("/{rollNo}")
    public Attendence updateAttendance(@PathVariable String rollNo, @RequestBody Attendence attendance) {
        Attendence existingAttendance = attendenceRepository.findByRollNo(Long.parseLong(rollNo));
        if (existingAttendance != null) {
            existingAttendance.setTotalDays(attendance.getTotalDays());
            existingAttendance.setTotalLeaves(attendance.getTotalLeaves());
            existingAttendance.setPresentDays(attendance.getPresentDays());
            existingAttendance.setAbsent(attendance.getAbsent());
            return attendenceRepository.save(existingAttendance);
        } else {
            return null;
        }
    }

}
