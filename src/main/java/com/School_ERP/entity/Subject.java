package com.School_ERP.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "subject")
@Data
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "sub_code")
    private String subCode;

    @Column(name = "sub_name")
    private String subName;

    @Column(name = "days")
    private String days;

    @Column(name = "weekly_classes")
    private Integer weeklyClasses;

   // @OneToOne
   // private Teacher teacher;
}
