package com.School_ERP.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Attendence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long aId;
    private Long rollNo;
    private int totalDays;
    private int presentDays;
    private int totalLeaves;
    private int absent;
    @Schema(description = "Date of Attendence", example = "2024/06/11")
    private LocalDate date;

}
