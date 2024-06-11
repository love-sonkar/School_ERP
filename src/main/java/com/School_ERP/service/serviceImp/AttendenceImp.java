package com.School_ERP.service.serviceImp;

import com.School_ERP.dto.AttendenceDto;
import com.School_ERP.dto.LibraryDto;
import com.School_ERP.entity.Attendence;
import com.School_ERP.repository.AttendenceRepository;
import com.School_ERP.service.AttendenceService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class AttendenceImp implements AttendenceService {

    @Autowired
    AttendenceRepository attendenceRepository;

    @Override
    public List<AttendenceDto> getAllAttendance() {
        List<Attendence> attendenceList = attendenceRepository.findAll();
        List<AttendenceDto> list = attendenceList.stream().map(attendance -> {
            AttendenceDto dto = null;
            try {
                dto = new ObjectMapper().readValue(attendance.toString(), AttendenceDto.class);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
            return dto;
        }).collect(Collectors.toList());
        return list;
    }


}
