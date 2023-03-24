package com.example.examenTP.repositories;

import com.example.examenTP.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project,Integer> {
    
}
