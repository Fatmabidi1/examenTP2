package com.example.examenTP.services;

import com.example.examenTP.entities.Project;
import com.example.examenTP.entities.Sprint;
import com.example.examenTP.repositories.ProjectRepository;
import com.example.examenTP.repositories.SprintRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IsprintServiceImpl implements IsprintService{
    private SprintRepository sprintRepository;
    private ProjectRepository projectRepository;
    @Override
    public void addSprintAndAssignToProject(Sprint sprint, int idProject) {
        Project project = projectRepository.findById(idProject).orElse(null);
        sprint.setProject(project);
        sprintRepository.save(sprint);

    }
}
