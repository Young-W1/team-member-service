package com.etz.teamcrud.controller;

import com.etz.teamcrud.apiResponse.ApiResponse;
import com.etz.teamcrud.dto.TeamRequest;
import com.etz.teamcrud.enums.Status;
import com.etz.teamcrud.model.Projects;
import com.etz.teamcrud.model.Team;
import com.etz.teamcrud.repository.ProjectRepository;
import com.etz.teamcrud.repository.TeamRepository;
import com.etz.teamcrud.service.TeamService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/team")
@RequiredArgsConstructor
public class TeamController {

    private final TeamService teamService;
    private final TeamRepository teamRepository;
    private final ProjectRepository projectRepository;

    @GetMapping("")
    public String getPage(){
        return "Welcome to our team, Corporate Solutions!";
    }

//    @PostMapping("/create")
//    public ResponseEntity<Team> createNewMember(@RequestBody TeamRequest request){
//        return ResponseEntity.ok(teamService.createNewTeam(request));
//    }
    @PostMapping("/create")
    public ApiResponse<TeamRequest> createNewMember(@RequestBody TeamRequest request){
        return ApiResponse.success(teamService.createNewTeam(request));
    }

    @GetMapping("/team-members")
    //List because it will list out the team members and their projects
    public ApiResponse<?> getMembers(){
        return ApiResponse.success(teamService.findAllTeam());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Team> findById(@PathVariable Long id){ //get member by their id
        return ResponseEntity.ok(teamService.findById(id));
    }

    @PostMapping("/{id}/disable")
    public ApiResponse<TeamRequest> disableTeamMember(@PathVariable Long id, @RequestBody TeamRequest request) {

        return ApiResponse.disabled(teamService.disableTeamMember(request));

    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deleteMember(@PathVariable Long id) {
         ApiResponse.deleted(teamService.deleteMemberById(id));
    }
}
