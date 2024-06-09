package com.School_ERP.controller;

import com.School_ERP.links.EventLinks;
import com.School_ERP.entity.Event;
import com.School_ERP.repository.EventRepository;
import com.School_ERP.service.serviceImp.EventServiceImp;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(EventLinks.EVENT_LINK)
public class EventController {

    @Autowired
    EventRepository eventRepo;

    @Autowired
    EventServiceImp eventServiceImp;

    @GetMapping(path = EventLinks.GET_ALL_EVENT)
    public List<Event> getAllEvent(){
        return eventRepo.findAll();
    }

    @PostMapping(path = EventLinks.ADD_EVENT)
    public ResponseEntity<?> addEvent(@RequestParam("event") String event, @RequestParam("picture") MultipartFile picture) throws Exception {
        Event ee = new ObjectMapper().readValue(event.toString(),Event.class);
        return eventServiceImp.addEventService(ee,picture);
    }

    @PostMapping(path = EventLinks.UPDATE_LINK)
    public ResponseEntity<?> updateEvent(@RequestParam("event") String event, @PathVariable String id) throws Exception {
        Event ee = new ObjectMapper().readValue(event.toString(),Event.class);
        return eventServiceImp.updateEventService(ee, Long.parseLong(id));
    }

    @DeleteMapping(path = EventLinks.DELETE_LINK)
    public ResponseEntity<?> deleteEvent(@PathVariable String id){
        return eventServiceImp.deleteEvent(Long.parseLong(id));
    }

}
