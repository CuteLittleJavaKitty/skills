package com.javakitty.skills.model.entity;

import com.javakitty.skills.model.ProgrammingLanguageGrade;
import com.javakitty.skills.model.ProgrammingLanguageTitle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "programming_language_grades")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProgrammingLanguage   {

    @Id
    Long id;

    @Column(name = "title")
    private ProgrammingLanguageTitle programmingLanguageTitle;

    @Column(name = "grade")
    private ProgrammingLanguageGrade programmingLanguageGrade;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable=false)
    private Employee employee;

}
