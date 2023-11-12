package com.moaaz.bug.service.interfaces;

import com.moaaz.bug.model.Developer;
import com.moaaz.bug.model.Message;

import java.util.List;

public interface DeveloperService {

    public Developer addDeveloper(Developer developer);
    public Developer updateDeveloper(Developer developer);
    public void deleteDeveloperById(int developerId);
    public Developer getDeveloperByIdOrElseThrowException(int developerId);
    public List<Developer> getAllDevelopers();

    public void addBonusForDeveloper(int developerId);

//    public void addMessage(Message message);
}
