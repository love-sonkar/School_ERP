package com.School_ERP.service;

import java.util.List;

import com.School_ERP.dto.TimeTableDTO;

public interface TimeTableService {
	
	
	TimeTableDTO createTimeTable (TimeTableDTO timeTable);
	
	TimeTableDTO updateTimeTable(TimeTableDTO timeTable, Integer ID);
	
	TimeTableDTO getTimeTableById(Integer ID);
	
	List<TimeTableDTO> getAllTimeTables();
	
	void deleteTimeTable(Integer ID);
	
	
	
	
	

}
