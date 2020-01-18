package com.javakitty.skills.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "programming_languages")
public class ProgrammingLanguage {

    @Column(name = "title")
    private ProgrammingLanguageTitle programmingLanguageTitle; //enum

    @Column(name = "grade")
    private ProgrammingLanguageGrade programmingLanguageGrade;


    public ProgrammingLanguage() {
    }

    public ProgrammingLanguageTitle getProgrammingLanguageTitle() {
        return programmingLanguageTitle;
    }

    public void setProgrammingLanguageTitle(ProgrammingLanguageTitle programmingLanguageTitle) {
        this.programmingLanguageTitle = programmingLanguageTitle;
    }

    public ProgrammingLanguageGrade getProgrammingLanguageGrade() {
        return programmingLanguageGrade;
    }

    public void setProgrammongLanguageGrade(ProgrammingLanguageGrade programmingLanguageGrade) {
        this.programmingLanguageGrade = programmingLanguageGrade;
    }
}
