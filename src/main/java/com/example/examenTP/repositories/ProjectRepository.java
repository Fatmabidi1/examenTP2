package com.example.examenTP.repositories;

import com.example.examenTP.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project,Integer> {
    List<Project> findByUserListFnameAndUserListIname(String fname,String Iname);
}
