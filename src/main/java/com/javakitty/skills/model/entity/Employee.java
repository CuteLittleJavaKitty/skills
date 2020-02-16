package com.javakitty.skills.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "employees")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    @Column(name = "last_name")
    private String lastName;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "second_name")
    private String secondName;

    @Column(name = "programming_language")
    @OneToMany(cascade = CascadeType.ALL)
    private List<ProgrammingLanguage> programmingLanguage;

    @Column(name = "language")
    @OneToMany(cascade = CascadeType.ALL)
    private List<Language> language;

    @Column(name = "directions")
    @OneToMany(cascade = CascadeType.ALL)
    private List<Direction> directions;

    @Column(name = "is_ready_to_business_trip")
    private Boolean isReadyToBusinessTrip;

    @Column(name = "projects")
    @OneToMany(cascade = CascadeType.ALL)
    private List<Project> projects;

}


