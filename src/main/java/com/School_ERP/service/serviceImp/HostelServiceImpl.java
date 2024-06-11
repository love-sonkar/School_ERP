package com.School_ERP.service.serviceImp;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.School_ERP.dto.HostelDto;
import com.School_ERP.entity.Hostel;
import com.School_ERP.repository.HostelRepo;
import com.School_ERP.service.HostelService;

@Service
public class HostelServiceImpl implements HostelService {
	
	@Autowired
	private HostelRepo hostelRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public String addHostel(HostelDto host) {
		Hostel hostel = this.modelMapper.map(host, Hostel.class);
		this.hostelRepo.save(hostel);
		return "Hostel added successfully!";
	}
	
	public List<HostelDto> getAllHostel(){
		List<Hostel> allHostel = this.hostelRepo.findAll();
		List<HostelDto> list = allHostel.stream().map(hostel ->{
			HostelDto dto = this.modelMapper.map(hostel, HostelDto.class);
			return dto;
		}).collect(Collectors.toList());
		return list;
	}
	
	public HostelDto getHostelById(int id) {
		Hostel hostel = this.hostelRepo.findById(id);
		HostelDto hostelDto = this.modelMapper.map(hostel, HostelDto.class);
		return hostelDto;
	}
	
	public String deleteHostel(int id) {
		this.hostelRepo.deleteById(id);
		return "Hostel data deleted successfully!";
	}
	
	public String updateHostelDetails(HostelDto host, int id) {
		Hostel previousData = this.hostelRepo.findById(id);
		Hostel currentData = this.modelMapper.map(host, Hostel.class);
		
		previousData.setHostel_no(currentData.getHostel_no());
		previousData.setHostel_name(currentData.getHostel_name());
		previousData.setHostel_type(currentData.getHostel_type());
		previousData.setRoom_no(currentData.getRoom_no());
		previousData.setWarden_name(currentData.getWarden_name());
		previousData.setWarden_contact(currentData.getWarden_contact());
		previousData.setStd_joining_date(currentData.getStd_joining_date());
		previousData.setStd_leaving_date(currentData.getStd_leaving_date());
		previousData.setStudent_id(currentData.getStudent_id());
		
		this.hostelRepo.save(previousData);
		
		return "Hostel data updated successfully!";
	}

}
