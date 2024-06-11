package com.School_ERP.controller;


import com.School_ERP.dto.AttendenceDto;
import com.School_ERP.entity.Attendence;
import com.School_ERP.repository.AttendenceRepository;
import com.School_ERP.service.AttendenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AttendenceController {

    @Autowired
    private AttendenceRepository  attendenceRepository;

    @Autowired
    private AttendenceService attendenceService;

    @PostMapping("/mark")
    public String markAttendance(@RequestBody Attendence attendence) {
        attendenceRepository.save(attendence);
        return "Attendance marked for student with roll number " + attendence.getRollNo();
    }

    @GetMapping("/{rollNo}")
    public Attendence getAttendanceByRollNo(@PathVariable String rollNo) {
        return attendenceRepository.findByRollNo(Long.parseLong(rollNo));
    }
    @GetMapping("/all")
    public List<Attendence> getAllAttendance() {
        return attendenceRepository.findAll();
    }
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

    @PostMapping("/overview")
    public ResponseEntity<?> getStudentOverview(@PathVariable String rollNo){
        return attendenceService.getOverView(Long.parseLong(rollNo));
    }

}
