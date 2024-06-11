package com.School_ERP.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HostelDto {
	
	private int hostel_id;
	
	private int hostel_no;
	
	private String hostel_type;
	
	private String hostel_name;
	
	private int room_no;
	
	private String warden_name;
	
	private long warden_contact;
	
	private String std_joining_date;
	
	private String std_leaving_date;
	
	private int student_id;
}
