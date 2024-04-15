package com.etz.teamcrud.repository;

import com.etz.teamcrud.dto.ProjectRequest;
import com.etz.teamcrud.dto.TeamRequest;
import com.etz.teamcrud.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

    Optional<Team>findByUsername(String username);
    Optional<Team>findByEmail(String email);
    Optional<Team>findByPhoneNumber(String phoneNumber);
//    void updateById(Long id);
    Optional<Object> findById(ProjectRequest id);
    //Optional<Team>findById(Long id);


}

