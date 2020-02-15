package com.javakitty.skills.service.impl;

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

import javax.persistence.EntityNotFoundException;
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
    public ResponseEntity<EmployeeDto> save(Employee employee) {
        //TODO: if exists - ?
        return new ResponseEntity<>(entityToDto(employeeRepository.save(employee)), HttpStatus.OK);
    }

    private EmployeeDto entityToDto(Employee employee) {
        return this.modelMapper.map(employee, EmployeeDto.class);
    }

    @Override
    public ResponseEntity<EmployeeDto> updateProjects (EmployeeDto employeeDto, long id) throws EntityNotFoundException {

        Employee employee = get(id);
        employee.setProjects(employeeDto.getProjects());

        return save(employee);
    }

    @Override
    public void delete(long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public ResponseEntity<EmployeeDto> find(long id) {

        Employee employee = get(id);
        return new ResponseEntity<>(entityToDto(employee), HttpStatus.OK);
    }

    private Employee get(long id) {

        Optional<Employee> findEmployee = employeeRepository.findById(id);
        return findEmployee.orElseThrow(EntityNotFoundException::new);
    }


}
