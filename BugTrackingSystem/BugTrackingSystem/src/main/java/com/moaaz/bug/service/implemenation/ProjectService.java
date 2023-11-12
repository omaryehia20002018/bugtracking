package com.moaaz.bug.service.implemenation;

import com.moaaz.bug.model.Project;
import com.moaaz.bug.repository.ProjectRepository;
import com.moaaz.bug.service.interfaces.DeveloperService;
import com.moaaz.bug.service.interfaces.TesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProjectService implements com.moaaz.bug.service.interfaces.ProjectService {

    @Autowired
    private ProjectRepository projectRepo;
    @Autowired
    private DeveloperService developerService;
    @Autowired
    private TesterService testerService;

    @Override
    public List<Project> getAllProjects() {
        return projectRepo.findAll();
    }

    @Override
    public Project addProject(Project project, int testerId, int developerId) {
        setTesterAndDeveloperForProject( project, testerId, developerId);
        return projectRepo.save(project);
    }

    @Override
    public Project updateProject(Project project , int testerId , int developerId) {
        getProjectByIdOrThrowException(project.getId());
        setTesterAndDeveloperForProject(project , testerId , developerId);
        return projectRepo.save(project);
    }

    @Override
    public void deleteProjectById(int projectId) {
        getProjectByIdOrThrowException(projectId);
        projectRepo.deleteById(projectId);

    }

    @Override
    public Project getProjectByIdOrThrowException(int projectId) {
        return projectRepo.findById(projectId).orElseThrow(() ->
                new NoSuchElementException("There Are No Project With Id = " + projectId));
    }

    private void setTesterAndDeveloperForProject(Project project, int testerId, int developerId) {
        project.setTester(testerService.getTesterByIdOrElseThrowException(testerId));
        project.setDeveloper(developerService.getDeveloperByIdOrElseThrowException(developerId));
    }
}
