package com.School_ERP.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "bus")
@Data
public class Bus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bus_id")
    private Long id;

    @Column(name = "bus_no")
    private String busNo;

    @Column(name = "total_seat")
    private Integer totalSeat;

    @Column(name = "available_seat")
    private Integer availableSeat;

    @Column(name = "driver_contact")
    private String driverContact;

    @Column(name = "driver_name")
    private String driverName;

    @Column(name = "route")
    private String route;

   // @ManyToOne
  //  @JoinColumn(name = "employee_id", nullable = false)
   // private EmployeeEntity employee;
}
