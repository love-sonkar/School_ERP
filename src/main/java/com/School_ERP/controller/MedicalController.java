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

import com.School_ERP.dto.MedicalDto;
import com.School_ERP.links.MedicalLinks;
import com.School_ERP.service.MedicalService;

@RestController
@RequestMapping(MedicalLinks.MEDICAL)
public class MedicalController {

    @Autowired
    private MedicalService medicalService;

    @GetMapping(MedicalLinks.GET_ALL_MEDICAL)
    public List<MedicalDto> getAllMedicalRecords() {
        return medicalService.getAllMedicalRecords();
    }

    @GetMapping(MedicalLinks.GET_MEDICAL)
    public ResponseEntity<MedicalDto> getMedicalRecordById(@PathVariable Long medicalId) {
        MedicalDto medicalDto = medicalService.getMedicalRecordById(medicalId);
        return ResponseEntity.ok(medicalDto);
    }

    @PostMapping(MedicalLinks.ADD_MEDICAL)
    public ResponseEntity<MedicalDto> createMedicalRecord(@RequestBody MedicalDto medicalDto) {
        MedicalDto savedMedical = medicalService.createMedicalRecord(medicalDto);
        return ResponseEntity.ok(savedMedical);
    }

    @PutMapping(MedicalLinks.UPDATE_MEDICAL)
    public ResponseEntity<MedicalDto> updateMedicalRecord(@PathVariable Long medicalId, @RequestBody MedicalDto medicalDto) {
        MedicalDto updatedMedical = medicalService.updateMedicalRecord(medicalId, medicalDto);
        return ResponseEntity.ok(updatedMedical);
    }

    @DeleteMapping(MedicalLinks.DELETE_MEDICAL)
    public ResponseEntity<Void> deleteMedicalRecord(@PathVariable Long medicalId) {
        medicalService.deleteMedicalRecord(medicalId);
        return ResponseEntity.noContent().build();
    }
}
