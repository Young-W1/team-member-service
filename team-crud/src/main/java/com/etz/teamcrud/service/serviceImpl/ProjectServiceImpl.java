package com.etz.teamcrud.service.serviceImpl;


import com.etz.teamcrud.dto.ProjectRequest;
import com.etz.teamcrud.model.Projects;
import com.etz.teamcrud.repository.ProjectRepository;
import com.etz.teamcrud.service.ProjectService;
//import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Date;


@RequiredArgsConstructor
@Service
@Slf4j
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    @Override
    public ProjectRequest createNewProject(ProjectRequest project) {
        Projects projects = Projects.builder()
                .name(project.getName())
                .dateCreated(new Date())
                .description(project.getDescription()).build();

        projectRepository.save(projects);

        //return ProjectRequest.fromProjectRequest(projects);
        return ProjectRequest.fromProjectRequest(projects);
    }

    @Override
    public Projects findById(Long id) {
        log.info("Project Id {}", id);
        return projectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("error returned"));
    }

    @Override
    public Object findAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public ProjectRequest updateProject(ProjectRequest request) {
        return null;
    }

    @Override
    public Object updateProject(Long id, ProjectRequest request) {

        Projects project = projectRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Project not found"));
        project.setName(request.getName());
        project.setDescription(request.getDescription());
        project.setDateCreated(request.getDateCreated());
        projectRepository.save(project);
        return ProjectRequest.fromProjectRequest(project);

    }


}
