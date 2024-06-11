package com.School_ERP.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "hostel")
public class Hostel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int hostel_id;

    //	@Column(nullable = false)
    private int hostel_no;

    //	@Column(nullable = false)
    private String hostel_type;

    //	@Column(nullable = false)
    private String hostel_name;

    //	@Column(nullable = false)
    private int room_no;

    //	@Column(nullable = false)
    private String warden_name;

    //	@Column(nullable = false)
    private long warden_contact;

    //	@Column(nullable = false)
    private String std_joining_date;

    //	@Column(nullable = false)
    private String std_leaving_date;

    //	@Column(nullable = false)
    private int student_id;

    @OneToMany(mappedBy = "hostel",cascade = CascadeType.ALL)
    private List<Student> students = new ArrayList<>();

}
