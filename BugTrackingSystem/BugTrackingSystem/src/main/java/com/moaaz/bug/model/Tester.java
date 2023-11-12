package com.moaaz.bug.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Entity
@Table(name = "Tester")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Tester extends Person {

    private int bonus;
    @OneToMany(mappedBy = "tester")
    private List<Bug> bugs;


    @OneToMany(cascade = CascadeType.ALL)
    private List<Message> messages;

    @OneToMany(mappedBy = "tester")
    private List<Project> projects;


}
