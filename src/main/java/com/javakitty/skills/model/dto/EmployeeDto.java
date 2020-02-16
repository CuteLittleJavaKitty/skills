package com.javakitty.skills.model.dto;

import com.javakitty.skills.model.mark.AddEmployee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {

    @NotNull(groups = {AddEmployee.class})
    private String lastName;
    @NotNull(groups = {AddEmployee.class})
    private String firstName;
    @NotNull(groups = {AddEmployee.class})
    private String secondName;
    @Null(groups = {AddEmployee.class})
    private Boolean isReadyToBusinessTrip;


}
