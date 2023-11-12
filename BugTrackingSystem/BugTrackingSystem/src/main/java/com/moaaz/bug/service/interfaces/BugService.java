package com.moaaz.bug.service.interfaces;

import com.moaaz.bug.model.Bug;
import org.springframework.http.ResponseEntity;

public interface BugService {

    public ResponseEntity<?> getAllBugs();

    public ResponseEntity<?>addBug(Bug bug , int testerId , int developerId , int projectId);

    public ResponseEntity<?> updateBug(Bug bug  , int testerId , int developerId  , int projectId);

    public Bug getBugById(int id );

    public ResponseEntity<?> deleteBugById(int id);

    public void closeBugAndUpdateIt(int bugId);



}
