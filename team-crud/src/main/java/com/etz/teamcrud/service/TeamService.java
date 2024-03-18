package com.etz.teamcrud.service;
import com.etz.teamcrud.apiResponse.ApiResponse;
import com.etz.teamcrud.dto.TeamRequest;
import com.etz.teamcrud.model.Team;
import jakarta.transaction.Transactional;

import java.util.List;

public interface TeamService {

    //to save new member
    Team saveNewMember(Team team);


    TeamRequest createNewTeam(TeamRequest request);

    TeamRequest disableTeamMember(TeamRequest request);

    @Transactional
    TeamRequest deleteTeamMember(TeamRequest request);

    Object deleteMemberById(Long id);

    Team findById(Long id);

    Object findAllTeam();


    // TeamRequest findAll(TeamRequest request);

}
