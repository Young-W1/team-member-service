package com.etz.teamcrud.service.serviceImpl;


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
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class TeamServiceImpl implements TeamService {

    private final ProjectRepository projectRepository;
    private final TeamRepository teamRepository;
    @Override
    public Team saveNewMember(Team team) {
        return null;
    }

    @Override
    public TeamRequest createNewTeam(TeamRequest team) {
        log.info("team data {}", team);
        Team teamss = new Team();
        Projects project = projectRepository.findById(team.getId())
                .orElseThrow(() -> new RuntimeException("Project does not exist. Check it."));
        teamss.setProject(project);
        teamss.setFirstName(team.getFirstName());
        teamss.setUsername(team.getUsername());
        teamss.setLastName(team.getLastName());
        teamss.setEmail(team.getEmail());
        teamss.setPhoneNumber(team.getPhoneNumber());
        teamss.setStatus(Status.ACTIVE);
        teamss.setId(team.getId());
        teamRepository.save(teamss);
        //return teamss;
        return TeamRequest.fromTeamRequest(teamss);
    }

    @Override
    public TeamRequest disableTeamMember(TeamRequest team) {
        Team teamss = new Team();
        Projects project = projectRepository.findById(team.getId())
                .orElseThrow(() -> new EntityNotFoundException("Team Member not found"));

        teamss.setProject(project);
        teamss.setFirstName(team.getFirstName());
        teamss.setUsername(team.getUsername());
        teamss.setLastName(team.getLastName());
        teamss.setEmail(team.getEmail());
        teamss.setPhoneNumber(team.getPhoneNumber());
        teamss.setStatus(Status.DISABLED);
        teamss.setId(team.getId());
        teamRepository.save(teamss);
        return TeamRequest.fromTeamRequest(teamss);
    }

    @Override
    @Transactional
    public TeamRequest deleteTeamMember(TeamRequest team) {
        Team teamss = new Team();
//        Projects project = projectRepository.findById(team.getId())
//                .orElseThrow(() -> new EntityNotFoundException("Team Member not found"));

        Team teamx = teamRepository.findById(team.getId())
             .orElseThrow(() -> new EntityNotFoundException("Team Member not found"));


        teamss.setTeam(teamx);
        teamss.setFirstName(team.getFirstName());
        teamss.setUsername(team.getUsername());
        teamss.setLastName(team.getLastName());
        teamss.setEmail(team.getEmail());
        teamss.setPhoneNumber(team.getPhoneNumber());
        teamss.setStatus(Status.DELETED);
        teamss.setId(team.getId());
        //teamRepository.save(teamss);
        teamRepository.deleteById(team.getId());
        return TeamRequest.fromTeamRequest(teamss);
    }

    @Override
    public Object deleteMemberById(Long id) {
        Team teamx = teamRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Team Member not found"));
        teamRepository.deleteById(teamx.getId());
        return teamx;
    }

    @Override
    public Team findById(Long id) {
        log.info("Team Member's Id {}:", id);
        return teamRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("error returned"));
    }

    @Override
    public Object findAllTeam() {
        return teamRepository.findAll();
    }


}
