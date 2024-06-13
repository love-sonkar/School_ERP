package com.School_ERP.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor

@Setter
@Getter
@Schema(description = "Data Transfer Object for  Time Table")

public class TimeTableDTO {
	
	private int timetable_id;
	
	private String teacher;
	
	private String time;
	
	private String subject;

}
