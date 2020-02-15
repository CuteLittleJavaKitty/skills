package com.javakitty.skills.model.entity;

import com.javakitty.skills.model.DirectionGrade;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "projects")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long project_id;

    @Column(name = "title")
    private String title;

    @Column(name = "direction_grade")
    private DirectionGrade directionGrade;

    @Column(name = "start_timestamp")
    private LocalDateTime startProject;

    @Column(name = "end_timestamp")
    private LocalDateTime endProject;

    @ManyToOne
    @JoinColumn(name="employee_id", nullable=false)
    private Employee employee;

}
