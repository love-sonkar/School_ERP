package com.School_ERP.dto;

import lombok.Data;

import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusDto {

    private String busNo;

    private Integer totalSeat;

    private Integer availableSeat;

    private String driverContact;

    private String driverName;

    private String route;

}
