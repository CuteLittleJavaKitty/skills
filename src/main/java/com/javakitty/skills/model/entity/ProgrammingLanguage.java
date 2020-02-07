package com.javakitty.skills.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "programming_languages")
@Data
public class ProgrammingLanguage {

    @Column(name = "title")
    private ProgrammingLanguageTitle programmingLanguageTitle; //enum

    @Column(name = "grade")
    private ProgrammingLanguageGrade programmingLanguageGrade; //enum || class

}
