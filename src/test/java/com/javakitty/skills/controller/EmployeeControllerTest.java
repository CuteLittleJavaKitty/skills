package com.javakitty.skills.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.javakitty.skills.dao.EmployeeRepository;
import com.javakitty.skills.model.dto.EmployeeDto;
import com.javakitty.skills.model.entity.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.junit.jupiter.Testcontainers;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Testcontainers
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ModelMapper modelMapper;


    @BeforeEach
    void initMocks() {
        MockitoAnnotations.initMocks(this);
    }


    @ParameterizedTest
    @MethodSource("com.javakitty.skills.arg.EmployeeArgs#employeeDtoSource")
    void addTest (EmployeeDto employeeDto) throws Exception {

        ObjectWriter objectWriter = objectMapper.writer().withDefaultPrettyPrinter();
        String request = objectWriter.writeValueAsString(employeeDto);

        byte[] content = mockMvc.perform(post("/employee/")
                .content(request)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andReturn()
                .getResponse()
                .getContentAsByteArray();

        EmployeeDto response = objectMapper.readValue(content, EmployeeDto.class);

        Assertions.assertEquals(employeeDto, response);
    }

    @ParameterizedTest
    @MethodSource("com.javakitty.skills.arg.EmployeeArgs#employeeSource")
    void getTest(Employee employee) throws Exception {
        long id = employeeRepository.save(employee).getId();

        byte[] content = mockMvc.perform(get("/employee/" + id))
                .andExpect(status().is(200))
                .andReturn()
                .getResponse()
                .getContentAsByteArray();

        EmployeeDto response = objectMapper.readValue(content, EmployeeDto.class);

        Assertions.assertEquals(modelMapper.map(employee, EmployeeDto.class), response);
    }

    @ParameterizedTest
    @ValueSource(longs = 1L)
    void getNotFoundTest(long id) throws Exception {
        employeeRepository.deleteAll();
        mockMvc.perform(get("/employee/" + id))
                .andExpect(status().is(404));
    }

    @ParameterizedTest
    @MethodSource("com.javakitty.skills.arg.EmployeeArgs#employeeSource")
    void deleteTest(Employee employee) throws Exception {
        long id = employeeRepository.save(employee).getId();
        mockMvc.perform(delete("/employee/" + id))
                .andExpect(status().is(204));
    }


    @ParameterizedTest
    @MethodSource("com.javakitty.skills.arg.EmployeeArgs#preUpdateEmployeeAndEmployeeDto")
    void updateTest(Employee employee, EmployeeDto employeeDto) throws Exception {
        long id = employeeRepository.save(employee).getId();
        ObjectWriter objectWriter = objectMapper.writer().withDefaultPrettyPrinter();
        String request = objectWriter.writeValueAsString(employeeDto);

        byte[] response = mockMvc.perform(put("/employee/" + id)
                .content(request)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andReturn()
                .getResponse().getContentAsByteArray();

        EmployeeDto responseDto = objectMapper.readValue(response, EmployeeDto.class);
        Assertions.assertEquals(employeeDto, responseDto);

    }

}
