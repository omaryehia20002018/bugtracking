package com.moaaz.bug.repository;

import com.moaaz.bug.model.Developer;
import com.moaaz.bug.model.Project;
import com.moaaz.bug.model.Tester;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {

    public List<Project> findAllByDeveloper(Developer developer);

    public List<Project> findAllByTester(Tester tester);

}
