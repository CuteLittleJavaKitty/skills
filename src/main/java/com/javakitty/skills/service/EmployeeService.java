package com.javakitty.skills.service;

import com.javakitty.skills.model.dto.EmployeeDto;
import com.javakitty.skills.model.dto.ProjectDto;
import com.javakitty.skills.model.entity.Employee;
import org.springframework.http.ResponseEntity;

public interface EmployeeService {

    ResponseEntity<EmployeeDto> save(EmployeeDto employeeDto);

    ResponseEntity<EmployeeDto> updateProjects(ProjectDto projectDto, long id);

    void delete(long id);

    ResponseEntity<EmployeeDto> find(long id);

    Employee DtoToEntity(EmployeeDto employeeDto);

    EmployeeDto EntityToDto(Employee employee);


}
