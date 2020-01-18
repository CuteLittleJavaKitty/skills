package com.javakitty.skills.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "directions")
public class Direction {

    @Column(name = "direction_title")
    private DirectionTitle directionTitle; //enum

    @Column(name = "direction_grade")
    private DirectionGrade directionGrade; //enum || class

    @Column(name = "start_working_timestamp", updatable = false)
    private LocalDateTime startWorkingDate;

    @Column(name = "end_working_timestamp")
    private LocalDateTime endWorkingDate;

    @Column(name = "status")
    private boolean status;

    public Direction() {
    }

    public DirectionTitle getDirectionTitle() {
        return directionTitle;
    }

    public void setDirectionTitle(DirectionTitle directionTitle) {
        this.directionTitle = directionTitle;
    }

    public DirectionGrade getDirectionGrade() {
        return directionGrade;
    }

    public void setDirectionGrade(DirectionGrade directionGrade) {
        this.directionGrade = directionGrade;
    }

    public LocalDateTime getStartWorkingDate() {
        return startWorkingDate;
    }

    public void setStartWorkingDate(LocalDateTime startWorkingDate) {
        this.startWorkingDate = startWorkingDate;
    }

    public LocalDateTime getEndWorkingDate() {
        return endWorkingDate;
    }

    public void setEndWorkingDate(LocalDateTime endWorkingDate) {
        this.endWorkingDate = endWorkingDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
