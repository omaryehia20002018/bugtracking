package com.moaaz.bug.controller;


import com.moaaz.bug.service.implemenation.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/BugTrackingSystem")
public class LoginController {

    @Autowired
    private LoginService loginService;


    @PostMapping("/login")
    public ResponseEntity<?> loginPost(@RequestParam String email, @RequestParam String password) {

        return loginService.login(email, password);

    }


}
