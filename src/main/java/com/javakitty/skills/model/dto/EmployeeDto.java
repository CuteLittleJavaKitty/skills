package com.javakitty.skills.model.dto;

import com.javakitty.skills.model.entity.*;
import com.javakitty.skills.model.mark.AddProject;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {

    @NotNull
    @Null(groups = {AddProject.class})
    private String lastName;
    @NotNull
    @Null(groups = {AddProject.class})
    private String firstName;
    @NotNull
    @Null(groups = {AddProject.class})
    private String secondName;
    @NotNull
    @Null(groups = {AddProject.class})
    private List<ProgrammingLanguage> programmingLanguage;
    @NotNull
    @Null(groups = {AddProject.class})
    private List<Language> language;
    @NotNull
    @Null(groups = {AddProject.class})
    private Boolean isReadyToBusinessTrip;
    @NotNull
    @Null(groups = {AddProject.class})
    private List<Direction> directions;
    @NotNull(groups = {AddProject.class})
    @Null
    private List<Project> projects;


}
