package com.javakitty.skills.model.entity;

import com.javakitty.skills.model.LanguageGrade;
import com.javakitty.skills.model.LanguageTitle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "language_grades")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Language {

    @Id
    Long id;

    @Column(name = "title")
    private LanguageTitle languageTitle;

    @Column(name = "grade")
    private LanguageGrade languageGrade;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

}
