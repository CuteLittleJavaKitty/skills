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
@Data
@Builder
@Table(name = "language_grades")
@AllArgsConstructor
@NoArgsConstructor
public class Language {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "language_id_seq")
    @SequenceGenerator(name = "language_id_seq", sequenceName = "language_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "title")
    private LanguageTitle languageTitle;

    @Column(name = "grade")
    private LanguageGrade languageGrade;

    @Column(name = "timestamp")
    private LocalDateTime timestamp;

    @ManyToOne(cascade = CascadeType.ALL)
    private Employee employee;

}
