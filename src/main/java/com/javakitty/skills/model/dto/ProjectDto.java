package com.javakitty.skills.model.dto;

import com.javakitty.skills.model.DirectionGrade;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProjectDto {

    private String title;

    private DirectionGrade directionGrade;

}
