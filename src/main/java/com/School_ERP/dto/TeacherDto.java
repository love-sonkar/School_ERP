package com.School_ERP.dto;



import java.time.LocalDate;

import lombok.Data;




@Data
public class TeacherDto {
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
    private LocalDate joinDate;
    
	
}
