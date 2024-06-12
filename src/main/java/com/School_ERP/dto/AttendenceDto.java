package com.School_ERP.dto;

import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AttendenceDto {

    private long aId;
    private Long rollNo;
    private int totalDays;
    private int presentDays;
    private int totalLeaves;
    private int absent;
    private LocalDate date;
}
