package com.School_ERP.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.School_ERP.dto.ExamTimetableDto;
import com.School_ERP.links.ExamTimetableLinks;
import com.School_ERP.service.ExamTimetableService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(ExamTimetableLinks.EXAM_TIMETABLE)
@Tag(name = "ExamTimetable", description = "API for Exam Timetable Management")
public class ExamTimetableController {

	@Autowired
	private ExamTimetableService examTimetableService;
	
	@GetMapping
	@Operation(summary = "Get all examtimetable records")
	public List<ExamTimetableDto> getAllExamTimetables() {
        return examTimetableService.getAllExamTimetables();
    }

	@GetMapping(ExamTimetableLinks.GET_EXAM_TIMETABLE)
	@Operation(summary = "Get examtimetable records by ID")
	public ResponseEntity<ExamTimetableDto> getExamTimetableById(@PathVariable Long id) {
        return ResponseEntity.ok(examTimetableService.getExamTimetableById(id));
    }

	@PostMapping(ExamTimetableLinks.ADD_EXAM_TIMETABLE)
	@Operation(summary = "Add examtimetable records")
	public ResponseEntity<String> addExamTimetable(@RequestBody ExamTimetableDto examTimetableDto) {
        return ResponseEntity.ok(examTimetableService.addExamTimetable(examTimetableDto));
    }

	@PutMapping(ExamTimetableLinks.UPDATE_EXAM_TIMETABLE)
	@Operation(summary = "Update examtimetable records")
	public ResponseEntity<String> updateExamTimetable(@RequestBody ExamTimetableDto examTimetableDto, @PathVariable Long id) {
        return ResponseEntity.ok(examTimetableService.updateExamTimetable(examTimetableDto, id));
    }

	@DeleteMapping(ExamTimetableLinks.DELETE_EXAM_TIMETABLE)
	@Operation(summary = "Delete examtimetable records")
    public ResponseEntity<String> deleteExamTimetable(@PathVariable Long id) {
        String message = examTimetableService.deleteExamTimetable(id);
        return ResponseEntity.ok(message);
    }

	
}
