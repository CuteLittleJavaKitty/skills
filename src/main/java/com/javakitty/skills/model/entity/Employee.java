package com.javakitty.skills.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Builder
@Table(name = "employees")
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_id_seq")
    @SequenceGenerator(name = "employee_id_seq", sequenceName = "employee_id_seq", allocationSize = 1)
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
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ProgrammingLanguage> programmingLanguage;

    @Column(name = "language")
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Language> language;

    @Column(name = "directions")
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Direction> directions;

    @Column(name = "projects")
    @ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private Set<Project> projects;


}


