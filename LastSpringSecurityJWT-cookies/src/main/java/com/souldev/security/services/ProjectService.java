package com.souldev.security.services;


import com.souldev.security.entities.Project;
import com.souldev.security.repositories.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepo projectRepo;

    public List<Project> getAll(){
        return projectRepo.findAll();
    }

    public Project getById(Integer id){
        try {
            Project project=projectRepo.findById(id).get();
            return project;
        }catch(NoSuchElementException e){
            throw new NoSuchElementException("S'ka element me kete id");
        }
    }
    public boolean existById(Integer id){
        return projectRepo.existsById(id);
    }

    public void save(Project project){
        projectRepo.save(project);
    }


    public void delete(Integer id){
        projectRepo.deleteById(id);
    }
    public void deleteAll(){
        projectRepo.deleteAll();
    }
}
