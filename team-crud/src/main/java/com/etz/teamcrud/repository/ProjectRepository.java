package com.etz.teamcrud.repository;

import com.etz.teamcrud.model.Projects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ProjectRepository extends JpaRepository<Projects, Long> {
    Optional<Projects> findByName(String name);

    boolean deleteProjectById(Long id);
}
