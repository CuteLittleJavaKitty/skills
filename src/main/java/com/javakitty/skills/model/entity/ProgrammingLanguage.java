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
@Data
@Builder
@Table(name = "programming_language_grades")
@AllArgsConstructor
@NoArgsConstructor
public class ProgrammingLanguage {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "programming_language_id_seq")
    @SequenceGenerator(name = "programming_language_id_seq", sequenceName = "programming_language_id_seq", allocationSize = 1)
    Long id;

    @Column(name = "title")
    private ProgrammingLanguageTitle programmingLanguageTitle;

    @Column(name = "grade")
    private ProgrammingLanguageGrade programmingLanguageGrade;

    @Column(name = "timestamp")
    private LocalDateTime timestamp;

    @ManyToOne(cascade = CascadeType.ALL)
    private Employee employee;

}
