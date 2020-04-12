package com.javakitty.skills.arg.provider;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javakitty.skills.model.dto.EmployeeDto;
import com.javakitty.skills.model.entity.Employee;
import org.modelmapper.ModelMapper;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;

import static com.fasterxml.jackson.databind.SerializationFeature.FAIL_ON_EMPTY_BEANS;

public class EmployeeProvider {

    public static Employee getEmployee(String filename) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper().disable(FAIL_ON_EMPTY_BEANS);
        ModelMapper modelMapper = new ModelMapper();
        try (InputStream inputStream = new ClassPathResource("data/" + filename).getInputStream()){
            EmployeeDto employeeDto = objectMapper.readValue(inputStream, EmployeeDto.class);
            return modelMapper.map(employeeDto, Employee.class);

        }
    }
}
