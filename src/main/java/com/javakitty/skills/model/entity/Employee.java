package com.javakitty.skills.model;

import com.javakitty.skills.model.security.roles.Role;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "employees")
@Data
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

    @Column(name = "programming_language")
    private List<ProgrammingLanguage> programmingLanguage;
    @Column(name = "language")
    private List<Language> language;

    @Column(name = "is_ready_to_business_trip")
    private Boolean isReadyToBusinessTrip;

    @Column(name = "directions")
    private List<Direction> directions;

    @Column(name = "projects")
    private List<Project> projects;

    @Column(name = "roles")
    private List<Role> roles;

}
