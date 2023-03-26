package com.example.examenTP.services;

import com.example.examenTP.entities.Project;
import com.example.examenTP.entities.Sprint;
import com.example.examenTP.entities.User;
import com.example.examenTP.repositories.ProjectRepository;
import com.example.examenTP.repositories.SprintRepository;
import com.example.examenTP.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
        User user= userRepository.findByFnameAndIname(firstName,lastName);
        assignProjectToUser(projectId, user.getId());
    }

    @Override
    public List<Project> getAllCurrentProject() {
        return projectRepository.findAll().stream().filter(project -> project.getSprintList().stream()
                .filter(sprint -> sprint.getStartDate().isAfter(LocalDate.now())).count()>0).toList();

    }

    @Override
    public List<Project> getProjectsByScrumMaster(String fName, String lName) {
        return projectRepository.findByUserListFnameAndUserListIname(fName,lName);

    }
    @Scheduled(fixedRate = 30000)
    @Override
    public List<Project> getNbrSprintByCurrentProject() {
        List<Project> p = getAllCurrentProject();
        for (Project prj: p) {
            System.out.println("nbre de sprint pour ce projet : "+ prj.getDescription()+" = "+prj.getSprintList().size());
        }
        return p;
    }


}
