package com.souldev.security.controllers;

import com.souldev.security.entities.Project;
import com.souldev.security.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@CrossOrigin(origins="*")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @GetMapping("/projects")
    public List<Project> getAll(){
        return projectService.getAll();
    }

    @GetMapping("/projects/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id){
        try{
            Project project=projectService.getById(id);
            return new ResponseEntity<Project>(project, HttpStatus.OK);
        }catch(NoSuchElementException e){
            return new ResponseEntity<String >("Nuk ka element me kete id",HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/projects")
    public ResponseEntity<String> insert(@RequestBody Project project){
        if(project.getId()==null){
            projectService.save(project);
            return new ResponseEntity<String >("Projekti u shtua me sukses!",HttpStatus.OK);
        }//else
        return new ResponseEntity<String>("Ju nuk mund te percaktoni id e projektit",HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/projects/{id}")
    public ResponseEntity<?> update (@RequestBody Project project,@PathVariable Integer id){
        if(projectService.existById(id)){
            project.setId(id);
            projectService.save(project);
            return new ResponseEntity<String>("Projekti u modifikua me sukses!",HttpStatus.OK);
        }
        //else
            return new ResponseEntity<String >("Me vjene keq,por nuk u gjete asnje projekt me kete id!",HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/projects")
    public ResponseEntity<String> deleteAll(){
        projectService.deleteAll();
        return new ResponseEntity<String >("Projektet u fshine me sukses",HttpStatus.OK);
    }
    @DeleteMapping("/projects/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Integer id){
        if(projectService.existById(id)){
            String projectName=projectService.getById(id).getName();
            projectService.delete(id);
            return new ResponseEntity<String >("Projekti: "+projectName+" u fshi me sukses",HttpStatus.OK);
        } //else
            return new ResponseEntity<String >("Nuk ka asnje projekt me kete id",HttpStatus.NOT_FOUND);
    }

}
