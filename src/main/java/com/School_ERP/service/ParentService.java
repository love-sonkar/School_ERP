package com.School_ERP.service;

import com.School_ERP.entity.Parent;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ParentService {

    List<Parent> getAllParent();
    Parent getSingleParentService(long parentId);
    ResponseEntity<?> addParentService(Parent parent);
    ResponseEntity<?> updateParentService(Parent parent, long parentId);
    ResponseEntity<?> deleteParentService(long parentId);
    ResponseEntity<?> getParentByStudentId(long studentId) throws JsonProcessingException;
}
