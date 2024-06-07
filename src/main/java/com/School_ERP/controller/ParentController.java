package com.School_ERP.controller;
import com.School_ERP.links.ParentLinks;
import com.School_ERP.model.Parent;
import com.School_ERP.service.serviceImp.ParentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ParentLinks.PARENT_LINK)
public class ParentController {

    @Autowired
    ParentServiceImp parentService;

    @GetMapping(path = ParentLinks.GET_ALL)
    public List<Parent> getAllParent(){
        return parentService.getAllParent();
    }
    @GetMapping(path = ParentLinks.GET_PARENT)
    public Parent getSingleParentByParentId(@PathVariable String parentId){
        return parentService.getSingleParentService(Long.parseLong(parentId));
    }

    @PostMapping(path = ParentLinks.ADD_PARENT)
    public ResponseEntity<?> addParent(@RequestBody Parent parent){
        return parentService.addParentService(parent);
    }

    @PostMapping(path = ParentLinks.UPDATE_PARENT)
    public ResponseEntity<?> updateParent(@RequestBody Parent parent,@PathVariable String parentId){
        return parentService.updateParentService(parent, Long.parseLong(parentId));
    }

    @DeleteMapping(path = ParentLinks.DELETE_PARENT)
    public ResponseEntity<?> deleteParent(@PathVariable String parentId){
        return parentService.deleteParentService(Long.parseLong(parentId));
    }

}
