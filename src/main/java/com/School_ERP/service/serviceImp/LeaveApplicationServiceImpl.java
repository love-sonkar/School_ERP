package com.School_ERP.service.serviceImp;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.School_ERP.dto.LeaveApplicationDto;
import com.School_ERP.entity.LeaveApplication;
import com.School_ERP.repository.LeaveApplicationRepository;
import com.School_ERP.service.LeaveApplicationService;

@Service
public class LeaveApplicationServiceImpl implements LeaveApplicationService {

	@Autowired
	private LeaveApplicationRepository leaveApplicationRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public LeaveApplicationDto applyLeave(LeaveApplicationDto leaveApplicationDto) {
		LeaveApplication leaveApplication = modelMapper.map(leaveApplicationDto, LeaveApplication.class);
		LeaveApplication savedApplication = leaveApplicationRepository.save(leaveApplication);
		return modelMapper.map(savedApplication, LeaveApplicationDto.class);
	}

	@Override
	public List<LeaveApplicationDto> getAllApplications() {
		List<LeaveApplication> applications = leaveApplicationRepository.findAll();
		return applications.stream().map(application -> modelMapper.map(application, LeaveApplicationDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public LeaveApplicationDto getApplicationByLeaveId(int id) {
		Optional<LeaveApplication> applicationOptional = leaveApplicationRepository.findById(id);
		if (applicationOptional.isPresent()) {
			return modelMapper.map(applicationOptional.get(), LeaveApplicationDto.class);
		} else {
			throw new RuntimeException("Leave application not found for id :: " + id);
		}
	}

	@Override
	public LeaveApplicationDto updateApplication(int id, LeaveApplicationDto leaveApplicationDto) {
		Optional<LeaveApplication> applicationOptional = leaveApplicationRepository.findById(id);
		if (applicationOptional.isPresent()) {
			LeaveApplication leaveApplication = applicationOptional.get();
			modelMapper.map(leaveApplicationDto, leaveApplication);
			LeaveApplication updatedApplication = leaveApplicationRepository.save(leaveApplication);
			return modelMapper.map(updatedApplication, LeaveApplicationDto.class);
		} else {
			throw new RuntimeException("Leave application not found for id :: " + id);
		}
	}

	@Override
	public void deleteApplicationByLeaveid(int id) {
		leaveApplicationRepository.deleteById(id);
	}
}