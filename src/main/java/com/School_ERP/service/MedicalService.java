package com.School_ERP.service;

import com.School_ERP.dto.MedicalDto;

import java.util.List;

public interface MedicalService {
    List<MedicalDto> getAllMedicalRecords();
    MedicalDto getMedicalRecordById(Long id);
    MedicalDto createMedicalRecord(MedicalDto medicalDto);
    MedicalDto updateMedicalRecord(Long id, MedicalDto medicalDto);
    void deleteMedicalRecord(Long id);
}
