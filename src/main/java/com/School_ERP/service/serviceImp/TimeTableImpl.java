package com.School_ERP.service.serviceImp;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.School_ERP.exceptions.*;
import com.School_ERP.dto.TimeTableDTO;
import com.School_ERP.entity.TimeTable;
import com.School_ERP.repository.TimeTableRepo;
import com.School_ERP.service.TimeTableService;

@Service

public class TimeTableImpl implements TimeTableService {
	
	
	@Autowired
	private TimeTableRepo timeTableRepo;
	
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	

	@Override
	public TimeTableDTO createTimeTable(TimeTableDTO timeTableDTO) {
		
		TimeTable timeTable=this.dtoToTimeTable(timeTableDTO);
		TimeTable savedTimeTable= this.timeTableRepo.save(timeTable);
	    
		return this.timeTableTodto(savedTimeTable);
	}

	@Override
	public TimeTableDTO updateTimeTable(TimeTableDTO timeTableDTO, Integer ID) {
		
		TimeTable timeTable = this.timeTableRepo.findById(ID).orElseThrow( ()->  new ResourceNotFoundException("TimeTable","Id",ID));
		
		timeTable.setSubject(timeTableDTO.getSubject());
		timeTable.setTeacher(timeTableDTO.getTeacher());
		timeTable.setTime(timeTableDTO.getTime());
		
		 TimeTable updatedTimeTable = this.timeTableRepo.save(timeTable);
		 TimeTableDTO timeTableDTO1 = this.timeTableTodto(updatedTimeTable);
		return timeTableDTO1;
	}

	@Override
	public TimeTableDTO getTimeTableById(Integer ID) {
		
		TimeTable timeTable = this.timeTableRepo.findById(ID).orElseThrow(()-> new ResourceNotFoundException("TimeTable","Id", ID));
		return this.timeTableTodto(timeTable);
		
	}

	@Override
	public List<TimeTableDTO> getAllTimeTables() {
		List<TimeTable> timeTables= this.timeTableRepo.findAll();
	    List<TimeTableDTO> timeTableDTOs=	timeTables.stream().map(timeTable ->this.timeTableTodto(timeTable)).collect(Collectors.toList());
		
		return timeTableDTOs ;
		
	}

	@Override
	public void deleteTimeTable(Integer ID) {
	  TimeTable timeTable=	this.timeTableRepo.findById(ID).orElseThrow(()-> new ResourceNotFoundException("TimeTable", "Id", ID));
       this.timeTableRepo.delete(timeTable);
	}
	
	public TimeTable dtoToTimeTable(TimeTableDTO timeTableDTO) {
		
		TimeTable timeTable = this.modelMapper.map(timeTableDTO, TimeTable.class);
		
//		timeTable.setTeacher(timeTableDTO.getTeacher());
//		timeTable.setId(timeTableDTO.getId());
//		timeTable.setSubject(timeTableDTO.getSubject());
//		timeTable.setTime(timeTableDTO.getTime());
		
		return timeTable;
			
	}
	
	public TimeTableDTO timeTableTodto(TimeTable timeTable) {
		
		TimeTableDTO timeTableDTO= this.modelMapper.map(timeTable, TimeTableDTO.class);
		
		
//		timeTable.setId(timeTable.getId());
//		timeTableDTO.setTeacher(timeTable.getTeacher());
//		timeTableDTO.setSubject(timeTable.getSubject());
//		timeTableDTO.setTime(timeTable.getTime());
		
		return timeTableDTO;
		
	}

}
