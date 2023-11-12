package com.moaaz.bug.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "Developer")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Developer extends Person {

    private int bonus;

    @OneToMany(mappedBy = "developer")
    private List<Bug> bugs;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Message> messages;

    @OneToMany(mappedBy = "developer")
    private List<Project> projects;

    public void addMessageToDeveloperMessages(Message message) {
        if (this.messages == null)
            this.messages = new ArrayList<>();
        this.messages.add(message);
    }


}
