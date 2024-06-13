package com.School_ERP.service;

import com.School_ERP.dto.EventDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface EventService {
    List<EventDto> getAllEvent();

    ResponseEntity<?> addEvent(String title, String description, MultipartFile picture) throws IOException;

    ResponseEntity<?> updateEvent(EventDto event, long id);

    ResponseEntity<?> deleteEvent(long id);
}
