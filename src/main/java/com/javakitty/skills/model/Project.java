package com.javakitty.skills.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "projects")
public class Project {

    @Column(name = "title")
    private String title;

    @Column(name = "direction_grade")
    private DirectionGrade directionGrade;

    @Column(name = "start_timestamp", updatable = false)
    private LocalDateTime startProject;
    @Column(name = "end_timestamp")
    private LocalDateTime endProject;

    public Project() {
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public DirectionGrade getDirectionGrade() {
        return directionGrade;
    }

    public void setDirectionGrade(DirectionGrade directionGrade) {
        this.directionGrade = directionGrade;
    }

    public LocalDateTime getStartProject() {
        return startProject;
    }

    public void setStartProject(LocalDateTime startProject) {
        this.startProject = startProject;
    }

    public LocalDateTime getEndProject() {
        return endProject;
    }

    public void setEndProject(LocalDateTime endProject) {
        this.endProject = endProject;
    }
}
