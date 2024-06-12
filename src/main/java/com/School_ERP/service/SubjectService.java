package com.School_ERP.service;

import com.School_ERP.dto.SubjectDto;
import java.util.List;

public interface SubjectService {
    List<SubjectDto> getAllSubjects();
    SubjectDto addSubject(SubjectDto subjectDto);
    SubjectDto updateSubject(Long id, SubjectDto subjectDto);
    String deleteSubject(Long id);
    SubjectDto getSubjectById(Long id);
}
