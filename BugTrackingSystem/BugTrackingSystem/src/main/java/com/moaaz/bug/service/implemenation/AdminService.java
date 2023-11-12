package com.moaaz.bug.service.implemenation;

import com.moaaz.bug.model.Admin;
import com.moaaz.bug.model.types.Role;
import com.moaaz.bug.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService implements com.moaaz.bug.service.interfaces.AdminService {
    @Autowired
    private AdminRepository adminRepo;


    @Override
    public Admin addAdmin(Admin admin) {
        admin.setRole(Role.Admin);
        return adminRepo.save(admin);
    }

    @Override
    public Admin checkAdminLogin(String email, String password) {
        return adminRepo.findByEmailAndPassword(email, password);
    }

    @Override
    public List<Admin> getAllAdmins() {
        return adminRepo.findAll();
    }

    public Admin getAdminByEmail(String email) {
        return adminRepo.findByEmail(email);
    }


}
