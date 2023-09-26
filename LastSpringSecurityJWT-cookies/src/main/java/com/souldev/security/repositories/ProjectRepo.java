package com.souldev.security.repositories;

import com.souldev.security.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepo extends JpaRepository<Project,Integer> {
}
