package com.moaaz.bug.controller;

import com.moaaz.bug.service.interfaces.BugService;
import com.moaaz.bug.service.interfaces.DeveloperBugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/developerBugs")
public class DeveloperBugController {

    @Autowired
    private DeveloperBugService developerBugService;

    @GetMapping("/closeBug/{bugId}/developer/{developerId}")
    public ResponseEntity<?> closeBugByDeveloper(@PathVariable int bugId, @PathVariable int developerId) {
        return developerBugService.closeBugByDeveloper(bugId, developerId);
    }
}
