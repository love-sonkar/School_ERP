package com.School_ERP.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Medical {
	@Id
	private String handicap;
	private String medical_condition;
	private String allergies;
	private String blood_group;
}
