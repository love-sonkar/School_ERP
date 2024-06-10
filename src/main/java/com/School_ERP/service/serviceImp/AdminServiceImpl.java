package com.School_ERP.service.serviceImp;

import com.School_ERP.dto.AdminDTO;
import com.School_ERP.entity.Admin;
import com.School_ERP.repository.AdminRepository;
import com.School_ERP.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public Admin saveAdmin(AdminDTO adminDTO) {
        Admin admin = new Admin();
        admin.setUserName(adminDTO.getUserName());
        admin.setPassword(adminDTO.getPassword());
        return adminRepository.save(admin);
    }

    @Override
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    @Override
    public Admin getAdminById(Long id) {
        Optional<Admin> admin = adminRepository.findById(id);
        return admin.orElse(null);
    }

    @Override
    public Admin updateAdmin(Long id, AdminDTO adminDTO) {
        Optional<Admin> optionalAdmin = adminRepository.findById(id);
        if (optionalAdmin.isPresent()) {
            Admin admin = optionalAdmin.get();
            admin.setUserName(adminDTO.getUserName());
            admin.setPassword(adminDTO.getPassword());
            return adminRepository.save(admin);
        }
        return null;
    }

    @Override
    public boolean deleteAdmin(Long id) {
        Admin admin = getAdminById(id);
        if (admin != null) {
            adminRepository.delete(admin);
            return true;
        }
        return false;
    }

    @Override
    public boolean checkLogin(String userName, String password) {
        Optional<Admin> admin = adminRepository.findByUserName(userName);
        return admin.isPresent() && admin.get().getPassword().equals(password);
    }
}
