package com.javakitty.skills.controller;

import com.javakitty.skills.model.dto.EmployeeDto;
import com.javakitty.skills.model.dto.ProjectDto;
import com.javakitty.skills.model.mark.AddEmployee;
import com.javakitty.skills.service.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

    private EmployeeServiceImpl service;

    public EmployeeController(@Autowired EmployeeServiceImpl service) {
        this.service = service;
    }

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces =
            MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeDto> create(@Validated(AddEmployee.class) @RequestBody EmployeeDto dto) {
        return service.save(dto);
    }


    @PutMapping(value = "/update_proj/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces =
            MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeDto> updateProjects(ProjectDto dto, @PathVariable Long id) {
        return service.updateProjects(dto, id);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable Long id) {
        return service.find(id);
    }

}
