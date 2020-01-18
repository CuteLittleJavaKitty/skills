package com.javakitty.skills.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "employees")
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
    @ManyToMany
    private List<ProgrammingLanguage> programmingLanguage;
    @Column(name = "language")
    @ManyToMany
    private List<Language> language;

    @Column(name = "is_ready_to_business_trip")
    private Boolean isReadyToBusinessTrip;

    @Column(name = "directions")
    @ManyToMany
    private List<Direction> directions;

    @Column(name = "projects")
    @ManyToMany
    private List<Project> projects;

    public Employee() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public List<ProgrammingLanguage> getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(List<ProgrammingLanguage> programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }

    public List<Language> getLanguage() {
        return language;
    }

    public void setLanguage(List<Language> language) {
        this.language = language;
    }

    public boolean isReadyToBusinessTrip() {
        return isReadyToBusinessTrip;
    }

    public void setReadyToBusinessTrip(boolean readyToBusinessTrip) {
        isReadyToBusinessTrip = readyToBusinessTrip;
    }

    public List<Direction> getDirections() {
        return directions;
    }

    public void setDirections(List<Direction> directions) {
        this.directions = directions;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

}
