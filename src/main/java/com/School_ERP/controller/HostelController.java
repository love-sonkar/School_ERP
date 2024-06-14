package com.School_ERP.controller;

import java.util.List;
import java.util.Optional;

import com.School_ERP.service.serviceImp.HostelServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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

import com.School_ERP.dto.HostelDto;
import com.School_ERP.links.HostelLinks;


@RestController
@RequestMapping(path = HostelLinks.HOSTEL_PATH)
@Tag(name = "Hostel" , description = "API for Hostel management")
public class HostelController {
	
	@Autowired
	private HostelServiceImpl hostelService;
	
	@PostMapping(path = HostelLinks.ADD_HOSTEL)
	@Operation(summary = "Add a new hostel")
	public ResponseEntity<String> addHostel(@RequestBody HostelDto hostel) {
		try {
			String response = this.hostelService.addHostel(hostel);
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@GetMapping(path = HostelLinks.GET_ALL_STUDENT)
	@Operation(summary = "Get all students present in hostel")
	public ResponseEntity<List<HostelDto>> getAllStudent(){
		try {
			List<HostelDto> list = this.hostelService.getAllHostel();
			if(list.size() <= 0) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
			return ResponseEntity.of(Optional.of(list));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@GetMapping(path = HostelLinks.GET_HOSTEL_BY_ID)
	@Operation(summary = "Get hostel by hostel Id")
	public ResponseEntity<HostelDto> getHostelById(@PathVariable("hostelId") int id) {
		try {
			HostelDto response = this.hostelService.getHostelById(id);
			if(response == null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
			return ResponseEntity.of(Optional.of(response));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@DeleteMapping(path = HostelLinks.DELETE_HOSTEL_DETAILS)
	@Operation(summary = "Delete Hostel from Database")
	public ResponseEntity<String> deleteHostel(@PathVariable("hostelId") int id) {
		try {
			String response = this.hostelService.deleteHostel(id);
			return ResponseEntity.of(Optional.of(response));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PutMapping(path = HostelLinks.UPDATE_HOSTEL_DETAILS)
	@Operation(summary = "Update Hostel Details")
	public ResponseEntity<String> updateHostelDetails(@RequestBody HostelDto hostel, @PathVariable("hostelId") int id) {
		try {
			String response = this.hostelService.updateHostelDetails(hostel, id);
			if(hostel == null) {
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			}
			return ResponseEntity.of(Optional.of(response));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
