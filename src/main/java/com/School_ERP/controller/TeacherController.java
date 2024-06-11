package com.School_ERP.controller;

import com.School_ERP.dto.TeacherDto;
import com.School_ERP.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/api/teacher")
public class TeacherController {

    @Autowired
    private TeacherService service;

    @PostMapping( value = "/save/teacher")
    public void saveTeacher(@RequestBody TeacherDto teacherDto) {
        service.saveTeacher(teacherDto);
    }

    @GetMapping( value = "/all/teacher")
    public List<TeacherDto> findAll() {
        return service.findAll();
    }

    
    @GetMapping( value = "/find/teacher/{id}")
    public Optional<TeacherDto> findById(@PathVariable int id) {
        return service.findById(id);
    }

    @DeleteMapping(value = "/delete/teacher/{id}")
    public void deleteById(@PathVariable int id) {
        service.deleteById(id);
    }

    @PutMapping( value = "/update/teacher/{id}")
    public void updateById(@PathVariable int id, @RequestBody TeacherDto teacherDto) {
        service.updateById(id, teacherDto);
    }
}
