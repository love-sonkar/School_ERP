package com.School_ERP.service.serviceImp;

import com.School_ERP.dto.EventDto;
import com.School_ERP.entity.Event;
import com.School_ERP.repository.EventRepository;
import com.School_ERP.service.EventService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class EventServiceImp implements EventService {

    @Autowired
    private EventRepository eventRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public List<EventDto> getAllEvent(){
        List<Event> event = eventRepo.findAll();
        List<EventDto> list = event.stream().map(eventinner -> {
            EventDto dto = null;
            dto = mapper.map(eventinner, EventDto.class);
            return dto;
        }).collect(Collectors.toList());
        return list;
    }

    @Override
    public ResponseEntity<?> addEvent(String title, String description, MultipartFile picture) throws IOException {
        EventDto event = new EventDto();
        if (!picture.isEmpty()) {
            String profileUploadDir = "D:\\School_ERP\\src\\main\\resources\\static\\picture";
            try {
                String fileExtension = picture.getOriginalFilename()
                        .substring(picture.getOriginalFilename().lastIndexOf(".") + 1);
                String filePath = profileUploadDir + File.separator + title + "_title" + "."
                        + fileExtension;
                File destFile = new File(filePath);
                picture.transferTo(destFile);
                Random rr = new Random();
                event.setPicture(rr.nextInt(9999) + "." + fileExtension);
            } catch (IOException e) {
                e.printStackTrace();
                throw new IOException("Failed to save the picture: " + e.getMessage());
            }
        }
        if(title != null && description != null){
            long time = new Timestamp(System.currentTimeMillis()).getTime();
            event.setTitle(title);
            event.setDescription(description);
            event.setCreateTimeStamp(time);
            event.setModifiedTimeStamp(0);
            Event eventDto = mapper.map(event,Event.class);
            Event eventSave = eventRepo.save(eventDto);
            EventDto savedEventDto = mapper.map(eventSave,EventDto.class);
            return ResponseEntity.ok(savedEventDto);
        }
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Error");
    }

    @Override
    public ResponseEntity<?> updateEvent(EventDto event, long id) {
        Event ee = eventRepo.findById(id);
        if(ee == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Event Not found");
        }
        if(!event.getTitle().isEmpty() && !event.getDescription().isEmpty()){
            ee.setTitle(event.getTitle());
            ee.setDescription(event.getDescription());
            ee.setModifiedTimeStamp(new Timestamp(System.currentTimeMillis()).getTime());
            Event eventSave = eventRepo.save(ee);
            EventDto eventDto = mapper.map(eventSave,EventDto.class);
            return ResponseEntity.ok(eventDto);
        }
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Error");
    }

    @Override
    public ResponseEntity<?> deleteEvent(long id){
        Event eventData = eventRepo.findById(id);
        if(eventData != null) {
            eventRepo.delete(eventData);
            return ResponseEntity.ok().body("Successfully Deleted");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Event Not found");
    }

}
