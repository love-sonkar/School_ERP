package com.School_ERP.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;



@Data
@Entity
public class ExamTimetable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long examid;
	private LocalDate date;
	private LocalTime time;
	private String standard;
	private String subject;
}
