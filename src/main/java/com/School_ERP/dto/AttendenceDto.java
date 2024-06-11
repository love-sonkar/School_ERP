package com.School_ERP.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AttendenceDto {

    private long aId;
    private Long rollNo;
    private int totaldays;
    private int presentDays;
    private int totalLeaves;
    private int absent;
}
