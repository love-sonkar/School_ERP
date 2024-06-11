package com.School_ERP.entity;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Schema(description = "Entity representing a LeaveApplication in the system")
public class LeaveApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "The unique identifier for the leave request", example="1")
    private int leave_id;
    private String name;
    private String designation;
    private String phone_number;
    private LocalDate date;
    private LocalTime time;
    private String leave_type;
    private String subject;
    private String reason;
    private Date from_date;
    private Date to_date;
}
