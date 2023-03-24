package com.example.examenTP.services;

import com.example.examenTP.entities.Sprint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IsprintService {
    void addSprintAndAssignToProject(Sprint sprint, int idProject);
}
