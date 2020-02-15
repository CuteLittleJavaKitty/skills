package com.javakitty.skills.controller;

import com.javakitty.skills.model.dto.EmployeeDto;
import com.javakitty.skills.model.entity.Employee;
import com.javakitty.skills.model.mark.AddProject;
import com.javakitty.skills.service.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

    private EmployeeServiceImpl service;

    public void setService(@Autowired EmployeeServiceImpl service) {
        this.service = service;
    }

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces =
            MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeDto> create(@RequestBody Employee employee) {
        return service.save(employee);
    }


    @PutMapping(value = "/update_proj/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces =
            MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeDto> updateProjects(@Validated(AddProject.class) @RequestBody EmployeeDto dto, @PathVariable Long id) {
        return service.updateProjects(dto, id);
    }

    @GetMapping(value = "/{id}",  produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable Long id){
        return service.find(id);
    }

}
