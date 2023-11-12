package com.moaaz.bug.controller;


import com.moaaz.bug.model.Developer;
import com.moaaz.bug.service.implemenation.BugService;
import com.moaaz.bug.service.implemenation.DeveloperService;
import com.moaaz.bug.service.implemenation.MessageService;
import com.moaaz.bug.service.implemenation.TeseterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/developers")
public class DeveloperController {

    @Autowired
    private TeseterService teseterService;
    @Autowired
    private DeveloperService developerService;
    @Autowired
    private BugService bugService;

    @Autowired
    private MessageService messageService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Developer> addDeveloper(@RequestBody @Valid Developer developer) {
        return new ResponseEntity<>(developerService.addDeveloper(developer), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateDeveloper(@RequestBody @Valid Developer developer) {
        return new ResponseEntity<>(developerService.updateDeveloper(developer), HttpStatus.ACCEPTED);

    }

    @DeleteMapping("/delete/{developerId}")
    public ResponseEntity<Object> deleteDeveloper(@PathVariable int developerId) {

        developerService.deleteDeveloperById(developerId);
        return new ResponseEntity<>("Deleted Developer Success...", HttpStatus.ACCEPTED);
    }

    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<Developer> getAllDevelopers() {
        return developerService.getAllDevelopers();
    }

    @GetMapping("/{developerId}")
    public ResponseEntity<?> getDeveloperById(@PathVariable int developerId) {
        return new ResponseEntity<>(developerService.getDeveloperByIdOrElseThrowException(developerId),
                HttpStatus.OK);
    }


}
