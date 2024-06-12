package com.School_ERP.controller;

import com.School_ERP.dto.EventDto;
import com.School_ERP.links.EventLinks;
import com.School_ERP.service.serviceImp.EventServiceImp;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(EventLinks.EVENT_LINK)
@Tag(name = "Event", description = "API for Event Management")
public class EventController {

    @Autowired
    EventServiceImp eventServiceImp;

    @Autowired
    ModelMapper mapper;

    @Operation(summary = "This method returns All Events List.")
    @GetMapping(path = EventLinks.GET_ALL_EVENT)
    public List<EventDto> getAllEvent(){
        return eventServiceImp.getAllEvent();
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, path = EventLinks.ADD_EVENT)
    @Operation(summary = "This method is to add Event.")
    public ResponseEntity<?> addEvent(@RequestParam("title") String title, @RequestParam("description") String description, @RequestParam("picture") MultipartFile picture) throws Exception {
        return eventServiceImp.addEvent(title, description, picture);
    }

    @PostMapping(path = EventLinks.UPDATE_LINK)
    @Operation(summary = "This method is to Update Event.")
    public ResponseEntity<?> updateEvent(@RequestBody EventDto event, @PathVariable String id) throws Exception {
        return eventServiceImp.updateEvent(event, Long.parseLong(id));
    }

    @Operation(summary = "This method is to Delete Event.")
    @DeleteMapping(path = EventLinks.DELETE_LINK)
    public ResponseEntity<?> deleteEvent(@PathVariable String id){
        return eventServiceImp.deleteEvent(Long.parseLong(id));
    }

}
