package com.moaaz.bug.service.implemenation;

import com.moaaz.bug.model.Admin;
import com.moaaz.bug.model.Developer;
import com.moaaz.bug.model.Tester;
import com.moaaz.bug.repository.AdminRepository;
import com.moaaz.bug.repository.DeveloperRepository;
import com.moaaz.bug.repository.TesterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    AdminRepository adminRepo;
    @Autowired
    DeveloperRepository developerRepo;
    @Autowired
    TesterRepository testerRepo;

    public ResponseEntity<?> login(String email, String password) {
        Admin admin = adminRepo.findByEmailAndPassword(email, password);
        Developer developer = developerRepo.findByEmailAndPassword(email, password);
        Tester tester = testerRepo.findByEmailAndPassword(email, password);

        if (admin != null)
            return new ResponseEntity<>(admin, HttpStatus.ACCEPTED);
        else if (developer != null)
            return new ResponseEntity<>(developer, HttpStatus.ACCEPTED);
        else if (tester != null)
            return new ResponseEntity<>(tester, HttpStatus.ACCEPTED);
        return new ResponseEntity<>("Wrong In Email Or Password...", HttpStatus.BAD_REQUEST);
    }
}
