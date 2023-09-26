package com.souldev.security.entities;


import javax.persistence.*;


@Entity
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String description;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Column(name="short_description")
    private String shortDescription;
    @Column(name="file_name")
    private String fileName;
    public Project() {
    }

    public Project(Integer id, String name, String description, String shortDescription,String fileName) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.shortDescription = shortDescription;
        this.fileName=fileName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }
}
