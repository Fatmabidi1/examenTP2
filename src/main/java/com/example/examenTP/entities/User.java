package com.example.examenTP.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Table( name = "user")
@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    private String pwd;
    private String fname;
    private String Iname;
@Enumerated
    private Role role;
    @ManyToMany(mappedBy = "userList")
private List<Project> projectList ;
    @OneToMany
    private List<Project> projectList1;

}
