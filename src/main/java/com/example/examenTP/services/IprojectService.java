package com.example.examenTP.services;

import com.example.examenTP.entities.Project;

public interface IprojectService {
    Project addProject(Project project);
    void assignProjectToUser (int projectId, int userId);
}
