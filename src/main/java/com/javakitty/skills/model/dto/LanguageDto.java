package com.javakitty.skills.model.dto;

import com.javakitty.skills.model.LanguageGrade;
import com.javakitty.skills.model.LanguageTitle;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LanguageDto {

    private LanguageTitle languageTitle;

    private LanguageGrade languageGrade;

    private LocalDateTime timestamp;


}
