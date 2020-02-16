package com.javakitty.skills.model.dto;

import com.javakitty.skills.model.DirectionGrade;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDto {
    @NotNull
    @Null
    private String title;

    @NotNull
    @Null
    private DirectionGrade directionGrade;

    @NotNull
    @Null
    private LocalDateTime startProject;

    @NotNull
    @Null
    private LocalDateTime endProject;

}
