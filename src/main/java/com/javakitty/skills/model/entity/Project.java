package com.javakitty.skills.model.entity;

import com.javakitty.skills.model.DirectionGrade;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Builder
@Table(name = "projects")
@AllArgsConstructor
@NoArgsConstructor
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "project_id_seq")
    @SequenceGenerator(name = "project_id_seq", sequenceName = "project_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "direction_grade")
    private DirectionGrade directionGrade;

    @ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="projects")
    @EqualsAndHashCode.Exclude
    private Set<Employee> employees;

}
