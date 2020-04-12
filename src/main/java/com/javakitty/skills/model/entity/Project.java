package com.javakitty.skills.model.entity;

import com.javakitty.skills.model.DirectionGrade;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Builder
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

    @ManyToMany(mappedBy = "projects")
    private List<Employee> employees;

}
