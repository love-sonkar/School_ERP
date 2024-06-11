package com.School_ERP.service;

import java.util.List;

import com.School_ERP.dto.LeaveApplicationDto;

public interface LeaveApplicationService {
	LeaveApplicationDto applyLeave(LeaveApplicationDto leaveApplicationDto);

	List<LeaveApplicationDto> getAllApplications();

	LeaveApplicationDto getApplicationByLeaveId(int id);

	LeaveApplicationDto updateApplication(int id, LeaveApplicationDto leaveApplicationDto);

	void deleteApplicationByLeaveid(int id);

}
