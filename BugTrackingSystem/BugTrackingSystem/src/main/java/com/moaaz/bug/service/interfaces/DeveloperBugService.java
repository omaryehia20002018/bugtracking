package com.moaaz.bug.service.interfaces;

import org.springframework.http.ResponseEntity;

public interface DeveloperBugService {


    public ResponseEntity<?>closeBugByDeveloper(int bugId , int developerId);
}
