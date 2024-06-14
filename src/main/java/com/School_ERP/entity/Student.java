package com.School_ERP.entity;

import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="student")
@Schema(description = "Entity representing for Student")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="admission_number")
	@Schema(description = "Admission Number for Student",example = "1")
	private int admNo;
	
	@Column(name="admission_date")
	@Schema(description = "Admission Date of student" , example = "12-12-2024")
	private LocalDate adm_date;
	
	@Column(name="first_name")
	@Schema(description = "First name of student" , example = "Deepak")
	private String fname;
	
	@Column(name="last_name")
	@Schema(description = "Last name of student" , example = "Sarwa")
	private String lname;
	
	@Column(name="date_of_birth")
	@Schema(description = "Date of birth" , example = "18-02-1999")
	private LocalDate dob;

	@Schema(description = "Student's Gender" , example = "Male")
	private String gender;

//	@Column(nullable = false)
	@Schema(description = "Student or Parents Contact number" , example = "7089972238")
	private long contact;

	@Schema(description = "Student's Blood Group" , example = "B+ve")
	private String blood_group;
	
	@Schema(description = "Father's Name" , example = "Naresh Kumar Sarwa")
	private String father_name;

	@Schema(description = "Mother's Name" , example = "Pramila Sarwa")
	private String mother_name;

	@Schema(description = "Student's Class", example = "10th")
	private String standard;

	@Schema(description = "Student's Class Section" , example = "F")
	private char section;
	
	@Column(nullable = false)
	@Schema(description = "Student's or Parent's mail Id and It should be Unique" , example = "deepaksarwa7@gmail.com")
	private String email;
	
	@Column(nullable = false)
	@Schema(description = "Student's Address" , example = "Sarwa Sadan")
	private String address;
	
	@Column(nullable = false)
	@Schema(description = "Student is using hostel or Not" , example = "Yes")
	private String hostel_facility;

	@Column(nullable = false)
	@Schema(description = "Student's current Roll No" , example = "1141423384")
	private String roll_no;


//	@ManyToMany
//	@JoinTable(name = "student_hostel",
//			joinColumns = @JoinColumn(name = "student_id"),
//			inverseJoinColumns = @JoinColumn
//			(name = "hostel_id")
//	)
//	private List<Hostel> hostel;

	@ManyToOne
	@JoinColumn(name = "hostel_id")
	private Hostel hostel;

	@OneToOne
	@JoinColumn(name = "medicalId")
	private Medical medical;

	@ManyToOne
	@JoinColumn(name = "timetable_id")
	private TimeTable timeTable;
	
	@ManyToOne
	@JoinColumn(name = "examtimetable")
	private ExamTimetable examtimetable;

}
