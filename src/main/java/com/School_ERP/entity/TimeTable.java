package com.School_ERP.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "time__tables")
@NoArgsConstructor
@Getter
@Setter

public class TimeTable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "class_time")
	private String time;
	
	@Column(name = "teacher")
	 private String teacher;
	
	@Column(name = "subject")
	  private String subject;

	  @OneToMany(mappedBy = "timeTable" , cascade = CascadeType.ALL)
	  private List<Student> students = new ArrayList<>();

}
