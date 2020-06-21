package com.javakitty.skills.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeDto implements Serializable {

    private String lastName;

    private String firstName;

    private String secondName;

    private Boolean readyToBusinessTrip;

    private List<ProgrammingLanguageDto> programmingLanguage;

    private List<LanguageDto> language;

    private List<DirectionDto> directions;

    private List<ProjectDto> projects;

}
