package com.javakitty.skills.model.dto;

import com.javakitty.skills.model.ProgrammingLanguageGrade;
import com.javakitty.skills.model.ProgrammingLanguageTitle;
import com.javakitty.skills.model.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProgrammingLanguageDto {

    private ProgrammingLanguageTitle programmingLanguageTitle;

    private ProgrammingLanguageGrade programmingLanguageGrade;

    private Employee employee;

}
