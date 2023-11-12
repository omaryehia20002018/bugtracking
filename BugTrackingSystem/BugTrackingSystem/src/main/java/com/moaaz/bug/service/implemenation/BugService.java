package com.moaaz.bug.service.implemenation;

import com.moaaz.bug.model.Bug;
import com.moaaz.bug.model.types.BugStatus;
import com.moaaz.bug.repository.BugRepostiory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class BugService implements com.moaaz.bug.service.interfaces.BugService {

    @Autowired
    private BugRepostiory bugRepostiory;
    @Autowired
    private DeveloperService developerService;
    @Autowired
    private TeseterService teseterService;
    @Autowired
    private ProjectService projectService;

    @Override
    public ResponseEntity<?> getAllBugs() {
        return new ResponseEntity<>(bugRepostiory.findAll(), HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity<?> addBug(Bug bug, int testerId, int developerId, int projectId) {
        bug.setDate();
        bug.setStatus(BugStatus.Open);
        // set developer  ,  tester and project for this bug before saving it.
        setDeveloperAndTesterAndProjectForThisBug(bug, testerId, developerId, projectId);
        return new ResponseEntity<>(bugRepostiory.save(bug), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> updateBug(Bug bug, int testerId, int developerId, int projectId) {
        // At The first we check if this bug is already exist or know.
        getBugByIdOrThrowException(bug.getId());
        bug.setDate();
        // set developer and tester for this bug before saving it.
        setDeveloperAndTesterAndProjectForThisBug(bug, testerId, developerId, projectId);


        return new ResponseEntity<>(bugRepostiory.save(bug), HttpStatus.ACCEPTED);
    }

    @Override
    public Bug getBugById(int bugId) {
        return getBugByIdOrThrowException(bugId);
    }

    @Override
    public ResponseEntity<?> deleteBugById(int bugId) {
        getBugByIdOrThrowException(bugId);
        return new ResponseEntity<>("Deleted ", HttpStatus.ACCEPTED);
    }

    @Override
    public void closeBugAndUpdateIt(int bugId) {
        Bug bug = getBugById(bugId);
        bug.setStatus(BugStatus.Close);
        bugRepostiory.save(bug);
    }

    private Bug getBugByIdOrThrowException(int bugId) {
        return bugRepostiory.findById(bugId).orElseThrow(() ->
                new NoSuchElementException("There Are No Bug With Id = " + bugId));
    }

    private void setDeveloperAndTesterAndProjectForThisBug(Bug bug, int testerId, int developerId, int projectId) {

        bug.setTester(teseterService.getTesterByIdOrElseThrowException(testerId));
        bug.setDeveloper(developerService.getDeveloperByIdOrElseThrowException(developerId));
        bug.setProject(projectService.getProjectByIdOrThrowException(projectId));

    }


}
