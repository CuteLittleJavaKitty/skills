package com.javakitty.skills.model.dto;

import com.javakitty.skills.model.DirectionGrade;
import com.javakitty.skills.model.DirectionTitle;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DirectionDto {

    private DirectionTitle directionTitle;

    private DirectionGrade directionGrade;

    private LocalDateTime startWorkingDate;

    private LocalDateTime endWorkingDate;

    private boolean status;

}
