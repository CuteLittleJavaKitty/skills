package com.javakitty.skills.model.entity;

import com.javakitty.skills.model.DirectionGrade;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "projects")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "direction_grade")
    private DirectionGrade directionGrade;

    @Column(name = "start_timestamp")
    private LocalDateTime startProject;

    @Column(name = "end_timestamp")
    private LocalDateTime endProject;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

}
