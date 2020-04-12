package com.javakitty.skills.model.dto;

import com.javakitty.skills.model.DirectionGrade;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDto {

    private String title;

    private DirectionGrade directionGrade;

}
