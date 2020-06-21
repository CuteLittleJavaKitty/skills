package com.javakitty.skills.service;

import com.javakitty.skills.model.dto.EmployeeDto;
import com.javakitty.skills.model.dto.ProjectDto;
import com.javakitty.skills.model.entity.Employee;
import org.springframework.http.ResponseEntity;

public interface EmployeeService {

    EmployeeDto save(EmployeeDto employeeDto);

    EmployeeDto create(EmployeeDto employeeDto);

    EmployeeDto update(EmployeeDto employeeDto, long id);

    void delete(long id);

    EmployeeDto find(long id);

    Employee dtoToEntity(EmployeeDto employeeDto);

    EmployeeDto entityToDto(Employee employee);


}
