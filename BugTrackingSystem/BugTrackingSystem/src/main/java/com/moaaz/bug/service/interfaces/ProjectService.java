package com.moaaz.bug.service.interfaces;


import com.moaaz.bug.model.Project;

import java.util.List;

public interface ProjectService {

    public List<Project> getAllProjects();

    public Project addProject(Project project, int testerId, int developerId);

    public Project updateProject(Project project, int testerId, int developerId);

    public Project getProjectByIdOrThrowException(int id);

    public void deleteProjectById(int id);


}
