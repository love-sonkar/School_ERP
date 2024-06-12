package com.School_ERP.entity;

import java.time.LocalDate;

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
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="admission_number")
	private int adm_no;
	
	@Column(name="admission_date")
	private LocalDate adm_date;
	
	@Column(name="first_name")
	private String fname;
	
	@Column(name="last_name")
	private String lname;
	
	@Column(name="date_of_birth")
	private String dob;
	
	private String gender;
//	@Column(nullable = false)
	private long contact;
	
	private String blood_group;
	
//	@Column(nullable = false)
	private String father_name;
	
	private String mother_name;
	
	private String standard;
	
	private char section;
	
//	@Column(nullable = false)
	private String email;
	
//	@Column(nullable = false)
	private String address;
	
//	@Column(nullable = false)
	private String hostel_facility;

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
	

}
