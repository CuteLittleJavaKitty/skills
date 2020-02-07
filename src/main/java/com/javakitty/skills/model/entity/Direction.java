package com.javakitty.skills.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "directions")
@Data
public class Direction {

    @Column(name = "direction_title")
    private DirectionTitle directionTitle; //enum

    @Column(name = "direction_grade")
    private DirectionGrade directionGrade; //enum || class

    @Column(name = "start_working_timestamp")
    private LocalDateTime startWorkingDate;

    @Column(name = "end_working_timestamp")
    private LocalDateTime endWorkingDate;

    @Column(name = "status")
    private boolean status;

}
