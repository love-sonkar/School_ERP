package com.School_ERP.service;

import com.School_ERP.entity.Event;
import com.School_ERP.service.serviceImp.EventServiceImp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface EventService  {

    ResponseEntity<?> addEventService(Event event, MultipartFile picture) throws IOException;
    ResponseEntity<?> updateEventService(Event event, long id) throws IOException;
    ResponseEntity<?> deleteEvent(long id);
}
