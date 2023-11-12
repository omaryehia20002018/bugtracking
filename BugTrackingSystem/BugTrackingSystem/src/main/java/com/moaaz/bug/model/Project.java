package com.moaaz.bug.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.moaaz.bug.model.types.ProjectStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "project")
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty(message = "Project Name Must Not Be Empty...")
    @NotNull(message = "Project Name Must Not Be Null...")
    private String name;
    @NotEmpty(message = "Description Must Not Be Empty...")
    @NotNull(message = "Description Must Not Be Null...")
    private String description;
    @NotEmpty(message = "Start Date Must Not Be Empty...")
    @NotNull(message = "Start Date Must Not Be Null...")
    private String startDate;
    @NotEmpty(message = "End Date Must Not Be Empty...")
    @NotNull(message = "End Date Must Not Be Null...")
    private String endDate;

    private ProjectStatus status;

    @ManyToOne
    @JsonIgnore
    private Developer developer;
    @ManyToOne
    @JsonIgnore
    private Tester tester;

    @OneToMany(mappedBy = "project")
    private List<Bug> bugs;

    public void addBugToProject(Bug bug) {
        this.bugs.add(bug);

    }
}
