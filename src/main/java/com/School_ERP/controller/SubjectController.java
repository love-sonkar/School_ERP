package com.School_ERP.controller;

import com.School_ERP.dto.SubjectDto;
import com.School_ERP.links.SubjectLinks;
import com.School_ERP.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @GetMapping(path = SubjectLinks.GET_ALL)
    public List<SubjectDto> getAllSubjects() {
        return subjectService.getAllSubjects();
    }

    @PostMapping(path = SubjectLinks.ADD_SUBJECT)
    public SubjectDto addSubject(@RequestBody SubjectDto subjectDto) {
        return subjectService.addSubject(subjectDto);
    }

    @PutMapping(path = SubjectLinks.UPDATE_SUBJECT)
    public SubjectDto updateSubject(@PathVariable Long id, @RequestBody SubjectDto subjectDto) {
        return subjectService.updateSubject(id, subjectDto);
    }

    @DeleteMapping(path = SubjectLinks.DELETE_SUBJECT)
    public String deleteSubject(@PathVariable Long id) {
        return subjectService.deleteSubject(id);
    }

    @GetMapping(path = SubjectLinks.GET_SUBJECT)
    public SubjectDto getSubjectById(@PathVariable Long id) {
        return subjectService.getSubjectById(id);
    }
}
