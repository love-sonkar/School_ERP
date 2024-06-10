package com.School_ERP.service.serviceImp;
import com.School_ERP.dto.ParentDto;
import com.School_ERP.entity.Parent;
import com.School_ERP.repository.ParentRepo;
import com.School_ERP.service.ParentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParentServiceImp implements ParentService {


    @Autowired
    ParentRepo parentRepo;

    @Override
    public List<Parent> getAllParent(){
        return parentRepo.findAll();
    }

    @Override
    public Parent getSingleParentService(long parentId){
        return parentRepo.findByParentId(parentId);
    }

    @Override
    public ResponseEntity<?> addParentService(Parent parent){
        if(parent != null) {
            if(parent.getFname() == null || parent.getFname().isEmpty()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("First Name not found");
            }
            if(parent.getLname() == null || parent.getLname().isEmpty()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Last Name not found");
            }
            if(parent.getAddress() == null || parent.getAddress().isEmpty()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Address not found");
            }
            if(parent.getEmail() == null || parent.getEmail().isEmpty()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Email not found");
            }
            if(String.valueOf(parent.getContact()).length() <= 9){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Wrong contact detail");
            }
            if(String.valueOf(parent.getStudentId()).isEmpty()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Wrong Student id");
            }
            Parent addedParent = parentRepo.save(parent);
            return ResponseEntity.ok(addedParent);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Parent Not Added");
    }

    @Override
    public ResponseEntity<?> updateParentService(Parent parent,long parentId){
        Parent getParent = parentRepo.findByParentId(parentId);
        if(getParent != null){
            if(parent.getLname() != null){
                getParent.setLname(parent.getLname());
            }
            if(parent.getFname() != null){
                getParent.setFname(parent.getFname());
            }
            if(parent.getAddress() != null){
                getParent.setAddress(parent.getAddress());
            }
            if(parent.getEmail() != null){
                getParent.setEmail(parent.getEmail());
            }
            if(parent.getContact() != 0){
                getParent.setContact(parent.getContact());
            }
            Parent updatedParent = parentRepo.save(getParent);
            return ResponseEntity.ok(updatedParent);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Parent Not Found");
    }

    @Override
    public ResponseEntity<?> deleteParentService(long parentId){
        Parent getParent = parentRepo.findByParentId(parentId);
        if(getParent == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Parent Not Found");
        }
        parentRepo.delete(getParent);
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Successfully Deleted");
    }


    @Override
    public ResponseEntity<?> getParentByStudentId(long studentId) throws JsonProcessingException {
        Parent getParent = parentRepo.findByStudentId(studentId);
        if(getParent == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Parent Not Found");
        }
        ParentDto parentDto = new ObjectMapper().readValue(getParent.toString(), ParentDto.class);
        return ResponseEntity.ok().body(parentDto);
    }
}
