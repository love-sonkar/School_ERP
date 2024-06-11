package com.School_ERP.service.serviceImp;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.School_ERP.dto.ExamTimetableDto;
import com.School_ERP.entity.ExamTimetable;
import com.School_ERP.repository.ExamTimetableRepository;
import com.School_ERP.service.ExamTimetableService;

@Service
public class ExamTimetableServiceImpl implements ExamTimetableService{

	@Autowired
	private ExamTimetableRepository examTimetableRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<ExamTimetableDto> getAllExamTimetables() {
        List<ExamTimetable> allExamTimetables = examTimetableRepo.findAll();
        return allExamTimetables.stream()
                .map(examTimetable -> modelMapper.map(examTimetable, ExamTimetableDto.class))
                .collect(Collectors.toList());
    }

	@Override
	public ExamTimetableDto getExamTimetableById(Long id) {
        ExamTimetable examTimetable = examTimetableRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Exam timetable not found"));
        return modelMapper.map(examTimetable, ExamTimetableDto.class);
    }

	@Override
	public String addExamTimetable(ExamTimetableDto examTimetableDto) {
	        ExamTimetable examTimetable = modelMapper.map(examTimetableDto, ExamTimetable.class);
	        examTimetableRepo.save(examTimetable);
	        return "Exam timetable added successfully!";
	    }

	
	@Override
	public String updateExamTimetable(ExamTimetableDto examTimetableDto, Long id) {
        ExamTimetable existingExamTimetable = examTimetableRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Exam timetable not found"));
        existingExamTimetable.setDate(examTimetableDto.getDate());
        existingExamTimetable.setTime(examTimetableDto.getTime());
        existingExamTimetable.setStandard(examTimetableDto.getStandard());
        existingExamTimetable.setSubject(examTimetableDto.getSubject());
        examTimetableRepo.save(existingExamTimetable);
        return "Exam timetable updated successfully!";
    }

	@Override
    public String deleteExamTimetable(Long id) {
        examTimetableRepo.deleteById(id);
        return "Exam timetable deleted successfully!";
    }

	
}
