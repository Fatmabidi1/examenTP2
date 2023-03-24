package com.example.examenTP.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Table( name = "project")
@Entity
@Getter
@Setter
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id ;
    private String titre;
    private String description;
    @ManyToMany
    private List<User> userList;
    @OneToMany(mappedBy = "project")
    private List<Sprint> sprintList;
}
