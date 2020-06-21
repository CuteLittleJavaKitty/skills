package com.javakitty.skills.controller;

import com.javakitty.skills.model.dto.EmployeeDto;
import com.javakitty.skills.service.impl.EmployeeServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

    private final EmployeeServiceImpl service;

    @Autowired
    public EmployeeController(EmployeeServiceImpl service) {
        this.service = service;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces =
            MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeDto> addEmployee(@RequestBody EmployeeDto dto) {
        log.info("Received request for addEmployee. Creating employee: {}", dto.toString());
        return new ResponseEntity<>(service.create(dto), HttpStatus.OK);
    }


    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces =
            MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeDto> updateEmployee(@RequestBody EmployeeDto dto, @PathVariable("id") Long id) {
        log.info("Received request for updateEmployee. Employee id: {} \n {}", id, dto);
        return new ResponseEntity<>(service.update(dto, id), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable("id") Long id) {
        log.info("Received request for getEmployee. Employee id: {}", id);
        return new ResponseEntity<>(service.find(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EmployeeDto> deleteEmployee(@PathVariable("id") long id) {
        log.info("Received request for deleteEmployee. Employee id: {}", id);
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
