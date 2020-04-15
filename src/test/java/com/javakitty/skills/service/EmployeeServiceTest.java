package com.javakitty.skills.service;

import com.javakitty.skills.dao.EmployeeRepository;
import com.javakitty.skills.model.dto.EmployeeDto;
import com.javakitty.skills.model.entity.Employee;
import com.javakitty.skills.service.impl.EmployeeServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;

import javax.persistence.EntityNotFoundException;
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
        Employee employee = employeeService.DtoToEntity(employeeDto);

        Assertions.assertEquals(employeeDto, modelMapper.map(employee, EmployeeDto.class));
    }

    @ParameterizedTest
    @MethodSource("com.javakitty.skills.arg.EmployeeArgs#employeeSource")
    void entityToDtoTest(Employee employee) {
        EmployeeDto employeeDto = employeeService.EntityToDto(employee);

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
        ResponseEntity<EmployeeDto> update = employeeService.update(employeeDto, id);
        EmployeeDto response = update.getBody();

        EmployeeDto expected = new EmployeeDto();
        modelMapper.map(employee, expected);

        Assertions.assertEquals(expected, response);
    }

    @ParameterizedTest
    @MethodSource("com.javakitty.skills.arg.EmployeeArgs#employeeDtoAndId")
    void updateNegativeTest(EmployeeDto employeeDto, long id) {
        when(employeeRepository.findById(id)).thenReturn(Optional.empty());

        Assertions.assertThrows(EntityNotFoundException.class, ()->employeeService.update(employeeDto, id));
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

        ResponseEntity<EmployeeDto> found = employeeService.find(id);
        EmployeeDto foundDto = found.getBody();

        Assertions.assertEquals(modelMapper.map(employee, EmployeeDto.class), foundDto);
    }

    @ParameterizedTest
    @ValueSource(longs = 99L)
    void findNegativeTest(long id) {
        when(employeeRepository.findById(id)).thenReturn(Optional.empty());
        Assertions.assertThrows(EntityNotFoundException.class, () -> employeeService.find(id));
    }

}
