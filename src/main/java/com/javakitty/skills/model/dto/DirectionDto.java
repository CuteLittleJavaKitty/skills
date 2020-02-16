package com.javakitty.skills.model.dto;

import com.javakitty.skills.model.DirectionGrade;
import com.javakitty.skills.model.DirectionTitle;
import com.javakitty.skills.model.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DirectionDto {

    private DirectionTitle directionTitle; //enum

    private DirectionGrade directionGrade; //enum || class

    private LocalDateTime startWorkingDate;

    private LocalDateTime endWorkingDate;

    private boolean status;

    private Employee employee;

}
