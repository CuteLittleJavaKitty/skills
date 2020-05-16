package com.javakitty.skills.service.impl;

import com.javakitty.skills.controller.exception.EmployeeNotFoundException;
import com.javakitty.skills.dao.EmployeeRepository;
import com.javakitty.skills.model.dto.EmployeeDto;
import com.javakitty.skills.model.entity.Employee;
import com.javakitty.skills.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public EmployeeDto save(EmployeeDto employeeDto) throws IllegalArgumentException {
        Employee employee = DtoToEntity(employeeDto);
        return EntityToDto(employeeRepository.save(employee));
    }

    @Override
    public ResponseEntity<EmployeeDto> add(EmployeeDto employeeDto) {
        return new ResponseEntity<>(save(employeeDto), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<EmployeeDto> update(EmployeeDto employeeDto, long id) {
        Optional<Employee> found = employeeRepository.findById(id);
        Employee employee = found.orElseThrow(EmployeeNotFoundException::new);

        modelMapper.map(employeeDto, employee);
        Employee updated = employeeRepository.save(employee);

        return new ResponseEntity<>(EntityToDto(updated), HttpStatus.OK);
    }

    @Override
    public void delete(long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public ResponseEntity<EmployeeDto> find(long id) {
        Optional<Employee> found = employeeRepository.findById(id);
        Employee employee = found.orElseThrow(EmployeeNotFoundException::new);

        return new ResponseEntity<>(EntityToDto(employee), HttpStatus.OK);
    }

    @Override
    public Employee DtoToEntity(EmployeeDto employeeDto) {
        return Objects.isNull(employeeDto) ? null : modelMapper.map(employeeDto, Employee.class);
    }

    @Override
    public EmployeeDto EntityToDto(Employee employee) {
        return Objects.isNull(employee) ? null : modelMapper.map(employee, EmployeeDto.class);
    }


}
