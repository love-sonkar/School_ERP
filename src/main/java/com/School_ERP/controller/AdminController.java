package com.School_ERP.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.School_ERP.dto.AdminDTO;
import com.School_ERP.entity.Admin;
import com.School_ERP.links.AdminLinks;
import com.School_ERP.service.AdminService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
@RestController
@RequestMapping(AdminLinks.ADMIN_LINK)

@Tag(name = "Admin", description = "API for Admin Records Management")
public class AdminController {

    @Autowired
    private AdminService adminService;

    // API to create a new admin
    @PostMapping(path = AdminLinks.ADD_ADMIN)
    @Operation(summary = "Create a new admin")
    public ResponseEntity<String> createAdmin(@RequestBody AdminDTO adminDTO) {
        Admin admin = adminService.saveAdmin(adminDTO);
        if (admin != null) {
            return ResponseEntity.ok("Admin successfully created");
        } else {
            return ResponseEntity.status(500).body("Error creating admin");
        }
    }

    // API for admin login
    @PostMapping(path = AdminLinks.LOGIN_ADMIN)
    @Operation(summary = "Admin login")
    public ResponseEntity<String> login(@RequestBody AdminDTO adminDTO) {
        boolean isValid = adminService.checkLogin(adminDTO.getUserName(), adminDTO.getPassword());
        if (isValid) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(401).body("Invalid username or password");
        }
    }

    // API to get all admins
    @GetMapping(path = AdminLinks.GET_ALL)
    @Operation(summary = "Get all admins")
    public ResponseEntity<?> getAllAdmins() {
        List<Admin> admins = adminService.getAllAdmins();
        if (admins.isEmpty()) {
            return ResponseEntity.status(404).body("No admins found");
        } else {
            return ResponseEntity.ok(admins);
        }
    }

    // API to get an admin by ID
    @GetMapping(path = AdminLinks.GET_ADMIN)
    @Operation(summary = "Get an admin by ID")
    public ResponseEntity<?> getAdminById(@PathVariable Long id) {
        Admin admin = adminService.getAdminById(id);
        if (admin != null) {
            return ResponseEntity.ok(admin);
        } else {
            return ResponseEntity.status(404).body("Admin not found");
        }
    }

    // API to update an admin
    @PutMapping(path = AdminLinks.UPDATE_ADMIN)
    @Operation(summary = "Update an admin")
    public ResponseEntity<String> updateAdmin(@PathVariable Long id, @RequestBody AdminDTO adminDTO) {
        Admin admin = adminService.updateAdmin(id, adminDTO);
        if (admin != null) {
            return ResponseEntity.ok("Admin successfully updated");
        } else {
            return ResponseEntity.status(404).body("Admin not found");
        }
    }

    // API to delete an admin
    @DeleteMapping(path = AdminLinks.DELETE_ADMIN)
    @Operation(summary = "Delete an admin")
    public ResponseEntity<String> deleteAdmin(@PathVariable Long id) {
        boolean isDeleted = adminService.deleteAdmin(id);
        if (isDeleted) {
            return ResponseEntity.ok("Admin successfully deleted");
        } else {
            return ResponseEntity.status(404).body("Admin not found");
        }
    }
}
