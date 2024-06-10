package com.School_ERP.controller;

import com.School_ERP.links.EventLinks;
import com.School_ERP.entity.Event;
import com.School_ERP.repository.EventRepository;
import com.School_ERP.service.serviceImp.EventService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
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
    EventRepository eventRepo;

    @Autowired
    EventService eventService;

    @Operation(summary = "This method returns All Events List.")
    @GetMapping(path = EventLinks.GET_ALL_EVENT)
    public List<Event> getAllEvent(){
        return eventRepo.findAll();
    }

    @PostMapping(path = EventLinks.ADD_EVENT)
    @Operation(summary = "This method is to add Event.")
    public ResponseEntity<?> addEvent(@RequestParam("event") String event, @RequestParam("picture") MultipartFile picture) throws Exception {
        Event ee = new ObjectMapper().readValue(event.toString(),Event.class);
        return eventService.addEventService(ee,picture);
    }

    @PostMapping(path = EventLinks.UPDATE_LINK)
    @Operation(summary = "This method is to Update Event.")
    public ResponseEntity<?> updateEvent(@RequestParam("event") String event, @PathVariable String id) throws Exception {
        Event ee = new ObjectMapper().readValue(event.toString(),Event.class);
        return eventService.updateEventService(ee, Long.parseLong(id));
    }

    @Operation(summary = "This method is to Delete Event.")
    @DeleteMapping(path = EventLinks.DELETE_LINK)
    public ResponseEntity<?> deleteEvent(@PathVariable String id){
        return eventService.deleteEvent(Long.parseLong(id));
    }

}
