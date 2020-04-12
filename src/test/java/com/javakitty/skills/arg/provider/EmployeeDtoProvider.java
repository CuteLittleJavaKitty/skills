package com.javakitty.skills.arg.provider;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import com.javakitty.skills.model.dto.*;

import java.io.IOException;
import java.io.InputStream;

public class EmployeeDtoProvider {

    public static EmployeeDto getEmployeeDto(String filename) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        try (InputStream inputStream = new ClassPathResource("data/" + filename).getInputStream()){
            EmployeeDto employeeDto = objectMapper.readValue(inputStream, EmployeeDto.class);
            return employeeDto;
        }
    }


}

