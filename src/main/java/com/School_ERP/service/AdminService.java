package com.School_ERP.service;

import com.School_ERP.dto.AdminDTO;
import com.School_ERP.entity.Admin;

import java.util.List;

public interface AdminService {
    Admin saveAdmin(AdminDTO adminDTO);
    List<Admin> getAllAdmins();
    Admin getAdminById(Long id);
    Admin updateAdmin(Long id, AdminDTO adminDTO);
    boolean checkLogin(String userName, String password);
    boolean deleteAdmin(Long id);
}
