package com.moaaz.bug.controller;

import com.moaaz.bug.model.Bug;
import com.moaaz.bug.service.interfaces.BugService;
import com.moaaz.bug.service.interfaces.MessageService;
import com.moaaz.bug.service.interfaces.TesterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/bugs")
@RestController
public class BugController {

    @Autowired
    private BugService bugService;
    @Autowired
    private TesterService testerService;
    @Autowired
    private MessageService messageService;

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllBugs() {
        return bugService.getAllBugs();
    }

    @PostMapping("/add/tester/{testerId}/developer/{developerId}/project/{projectId}")
    public ResponseEntity<?> addBug(@RequestBody @Valid Bug bug, @PathVariable int testerId,
                                    @PathVariable int developerId, @PathVariable int projectId) {
        // Add Bonus For Tester Because He Founded Bug.
        testerService.addBonusForTester(testerId);
        // send message for developer.
        messageService.sendMessageForDeveloper(testerId, developerId);
        return bugService.addBug(bug, testerId, developerId, projectId);
    }

    @PutMapping("/update/")
    public ResponseEntity<?> updateBug(@RequestBody @Valid Bug bug, @PathVariable int testerId,
                                       @PathVariable int developerId, @PathVariable int projectId) {
        return bugService.updateBug(bug, testerId, developerId, projectId);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteBugById(@PathVariable int bugId) {
        return bugService.deleteBugById(bugId);
    }

    @GetMapping("/{bugId}")
    public ResponseEntity<?> getBugById(@PathVariable int bugId) {
        return new ResponseEntity<>(bugService.getBugById(bugId), HttpStatus.OK);
    }

}
