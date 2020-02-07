package com.javakitty.skills.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "languages")
@Data
public class Language {

    @Column(name = "title")
    private LanguageTitle languageTitle; // enum
    @Column(name = "grade")
    private LanguageGrade languageGrade; // enum || class

}
