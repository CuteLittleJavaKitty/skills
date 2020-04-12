package com.javakitty.skills.controller;

import com.javakitty.skills.model.dto.EmployeeDto;
import com.javakitty.skills.service.impl.EmployeeServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequestMapping(value = "/employee")
@Slf4j
public class EmployeeController {

    private EmployeeServiceImpl service;

    public EmployeeController(@Autowired EmployeeServiceImpl service) {
        this.service = service;
    }

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces =
            MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> add(@RequestBody EmployeeDto dto) {
        try {
            return service.add(dto);
        }
        catch(IllegalArgumentException ex) {
            log.error("Exception in getEmployee method, employeeDto is null");
            return ResponseEntity
                    .status(INTERNAL_SERVER_ERROR)
                    .body(INTERNAL_SERVER_ERROR.getReasonPhrase());
        }
    }


    @PutMapping(value = "/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces =
            MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> update(EmployeeDto dto, @PathVariable Long id) {
        try {
            return service.update(dto, id);
        }
        catch(IllegalArgumentException ex) {
            log.error("Exception in getEmployee method, employee id: {}, employeeDto: {}", id, dto.toString());
            return ResponseEntity
                    .status(INTERNAL_SERVER_ERROR)
                    .body(INTERNAL_SERVER_ERROR.getReasonPhrase());
        }
        catch (EntityNotFoundException ex) {
            log.warn("Employee with id {} not found", id);
            return ResponseEntity
                    .status(NOT_FOUND)
                    .body(NOT_FOUND.getReasonPhrase());
        }

    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getEmployee(@PathVariable Long id) {
        try {
            return service.find(id);
        }
        catch(IllegalArgumentException ex) {
            log.error("Exception in getEmployee method, employee id is null");
            return ResponseEntity
                    .status(INTERNAL_SERVER_ERROR)
                    .body(INTERNAL_SERVER_ERROR.getReasonPhrase());
        }
        catch (EntityNotFoundException ex) {
            log.warn("Employee with id {} not found", id);
            return ResponseEntity
                    .status(NOT_FOUND)
                    .body(NOT_FOUND.getReasonPhrase());
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        try {
            service.delete(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        catch(IllegalArgumentException ex) {
            log.error("Exception in delete method, employee id is null");
            return ResponseEntity
                    .status(INTERNAL_SERVER_ERROR)
                    .body(INTERNAL_SERVER_ERROR.getReasonPhrase());
        }
    }

}
