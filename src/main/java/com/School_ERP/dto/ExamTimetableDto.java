package com.School_ERP.dto;



import java.time.LocalDate;
import java.time.LocalTime;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExamTimetableDto {

	@Schema(description = "ID of the examination")
	private Long examid;
	
	@Schema(description = "DATE of the examination")
    private LocalDate date;
	
	@Schema(description = "TIME of the examination")
    private LocalTime time;
    
	@Schema(description = "examination class")
    private String standard;
    
	@Schema(description = "examination subject")
    private String subject;
    

}
