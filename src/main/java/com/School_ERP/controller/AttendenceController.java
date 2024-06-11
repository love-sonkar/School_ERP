package com.School_ERP.controller;


import com.School_ERP.entity.Attendence;
import com.School_ERP.repository.AttendenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AttendenceController {

    @Autowired
    private AttendenceRepository  attendenceRepository;

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
}
