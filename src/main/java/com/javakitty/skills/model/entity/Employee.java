package com.javakitty.skills.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Builder
@Table(name = "employees")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "last_name")
    private String lastName;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "second_name")
    private String secondName;

    @Column(name = "ready_to_business_trip")
    private Boolean readyToBusinessTrip;

    @Column(name = "programming_language")
    @OneToMany(cascade = CascadeType.ALL)
    private List<ProgrammingLanguage> programmingLanguage;

    @Column(name = "language")
    @OneToMany(cascade = CascadeType.ALL)
    private List<Language> language;

    @Column(name = "directions")
    @OneToMany(cascade = CascadeType.ALL)
    private List<Direction> directions;


    @Column(name = "projects")
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "employee_projects",
            joinColumns = { @JoinColumn(name = "employee_id") },
            inverseJoinColumns = { @JoinColumn(name = "project_id") }
    )
    private List<Project> projects;

}


