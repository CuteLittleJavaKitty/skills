package com.javakitty.skills.service;


import com.javakitty.skills.model.dto.ProjectDto;
import com.javakitty.skills.model.entity.Project;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface ProjectService {

    ResponseEntity<ProjectDto> save(ProjectDto projectDto);

    ResponseEntity<ProjectDto> update(ProjectDto projectDto, long id);

    void delete(long id);

    ResponseEntity<ProjectDto> find(long id);

    Project DtoToEntity(ProjectDto projectDto);

    ProjectDto EntityToDto(Project project);
}
