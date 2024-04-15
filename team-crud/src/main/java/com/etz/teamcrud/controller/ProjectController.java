package com.etz.teamcrud.controller;


import com.etz.teamcrud.apiResponse.ApiResponse;
import com.etz.teamcrud.dto.ProjectRequest;
import com.etz.teamcrud.model.Projects;
import com.etz.teamcrud.repository.ProjectRepository;
import com.etz.teamcrud.service.ProjectService;
//import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/project")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping("")
    public ResponseEntity<ProjectRequest> createProject(@Valid @RequestBody ProjectRequest request){
        return ResponseEntity.ok(projectService.createNewProject(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Projects> findById(@PathVariable Long id){
        return ResponseEntity.ok(projectService.findById(id));
    }

    @GetMapping("/fetchAll")
    //List because it will list out the team members and their projects
    public ApiResponse<?> getProjects(){
        return ApiResponse.success(projectService.findAllProjects());
    }

    @PutMapping("/{id}")
    public ApiResponse<ProjectRequest> updateProject(@RequestBody ProjectRequest request, @PathVariable Long id) {
        return ApiResponse.updated(projectService.updateProject(id, request));
    }

}
