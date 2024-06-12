package com.School_ERP.controller;


import com.School_ERP.dto.BusDto;
import com.School_ERP.links.BusLinks;
import com.School_ERP.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BusController {

    @Autowired
    private BusService busService;

    @GetMapping(path = BusLinks.GET_ALL)
    public List<BusDto> getAllBuses() {
        return busService.getAllBuses();
    }


    @PostMapping(path = BusLinks.ADD_BUS)
    public BusDto addBus(@RequestBody BusDto busDto) {
        return busService.addBus(busDto);
    }
    @PutMapping(path = BusLinks.UPDATE_BUS)
    public BusDto updateBus(@PathVariable Long id, @RequestBody BusDto busDto) {
        return busService.updateBus(id, busDto);
    }
    @DeleteMapping(path = BusLinks.DELETE_BUS)
    public String deleteBus(@PathVariable Long id) {
        return busService.deleteBus(id);
    }

    // New method to get a bus by ID
    @GetMapping(path = BusLinks.GET_BUS)
    public BusDto getBusById(@PathVariable("id") Long id) {
        int idInt = id.intValue(); // Convert Long to int
        return (BusDto) busService.getBusById(id);
    }

}
