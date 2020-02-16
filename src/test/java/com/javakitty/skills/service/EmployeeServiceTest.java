package com.javakitty.skills.service;

import com.javakitty.skills.dao.EmployeeRepository;
import com.javakitty.skills.service.impl.EmployeeServiceImpl;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @Spy
    private ModelMapper modelMapper;

    @Mock
    private EmployeeRepository employeeRepository;

}
