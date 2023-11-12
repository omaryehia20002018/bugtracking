package com.moaaz.bug.service.interfaces;

import com.moaaz.bug.model.Admin;

import java.util.List;

public interface AdminService {

    public Admin addAdmin(Admin admin);

    public Admin checkAdminLogin(String email , String password);

    public List<Admin> getAllAdmins();

}
