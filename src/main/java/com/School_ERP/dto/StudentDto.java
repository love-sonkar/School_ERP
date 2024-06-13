package com.School_ERP.dto;

import java.time.LocalDate;

import com.School_ERP.entity.TimeTable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {
	private int admNo;
	
	private LocalDate adm_date;
	
	private String fname;
	
	private String lname;
	
	private String dob;
	
	private String gender;
	
	private long contact;
	
	private String blood_group;
	
	private String father_name;
	
	private String mother_name;
	
	private String standard;
	
	private char section;
	
	private String email;
	
	private String address;
	
	private String hostel_facility;
	
	private HostelDto hostel;
	
	private MedicalDto medical;
	
	private TimeTableDTO timeTable;
	
}
