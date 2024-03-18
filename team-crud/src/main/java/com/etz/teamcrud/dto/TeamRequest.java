package com.etz.teamcrud.dto;

import com.etz.teamcrud.enums.Status;
import com.etz.teamcrud.model.Projects;
import com.etz.teamcrud.model.Team;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
public class TeamRequest {
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String phoneNumber;
    private Status status;
    private Long id;



    public static TeamRequest fromTeamRequest(Team team){
        TeamRequest teamRequest = new TeamRequest();
        teamRequest.setFirstName(team.getFirstName());
        teamRequest.setLastName(team.getLastName());
        teamRequest.setUsername(team.getUsername());
        teamRequest.setEmail(team.getEmail());
        teamRequest.setPhoneNumber(team.getPhoneNumber());
        teamRequest.setStatus(team.getStatus());
        teamRequest.setId(team.getId());
        return teamRequest;
    }

}
