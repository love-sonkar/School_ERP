package com.School_ERP.dto;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Schema(description = "Data Transfer Object for LeaveApplication")
public class LeaveApplicationDto {

	@Schema(description = "The name of the person requesting leave", example = "ram")
	private String name;
	@Schema(description = "The designation of the person requesting leave", example = "student")
	private String designation;
	@Schema(description = "The phone number of the person requesting leave", example = "1234567895")
	private String phone_number;
	@Schema(description = "The date of the leave request", example = "2024/05/23")
	private LocalDate date;
	@Schema(description = "The time of the leave request", example = "12:30:20")
	private LocalTime time;
	@Schema(description = "The type of leave requested", example = "Vacation")
	private String leave_type;
	@Schema(description = "The subject of the leave request", example = "Annual leave request")
	private String subject;
	@Schema(description = "The reason for the leave request", example = "Traveling abroad")
	private String reason;
	@Schema(description = "The starting date of the leave period", example = "2024/05/23")
	private Date from_date;
	@Schema(description = "The ending date of the leave period", example = "2024/05/23")
	private Date to_date;
}