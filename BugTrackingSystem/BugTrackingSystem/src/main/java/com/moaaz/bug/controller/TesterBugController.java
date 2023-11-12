package com.moaaz.bug.controller;

import com.moaaz.bug.model.Tester;
import com.moaaz.bug.service.implemenation.TeseterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/testerBug")
@RestController
public class TesterBugController {

    @Autowired
    private TeseterService teseterService;

    @GetMapping("/getAllBugs/{tester_id}")
    public ResponseEntity<Object> getAllBugsForTester(@PathVariable int tester_id) {
        Tester tester = teseterService.getTesterByIdOrElseThrowException(tester_id);

        return new ResponseEntity<>(tester.getBugs(), HttpStatus.OK);
    }

}
