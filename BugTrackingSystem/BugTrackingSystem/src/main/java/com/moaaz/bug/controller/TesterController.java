package com.moaaz.bug.controller;


import com.moaaz.bug.model.Tester;
import com.moaaz.bug.service.implemenation.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/testers")
public class TesterController {

    @Autowired
    private TeseterService testerService;

    @Autowired
    private BugService bugService;
    @Autowired
    private ProjectService projectService;

    @Autowired
    private DeveloperService developerService;

    @Autowired
    private MessageService messageService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Tester> addTester(@RequestBody @Valid Tester tester) {

        return new ResponseEntity<>(testerService.addTester(tester), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Object> updateTester(@RequestBody @Valid Tester tester) {
        testerService.updateTester(tester);
        return new ResponseEntity<>(tester, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{testerId}")
    public ResponseEntity<Object> deleteTester(@PathVariable int testerId) {
        testerService.deleteTesterById(testerId);
        return new ResponseEntity<>("Deleted Tester Success...", HttpStatus.ACCEPTED);
    }

    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<Tester> getAllTesters() {
        return testerService.getAllTesters();
    }


    @GetMapping("/{testerId}")
    public ResponseEntity<?> getTesterById(@PathVariable int testerId) {
        return new ResponseEntity<>(testerService.getTesterByIdOrElseThrowException(testerId), HttpStatus.OK);
    }
}
