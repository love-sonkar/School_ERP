package com.School_ERP.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicalDto {
    private String handicap;
    private String medicalCondition;
    private String allergies;
    private String bloodGroup;
}
