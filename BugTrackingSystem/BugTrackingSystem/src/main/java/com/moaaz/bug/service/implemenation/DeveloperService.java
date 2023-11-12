package com.moaaz.bug.service.implemenation;

import com.moaaz.bug.model.Bug;
import com.moaaz.bug.model.Developer;
import com.moaaz.bug.model.types.BugStatus;
import com.moaaz.bug.model.types.Role;
import com.moaaz.bug.repository.DeveloperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class DeveloperService implements com.moaaz.bug.service.interfaces.DeveloperService {

    @Autowired
    private DeveloperRepository developerRepo;


    public Developer getDeveloperByEmailAndPassword(String email, String password) {
        return developerRepo.findByEmailAndPassword(email, password);
    }

    @Override
    public List<Developer> getAllDevelopers() {
        return developerRepo.findAll();
    }

    @Override
    public Developer addDeveloper(Developer developer) {
        developer.setRole(Role.Developer);
        return developerRepo.save(developer);
    }

    @Override
    public Developer updateDeveloper(Developer developer) {
        getDeveloperByIdOrElseThrowException(developer.getId());
        developer.setRole(Role.Developer);
        return developerRepo.save(developer);
    }


    public void deleteDeveloperById(int developerId) {
        getDeveloperByIdOrElseThrowException(developerId);
        developerRepo.deleteById(developerId);
    }

    @Override
    public void addBonusForDeveloper(int developerId) {
        Developer developer = getDeveloperByIdOrElseThrowException(developerId);
        developer.setBonus(developer.getBonus() + 1);
        updateDeveloper(developer);
    }

    @Override
    public Developer getDeveloperByIdOrElseThrowException(int id) {
        return developerRepo.findById(id).orElseThrow(
                () -> new NoSuchElementException("There Are No Developer With Id = " + id)
        );

    }

    public Developer getDeveloperByEmail(String email) {
        return developerRepo.findByEmail(email);
    }

    public Developer sortDeveloperBugs(Developer developer) {
        ArrayList<Bug> bugs = (ArrayList<Bug>) developer.getBugs();
        int len = bugs.size();
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (bugs.get(i).getStatus() == BugStatus.Close && bugs.get(j).getStatus() == BugStatus.Open) {
                    Bug temp = new Bug();
                    // put bug1 in temp;
                    temp.setId(bugs.get(i).getId());
                    temp.setName(bugs.get(i).getName());
                    temp.setType(bugs.get(i).getType());
                    temp.setPriority(bugs.get(i).getPriority());
                    temp.setLevel(bugs.get(i).getLevel());
                    temp.setDate(bugs.get(i).getDate());
                    temp.setStatus(bugs.get(i).getStatus());
                    temp.setSource(bugs.get(i).getSource());
                    temp.setDeveloper(bugs.get(i).getDeveloper());
                    temp.setTester(bugs.get(i).getTester());
                    temp.setProject(bugs.get(i).getProject());
                    // put bug2 in bug1
                    bugs.get(i).setId(bugs.get(j).getId());
                    bugs.get(i).setName(bugs.get(j).getName());
                    bugs.get(i).setType(bugs.get(j).getType());
                    bugs.get(i).setPriority(bugs.get(j).getPriority());
                    bugs.get(i).setLevel(bugs.get(j).getLevel());
                    bugs.get(i).setDate(bugs.get(j).getDate());
                    bugs.get(i).setStatus(bugs.get(j).getStatus());
                    bugs.get(i).setSource(bugs.get(j).getSource());
                    bugs.get(i).setDeveloper(bugs.get(j).getDeveloper());
                    bugs.get(i).setTester(bugs.get(j).getTester());
                    bugs.get(i).setProject(bugs.get(j).getProject());
                    // put temp in bug2
                    bugs.get(j).setId(temp.getId());
                    bugs.get(j).setName(temp.getName());
                    bugs.get(j).setType(temp.getType());
                    bugs.get(j).setPriority(temp.getPriority());
                    bugs.get(j).setLevel(temp.getLevel());
                    bugs.get(j).setDate(temp.getDate());
                    bugs.get(j).setStatus(temp.getStatus());
                    bugs.get(j).setSource(temp.getSource());
                    bugs.get(j).setDeveloper(temp.getDeveloper());
                    bugs.get(j).setTester(temp.getTester());
                    bugs.get(j).setProject(temp.getProject());
                }
            }

        }
        developer.setBugs(bugs);
        return developer;
    }
}
