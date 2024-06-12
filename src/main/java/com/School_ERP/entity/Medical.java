package com.School_ERP.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long medicalId;
    private String handicap;
    private String medicalCondition;
    private String allergies;
    private String bloodGroup;
}
