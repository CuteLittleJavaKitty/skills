package com.javakitty.skills.service;

import com.javakitty.skills.model.dto.EmployeeDto;

public interface EmployeeService {

    EmployeeDto save(EmployeeDto employeeDto);

    EmployeeDto create(EmployeeDto employeeDto);

    EmployeeDto update(EmployeeDto employeeDto, long id);

    void delete(long id);

    EmployeeDto find(long id);
}
