package com.School_ERP.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Data transfer object for Hostel")
public class HostelDto {

	@Schema(description = "Enter hostel Id", example = "1")
	private int hostel_id;

	@Schema(description = "Enter hostel No", example = "3")
	private int hostel_no;

	@Schema(description = "What's your Hostel type" ,example = "Boy's")
	private String hostel_type;

	@Schema(description = "Enter Your hostel name", example = "Dronacharya")
	private String hostel_name;

	@Schema(description = "Enter Your Room no for student" , example = "2")
	private int room_no;

	@Schema(description = "Enter Your Hostel Warder's Name" , example = "Manish Rawat")
	private String warden_name;

	@Schema(description = "Enter Warden's Contact No" , example = "1234567890")
	private long warden_contact;

	@Schema(description = "Enter Student's Joining Date" , example = "12-12-2023")
	private LocalDate std_joining_date;

	@Schema(description = "Enter Student's Hostel Leaving Date" , example = "04-06-2024")
	private LocalDate std_leaving_date;

	@Schema(description = "Enter Student's Id" , example = "1")
	private int student_id;
}
