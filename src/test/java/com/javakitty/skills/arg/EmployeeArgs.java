package com.javakitty.skills.arg;

import org.junit.jupiter.params.provider.Arguments;

import java.io.IOException;
import java.util.stream.Stream;

import static com.javakitty.skills.arg.provider.EmployeeDtoProvider.getEmployeeDto;
import static com.javakitty.skills.arg.provider.EmployeeProvider.getEmployee;


public class EmployeeArgs {

    public static Stream<Arguments> employeeDtoSource() throws IOException {
        return Stream.of(Arguments.of(
                getEmployeeDto("employeeTest.json")
                ));
    }

    public static Stream<Arguments> employeeSource() throws IOException {
        return Stream.of(Arguments.of(getEmployee("employeeTest.json")));
    }

    public static Stream<Arguments> employeeAndIdSource() throws IOException {
        return Stream.of(Arguments.of(getEmployee("employeeTest.json"),
                1L));
    }

    public static Stream<Arguments> employeeAndNewEmployeeDtoAndId() throws IOException {
        return Stream.of(Arguments.of(
                getEmployee("preUpdateEmployeeTest.json"),
                getEmployeeDto("employeeTest.json"),
                1L));
    }

    public static Stream<Arguments> preUpdateEmployeeAndEmployeeDto() throws IOException {
        return Stream.of(Arguments.of(
                getEmployee("preUpdateEmployeeTest.json"),
                getEmployeeDto("employeeTest.json")));
    }

    public static Stream<Arguments> employeeDtoAndId() throws IOException {
        return Stream.of(Arguments.of(
                getEmployeeDto("employeeTest.json"),
                1L));
    }



}
