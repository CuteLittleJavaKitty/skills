package com.javakitty.skills.model.dto;

import com.javakitty.skills.model.LanguageGrade;
import com.javakitty.skills.model.LanguageTitle;
import com.javakitty.skills.model.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LanguageDto {

    private LanguageTitle languageTitle;

    private LanguageGrade languageGrade;

    private Employee employee;

}
