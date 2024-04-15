package com.etz.teamcrud.service;
import com.etz.teamcrud.dto.ProjectRequest;
import com.etz.teamcrud.dto.TeamRequest;
import com.etz.teamcrud.model.Team;

import javax.transaction.Transactional;
//import jakarta.transaction.Transactional;

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

    Object updateTeamMember(TeamRequest request, Long id);
}
