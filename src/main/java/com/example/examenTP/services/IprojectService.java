package com.example.examenTP.services;

import com.example.examenTP.entities.Project;

import java.util.List;

public interface IprojectService {
    Project addProject(Project project);
    void assignProjectToUser (int projectId, int userId);
    void assignProjectToClient(int projectId, String firstName, String lastName);
    List<Project> getAllCurrentProject() ;
    List<Project> getProjectsByScrumMaster(String fName, String lName);
}
