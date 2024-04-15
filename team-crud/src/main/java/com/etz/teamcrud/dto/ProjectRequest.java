package com.etz.teamcrud.dto;

import com.etz.teamcrud.model.Projects;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
public class ProjectRequest {
    private String name;
    private String description;
    private Date dateCreated;

    public static ProjectRequest fromProjectRequest(Projects project){
        ProjectRequest projectRequest = new ProjectRequest();
        projectRequest.setName(project.getName());
        projectRequest.setDescription(project.getDescription());
        projectRequest.setDateCreated(new Date());
        return projectRequest;

    }
}
