package com.javakitty.skills.model.entity;

import com.javakitty.skills.model.ProgrammingLanguageGrade;
import com.javakitty.skills.model.ProgrammingLanguageTitle;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Builder
@Table(name = "programming_language_grades")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProgrammingLanguage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "title")
    private ProgrammingLanguageTitle programmingLanguageTitle;

    @Column(name = "grade")
    private ProgrammingLanguageGrade programmingLanguageGrade;

    @Column(name = "timestamp")
    private LocalDateTime timestamp;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

}
