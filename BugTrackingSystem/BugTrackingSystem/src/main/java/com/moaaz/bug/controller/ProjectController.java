package com.moaaz.bug.controller;

import com.moaaz.bug.model.Project;
import com.moaaz.bug.service.interfaces.ProjectService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping("/add/tester/{testerId}/developer/{developerId}")
    public ResponseEntity<?> addProject(@RequestBody @Valid Project project,
                                        @PathVariable int testerId, @PathVariable int developerId) {

        return new ResponseEntity<>(projectService.addProject(project, testerId, developerId),
                HttpStatus.CREATED);

    }

    @PutMapping("/update/tester/{testerId}/developer/{developerId}")
    public ResponseEntity<?> updateProject(@RequestBody @Valid Project project,
                                           @PathVariable int testerId, @PathVariable int developerId) {

        return new ResponseEntity<>(projectService.updateProject(project, testerId, developerId),
                HttpStatus.ACCEPTED);

    }

    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<Project> getAllProjects() {
        return projectService.getAllProjects();
    }

    @DeleteMapping("/delete/{projectId}")
    public ResponseEntity<?> deleteProjectById(@PathVariable int projectId) {
        projectService.deleteProjectById(projectId);
        return new ResponseEntity<>("Deleted Success...", HttpStatus.ACCEPTED);
    }
}
