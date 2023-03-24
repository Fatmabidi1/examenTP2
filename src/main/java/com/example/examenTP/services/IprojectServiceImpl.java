package com.example.examenTP.services;

import com.example.examenTP.entities.Project;
import com.example.examenTP.entities.Sprint;
import com.example.examenTP.entities.User;
import com.example.examenTP.repositories.ProjectRepository;
import com.example.examenTP.repositories.SprintRepository;
import com.example.examenTP.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IprojectServiceImpl implements IprojectService{
    private ProjectRepository projectRepository;
    private UserRepository userRepository;
    private SprintRepository sprintRepository;
    @Override
    public Project addProject(Project project) {
        List<Sprint> list = project.getSprintList();
        for (Sprint s:list) {
s.setProject(project);
        }
        projectRepository.save(project);
        sprintRepository.saveAll(list);
        return project;

    }

    @Override
    public void assignProjectToUser(int projectId, int userId) {
        Project project= projectRepository.findById(projectId).orElse(null);
        User user= userRepository.findById(userId).orElse(null);
        project.getUserList().add(user);
        projectRepository.save(project);
    }

    @Override
    public void assignProjectToClient(int projectId, String firstName, String lastName) {
        User user= userRepository.findByFirstNameAndLastName(firstName,lastName);
        assignProjectToUser(projectId, user.getId());
    }
}
