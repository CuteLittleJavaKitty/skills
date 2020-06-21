package com.javakitty.skills.service.impl;

import com.javakitty.skills.dao.ProjectRepository;
import com.javakitty.skills.model.dto.ProjectDto;
import com.javakitty.skills.model.entity.Project;
import com.javakitty.skills.service.ProjectService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.persistence.EntityNotFoundException;
import java.util.Objects;
import java.util.Optional;

public class ProjectServiceImpl implements ProjectService {

    private ProjectRepository projectRepository;
    private ModelMapper modelMapper;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository, ModelMapper modelMapper){
        this.modelMapper = modelMapper;
        this.projectRepository = projectRepository;
    }


    @Override
    public ResponseEntity<ProjectDto> save(ProjectDto projectDto) {
        Project project = DtoToEntity(projectDto);
        return new ResponseEntity<>(EntityToDto(projectRepository.save(project)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ProjectDto> update(ProjectDto projectDto, long id) {
        Project project = get(id);
        modelMapper.map(projectDto, project);

        return new ResponseEntity<>(EntityToDto(projectRepository.save(project)), HttpStatus.OK);
    }

    @Override
    public void delete(long id) {
        projectRepository.deleteById(id);
    }

    @Override
    public ResponseEntity<ProjectDto> find(long id) {
        Project project = get(id);

        return new ResponseEntity<>(EntityToDto(project), HttpStatus.OK);
    }

    @Override
    public Project DtoToEntity(ProjectDto projectDto) {
        return Objects.isNull(projectDto) ? null : modelMapper.map(projectDto, Project.class);
    }

    @Override
    public ProjectDto EntityToDto(Project project) {
        return Objects.isNull(project) ? null : modelMapper.map(project, ProjectDto.class);
    }

    private Project get(long id) {
        Optional<Project> findProject = projectRepository.findById(id);
        return findProject.orElseThrow(EntityNotFoundException::new);
    }



}
