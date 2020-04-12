package com.javakitty.skills.model.entity;

import com.javakitty.skills.model.LanguageGrade;
import com.javakitty.skills.model.LanguageTitle;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Builder
@Table(name = "language_grades")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "title")
    private LanguageTitle languageTitle;

    @Column(name = "grade")
    private LanguageGrade languageGrade;

    @Column(name = "timestamp")
    private LocalDateTime timestamp;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

}
