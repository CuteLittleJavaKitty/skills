package com.javakitty.skills.arg.provider;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import com.javakitty.skills.model.dto.*;

import java.io.IOException;
import java.io.InputStream;

import static com.fasterxml.jackson.databind.SerializationFeature.FAIL_ON_EMPTY_BEANS;

public class EmployeeDtoProvider {

    public static EmployeeDto getEmployeeDto(String filename) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper().disable(FAIL_ON_EMPTY_BEANS);
        try (InputStream inputStream = new ClassPathResource("data/" + filename).getInputStream()){
            return objectMapper.readValue(inputStream, EmployeeDto.class);
        }
    }


}

