package com.School_ERP.dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectDto {
    private String subCode;
    private String subName;
    private String days;
    private Integer weeklyClasses;
}
