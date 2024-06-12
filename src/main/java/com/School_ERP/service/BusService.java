package com.School_ERP.service;


import com.School_ERP.dto.BusDto;

import java.util.List;


public interface BusService {

    List<BusDto> getAllBuses();

    BusDto addBus(BusDto busDto);

    String deleteBus(Long id);

    BusDto updateBus(Long id, BusDto busDto);
   // List<BusDto> getBusesByEmployeeId(Long employeeId);

    BusDto getBusById(Long id);
}

