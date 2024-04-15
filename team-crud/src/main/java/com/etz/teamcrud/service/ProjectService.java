package com.etz.teamcrud.service;

import com.etz.teamcrud.dto.ProjectRequest;
import com.etz.teamcrud.model.Projects;

public interface ProjectService {
    ProjectRequest createNewProject(ProjectRequest project);

    Projects findById(Long id);

    Object findAllProjects();

    ProjectRequest updateProject(ProjectRequest request);

    //void updateProject(Long id, ProjectRequest request);

    Object updateProject(Long id, ProjectRequest request);
}
