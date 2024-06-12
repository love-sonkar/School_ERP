package com.School_ERP.entity;

import java.sql.Date;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empId;
    private String fname;
    private String lname;
    private int age;
    private String gender;
    private String qualification;
    private String bloodGroup;
    private long contact;
    private String email;
    private String address;
    
    @Column
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern = "yyyy-mm-dd")
    private LocalDate joinDate;
}
