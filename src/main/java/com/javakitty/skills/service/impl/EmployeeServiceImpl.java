package com.javakitty.skills.service.impl;

import com.javakitty.skills.model.exception.EmployeeNotFoundException;
import com.javakitty.skills.dao.EmployeeRepository;
import com.javakitty.skills.model.dto.EmployeeDto;
import com.javakitty.skills.model.entity.Employee;
import com.javakitty.skills.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;


@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository,
                               ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public EmployeeDto save(EmployeeDto employeeDto) {
        Employee employee = dtoToEntity(employeeDto);
        return entityToDto(employeeRepository.save(employee));
    }

    @Override
    public EmployeeDto create(EmployeeDto employeeDto) {
        return save(employeeDto);
    }

    @Override
    public EmployeeDto update(EmployeeDto employeeDto, long id) {
        Optional<Employee> found = employeeRepository.findById(id);
        Employee employee = found.orElseThrow(() -> {
            log.error("Employee with id {} not found", id);
            return new EmployeeNotFoundException();
        });
        modelMapper.map(employeeDto, employee);
        Employee updated = employeeRepository.save(employee);

        return entityToDto(updated);
    }

    @Override
    public void delete(long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public EmployeeDto find(long id) {
        Optional<Employee> found = employeeRepository.findById(id);
        Employee employee = found.orElseThrow(() -> {
            log.error("Employee with id {} not found", id);
            return new EmployeeNotFoundException();
        });

        return entityToDto(employee);
    }

    @Override
    public Employee dtoToEntity(EmployeeDto employeeDto) {
        return Objects.isNull(employeeDto) ? null : modelMapper.map(employeeDto, Employee.class);
    }

    @Override
    public EmployeeDto entityToDto(Employee employee) {
        return Objects.isNull(employee) ? null : modelMapper.map(employee, EmployeeDto.class);
    }


}
