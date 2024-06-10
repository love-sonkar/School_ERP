package com.School_ERP.controller;

import com.School_ERP.dto.AdminDTO;
import com.School_ERP.entity.Admin;
import com.School_ERP.links.AdminLinks;
import com.School_ERP.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(AdminLinks.ADMIN_LINK)
public class AdminController {

    @Autowired
    private AdminService adminService;

    // API to create a new admin
    @PostMapping(path = AdminLinks.ADD_ADMIN)
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
    public ResponseEntity<String> deleteAdmin(@PathVariable Long id) {
        boolean isDeleted = adminService.deleteAdmin(id);
        if (isDeleted) {
            return ResponseEntity.ok("Admin successfully deleted");
        } else {
            return ResponseEntity.status(404).body("Admin not found");
        }
    }
}
