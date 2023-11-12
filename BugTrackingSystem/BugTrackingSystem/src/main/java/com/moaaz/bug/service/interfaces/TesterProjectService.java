package com.moaaz.bug.service.interfaces;

import com.moaaz.bug.model.Project;

import java.util.List;

public interface TesterProjectService {

    public List<Project> getAllProjectsForThisTester(int testerId);
}
