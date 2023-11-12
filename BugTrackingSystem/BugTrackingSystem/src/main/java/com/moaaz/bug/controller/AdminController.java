package com.moaaz.bug.controller;

import com.moaaz.bug.model.Admin;
import com.moaaz.bug.service.interfaces.AdminService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admins")
public class AdminController {
    @Autowired
    private AdminService adminService;


    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Admin> addDeveloper(@RequestBody @Valid Admin admin) throws HttpMessageNotReadableException {
        adminService.addAdmin(admin);
        return new ResponseEntity<>(admin, HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<Admin> getAllAdmins() {
        return adminService.getAllAdmins();
    }

}
