package com.moaaz.bug.service.implemenation;

import com.moaaz.bug.model.Bug;
import com.moaaz.bug.model.Developer;
import com.moaaz.bug.model.types.BugStatus;
import com.moaaz.bug.service.interfaces.BugService;
import com.moaaz.bug.service.interfaces.DeveloperBugService;
import com.moaaz.bug.service.interfaces.DeveloperService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DeveloperBugServiceImp implements DeveloperBugService {

    @Autowired
    private BugService bugService;
    @Autowired
    private DeveloperService developerService;


    @Override
    public ResponseEntity<?> closeBugByDeveloper(int bugId, int developerId) {
        Bug bug = bugService.getBugById(bugId);
        Developer developer = developerService.getDeveloperByIdOrElseThrowException(developerId);
        // This Bug Isn't assigned to this developer.
        checkIfThisBugAssignedToThisDeveloperOrThrowException(bug, developer);
        // check if this bug already closed or not before adding any bonus for developer.
        checkIfBugIsAlreadyClosed(bug);
        // add bonus for developer and update it in db.
        developerService.addBonusForDeveloper(developerId);
        // close bug and update it in db.
        bugService.closeBugAndUpdateIt(bugId);
        return new ResponseEntity<>("Closed Success.", HttpStatus.ACCEPTED);

    }

    @SneakyThrows
    private void checkIfBugIsAlreadyClosed(Bug bug) {
        if (bug.getStatus() == BugStatus.Close)
            throw new Exception("This Bug Is Already Closed You'll Not Take Any Bonus \uD83D\uDE22");
    }

    @SneakyThrows
    private void checkIfThisBugAssignedToThisDeveloperOrThrowException(Bug bug, Developer developer) {
        if (!developer.getBugs().contains(bug))
            throw new Exception("This Bug Isn't Assigned To This Developer");
    }

}
