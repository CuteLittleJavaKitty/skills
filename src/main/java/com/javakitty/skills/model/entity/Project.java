package com.javakitty.skills.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "projects")
@Data
public class Project {

    @Column(name = "title")
    private String title;

    @Column(name = "direction_grade")
    private DirectionGrade directionGrade;

    @Column(name = "start_timestamp")
    private LocalDateTime startProject;

    @Column(name = "end_timestamp")
    private LocalDateTime endProject;

}
