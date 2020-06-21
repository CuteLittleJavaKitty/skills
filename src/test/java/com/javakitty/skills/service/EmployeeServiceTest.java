package com.javakitty.skills.service;

import com.javakitty.skills.model.exception.EmployeeNotFoundException;
import com.javakitty.skills.dao.EmployeeRepository;
import com.javakitty.skills.model.dto.EmployeeDto;
import com.javakitty.skills.model.entity.Employee;
import com.javakitty.skills.service.impl.EmployeeServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.AdditionalAnswers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @Spy
    private ModelMapper modelMapper;

    @Mock
    private EmployeeRepository employeeRepository;

    @ParameterizedTest
    @MethodSource("com.javakitty.skills.arg.EmployeeArgs#employeeDtoSource")
    void dtoToEntityTest(EmployeeDto employeeDto) {
        Employee employee = employeeService.dtoToEntity(employeeDto);

        Assertions.assertEquals(employeeDto, modelMapper.map(employee, EmployeeDto.class));
    }

    @ParameterizedTest
    @MethodSource("com.javakitty.skills.arg.EmployeeArgs#employeeSource")
    void entityToDtoTest(Employee employee) {
        EmployeeDto employeeDto = employeeService.entityToDto(employee);

        Assertions.assertEquals(modelMapper.map(employee, EmployeeDto.class), employeeDto);
    }

    @ParameterizedTest
    @MethodSource("com.javakitty.skills.arg.EmployeeArgs#employeeDtoSource")
    void saveTest(EmployeeDto employeeDto) {
        when(employeeRepository.save(any(Employee.class))).thenAnswer(AdditionalAnswers.returnsFirstArg());
        EmployeeDto savedDto = employeeService.save(employeeDto);

        Assertions.assertEquals(employeeDto, savedDto);
    }

    @ParameterizedTest
    @MethodSource("com.javakitty.skills.arg.EmployeeArgs#employeeAndNewEmployeeDtoAndId")
    void updateTest(Employee employee, EmployeeDto employeeDto, long id) {
        when(employeeRepository.findById(id)).thenReturn(Optional.of(employee));
        when(employeeRepository.save(any(Employee.class))).thenAnswer(AdditionalAnswers.returnsFirstArg());
        EmployeeDto update = employeeService.update(employeeDto, id);
        EmployeeDto expected = new EmployeeDto();
        modelMapper.map(employee, expected);

        Assertions.assertEquals(expected, update);
    }

    @ParameterizedTest
    @MethodSource("com.javakitty.skills.arg.EmployeeArgs#employeeDtoAndId")
    void updateNegativeTest(EmployeeDto employeeDto, long id) {
        when(employeeRepository.findById(id)).thenReturn(Optional.empty());

        Assertions.assertThrows(EmployeeNotFoundException.class, () -> employeeService.update(employeeDto, id));
    }

    @ParameterizedTest
    @ValueSource(longs = 1L)
    void deleteTest(long id) {
        Assertions.assertDoesNotThrow(() -> employeeService.delete(id));
    }

    @ParameterizedTest
    @MethodSource("com.javakitty.skills.arg.EmployeeArgs#employeeAndIdSource")
    void findTest(Employee employee, long id) {
        when(employeeRepository.findById(id)).thenReturn(Optional.of(employee));
        EmployeeDto found = employeeService.find(id);

        Assertions.assertEquals(modelMapper.map(employee, EmployeeDto.class), found);
    }

    @ParameterizedTest
    @ValueSource(longs = 99L)
    void findNegativeTest(long id) {
        when(employeeRepository.findById(id)).thenReturn(Optional.empty());

        Assertions.assertThrows(EmployeeNotFoundException.class, () -> employeeService.find(id));
    }

}
