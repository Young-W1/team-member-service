package com.etz.teamcrud.service.serviceImpl;


import com.etz.teamcrud.dto.ProjectRequest;
import com.etz.teamcrud.model.Projects;
import com.etz.teamcrud.model.Team;
import com.etz.teamcrud.repository.ProjectRepository;
import com.etz.teamcrud.repository.TeamRepository;
import com.etz.teamcrud.service.ProjectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;


@RequiredArgsConstructor
@Service
@Slf4j
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final TeamRepository teamRepository;
    @Override
    public ProjectRequest createNewProject(ProjectRequest project) {
        Projects projects = Projects.builder()
                .name(project.getName())
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


}
