package com.School_ERP.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.School_ERP.dto.TimeTableDTO;
import com.School_ERP.service.TimeTableService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/timeTable")
public class TimeTableController {

	@Autowired
	private TimeTableService timeTableService;
	
	
	//POST to create Time_Table
	
	@Operation(summary = " Create a new Time Table")
	@PostMapping("/")
	public ResponseEntity<TimeTableDTO> createTimeTable(@RequestBody TimeTableDTO timeTableDTO){
		TimeTableDTO createTimeTableDTO = this.timeTableService.createTimeTable(timeTableDTO);
		return new ResponseEntity<>(createTimeTableDTO,HttpStatus.CREATED);
		
	}
	
	//PUT to update Time_Table
	@Operation(summary = " Update Time Table")
	@PutMapping("/{ID}")
	 public ResponseEntity<TimeTableDTO> updateTimeTable( @RequestBody TimeTableDTO timeTableDTO , @PathVariable Integer ID){
		 TimeTableDTO updatedtimeTable = this.timeTableService.updateTimeTable(timeTableDTO, ID);
		 return ResponseEntity.ok(updatedtimeTable);
		 
	 }
	
	
	
	//DELETE to delete Time_Table
	
	@Operation(summary = "Delete Time Table")
	@DeleteMapping("/{ID}")
	public ResponseEntity<?> deleteTimeTable(@PathVariable("ID") Integer ID){
		this.timeTableService.deleteTimeTable(ID);
		return new ResponseEntity(Map.of("message", "Time Table deleted successfully"), HttpStatus.OK);
	}
	
	//GET to show/get all Time_Table
	
	@Operation(summary = " Get All Time Table")
	@GetMapping("/")
	public ResponseEntity<List<TimeTableDTO>> getAllTimeTables(){
		return ResponseEntity.ok(this.timeTableService.getAllTimeTables());
		
	}
	
	//GET single User time table
	
	
	@Operation(summary = " Get single Time Table")
	@GetMapping("/{ID}")
	public ResponseEntity<TimeTableDTO> getSingleTimeTable(@PathVariable Integer ID){
		return ResponseEntity.ok(this.timeTableService.getTimeTableById(ID));
		
		
	}
	
	
}
