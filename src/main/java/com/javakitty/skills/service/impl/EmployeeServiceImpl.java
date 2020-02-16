package com.javakitty.skills.service.impl;


import com.javakitty.skills.dao.EmployeeRepository;
import com.javakitty.skills.model.dto.EmployeeDto;
import com.javakitty.skills.model.dto.ProjectDto;
import com.javakitty.skills.model.entity.Employee;
import com.javakitty.skills.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private ModelMapper modelMapper;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository,
                               ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ResponseEntity<EmployeeDto> save(EmployeeDto employeeDto) {

        Employee employee = DtoToEntity(employeeDto);
        return new ResponseEntity<>(EntityToDto(employeeRepository.save(employee)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<EmployeeDto> updateProjects(ProjectDto projectDto, long id) throws EntityNotFoundException {

        Employee employee = get(id);
        modelMapper.map(projectDto, employee);

        return new ResponseEntity<>(EntityToDto(employeeRepository.save(employee)), HttpStatus.OK);
    }

    @Override
    public void delete(long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public ResponseEntity<EmployeeDto> find(long id) {

        Employee employee = get(id);
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

    private Employee get(long id) {

        Optional<Employee> findEmployee = employeeRepository.findById(id);
        return findEmployee.orElseThrow(EntityNotFoundException::new);
    }


}
