package com.javakitty.skills.model.dto;

import com.javakitty.skills.model.ProgrammingLanguageGrade;
import com.javakitty.skills.model.ProgrammingLanguageTitle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProgrammingLanguageDto {

    private ProgrammingLanguageTitle programmingLanguageTitle;

    private ProgrammingLanguageGrade programmingLanguageGrade;

    private LocalDateTime timestamp;

}
