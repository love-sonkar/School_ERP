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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(MedicalLinks.MEDICAL)
@Tag(name = "Medical", description = "API for Medical Records Management")
public class MedicalController {

    @Autowired
    private MedicalService medicalService;

    @GetMapping(MedicalLinks.GET_ALL_MEDICAL)
    @Operation(summary = "Get all medical records")
    public List<MedicalDto> getAllMedicalRecords() {
        return medicalService.getAllMedicalRecords();
    }

    @GetMapping(MedicalLinks.GET_MEDICAL)
    @Operation(summary = "Get a medical record by ID")
    public ResponseEntity<MedicalDto> getMedicalRecordById(@PathVariable Long medicalId) {
        MedicalDto medicalDto = medicalService.getMedicalRecordById(medicalId);
        return ResponseEntity.ok(medicalDto);
    }

    @PostMapping(MedicalLinks.ADD_MEDICAL)
    @Operation(summary = "Create a new medical record")
    public ResponseEntity<MedicalDto> createMedicalRecord(@RequestBody MedicalDto medicalDto) {
        MedicalDto savedMedical = medicalService.createMedicalRecord(medicalDto);
        return ResponseEntity.ok(savedMedical);
    }

    @PutMapping(MedicalLinks.UPDATE_MEDICAL)
    @Operation(summary = "Update a medical record")
    public ResponseEntity<MedicalDto> updateMedicalRecord(@PathVariable Long medicalId, @RequestBody MedicalDto medicalDto) {
        MedicalDto updatedMedical = medicalService.updateMedicalRecord(medicalId, medicalDto);
        return ResponseEntity.ok(updatedMedical);
    }

    @DeleteMapping(MedicalLinks.DELETE_MEDICAL)
    @Operation(summary = "Delete a medical record")
    public ResponseEntity<Void> deleteMedicalRecord(@PathVariable Long medicalId) {
        medicalService.deleteMedicalRecord(medicalId);
        return ResponseEntity.noContent().build();
    }
}
