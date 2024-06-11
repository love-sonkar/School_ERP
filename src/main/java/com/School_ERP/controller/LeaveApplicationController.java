package com.School_ERP.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.School_ERP.dto.LeaveApplicationDto;

import com.School_ERP.links.LeaveApplicationLinks;
import com.School_ERP.service.LeaveApplicationService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin("*")
@RestController
@RequestMapping(LeaveApplicationLinks.LeaveApplication_Link)
@Tag(name = "LeaveApplication", description = "LeaveApplication Controller")
public class LeaveApplicationController {

	@Autowired
	private LeaveApplicationService leaveApplicationService;

	@PostMapping(path = LeaveApplicationLinks.apply_Leave)
	@Operation(summary = "This api use for applyLeaveApplication.")
	public ResponseEntity<LeaveApplicationDto> applyLeave(@RequestBody LeaveApplicationDto leaveApplicationDto) {
		LeaveApplicationDto createdApplication = leaveApplicationService.applyLeave(leaveApplicationDto);
		return ResponseEntity.ok(createdApplication);
	}

	@Operation(summary = "This api returns allLeaveApplication.")
	@GetMapping(path = LeaveApplicationLinks.getAllLeaveApplications)
	public ResponseEntity<List<LeaveApplicationDto>> getAllApplications() {
		List<LeaveApplicationDto> applications = leaveApplicationService.getAllApplications();
		return ResponseEntity.ok(applications);
	}

	@Operation(summary = "This api returns LeaveApplication using LeaveId.")
	@GetMapping(path = LeaveApplicationLinks.getApplicationByLeaveId)
	public ResponseEntity<LeaveApplicationDto> getApplicationByLeaveId(@PathVariable int leave_id) {
		LeaveApplicationDto application = leaveApplicationService.getApplicationByLeaveId(leave_id);
		return ResponseEntity.ok(application);
	}

	@Operation(summary = "This api use for update LeaveApplication.")
	@PutMapping(path = LeaveApplicationLinks.update_LeaveApplication)
	public ResponseEntity<LeaveApplicationDto> updateApplication(@PathVariable int leave_id,
			@RequestBody LeaveApplicationDto leaveApplicationDto) {
		LeaveApplicationDto updatedApplication = leaveApplicationService.updateApplication(leave_id,
				leaveApplicationDto);
		return ResponseEntity.ok(updatedApplication);
	}

	@Operation(summary = "This api use for delete LeaveApplication using LeaveId.")
	@DeleteMapping(path = LeaveApplicationLinks.deleteLeaveApplication_ByLeaveid)
	public ResponseEntity<Void> deleteApplicationByLeaveid(@PathVariable int leave_id) {
		leaveApplicationService.deleteApplicationByLeaveid(leave_id);
		return ResponseEntity.noContent().build();
	}
}