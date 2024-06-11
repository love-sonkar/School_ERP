package com.School_ERP.service;

import java.util.List;

import com.School_ERP.dto.HostelDto;

public interface HostelService {
	public String addHostel(HostelDto hostel);
	
	public List<HostelDto> getAllHostel();
	
	public HostelDto getHostelById(int id);
	
	public String deleteHostel(int id);
	
	public String updateHostelDetails(HostelDto hostel, int id);
}
