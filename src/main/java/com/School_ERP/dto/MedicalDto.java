package com.School_ERP.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicalDto {
    @Schema(description = "ID of the medical record")
    private Long medicalId;
    
    @Schema(description = "Description of the handicap")
    private String handicap;
    
    @Schema(description = "Description of the medical condition")
    private String medicalCondition;
    
    @Schema(description = "List of allergies")
    private String allergies;
    
    @Schema(description = "Blood group")
    private String bloodGroup;
}
