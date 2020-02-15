package com.javakitty.skills.service;

import com.javakitty.skills.model.dto.EmployeeDto;
import com.javakitty.skills.model.entity.Employee;
import org.springframework.http.ResponseEntity;

public interface EmployeeService {

    ResponseEntity<EmployeeDto> save(Employee employee);
    ResponseEntity<EmployeeDto> updateProjects(EmployeeDto employeeDTO, long id);
    void delete(long id);
    ResponseEntity<EmployeeDto> find(long id);


}
