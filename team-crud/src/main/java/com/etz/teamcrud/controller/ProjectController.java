package com.etz.teamcrud.controller;


import com.etz.teamcrud.dto.ProjectRequest;
import com.etz.teamcrud.model.Projects;
import com.etz.teamcrud.repository.ProjectRepository;
import com.etz.teamcrud.service.ProjectService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/project")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;
    private final ProjectRepository projectRepository;

    @PostMapping("")
    public ResponseEntity<ProjectRequest> createProject(@Valid @RequestBody ProjectRequest request){
        return ResponseEntity.ok(projectService.createNewProject(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Projects> findById(@PathVariable Long id){
        return ResponseEntity.ok(projectService.findById(id));
    }

    @GetMapping("/fetchAll")
    public List<Projects> getAllProjects(){  //List because it will list out the projects
        return projectRepository.findAll(); //to return all the projects in the db
    }


}
