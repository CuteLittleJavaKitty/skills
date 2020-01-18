package com.javakitty.skills.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "languages")
public class Language {

    @Column(name = "title")
    LanguageTitle languageTitle; // enum
    @Column(name = "grade")
    LanguageGrade languageGrade; // enum || class


    public LanguageTitle getLanguageTitle() {
        return languageTitle;
    }

    public void setLanguageTitle(LanguageTitle languageTitle) {
        this.languageTitle = languageTitle;
    }

    public LanguageGrade getLanguageGrade() {
        return languageGrade;
    }

    public void setLanguageGrade(LanguageGrade languageGrade) {
        this.languageGrade = languageGrade;
    }



}
