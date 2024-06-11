package com.School_ERP.service;

import java.util.List;

import com.School_ERP.dto.ExamTimetableDto;

public interface ExamTimetableService {

	List<ExamTimetableDto> getAllExamTimetables();
    ExamTimetableDto getExamTimetableById(Long id);
    String addExamTimetable(ExamTimetableDto examTimetableDto);
    String updateExamTimetable(ExamTimetableDto examTimetableDto, Long id);
    String deleteExamTimetable(Long id);

}
