package com.example.try_gpt4_1.feature.project.service.impl;

import com.example.try_gpt4_1.common.entity.Project;
import com.example.try_gpt4_1.feature.project.dto.ProjectRequestDto;
import com.example.try_gpt4_1.feature.project.dto.ProjectResponseDto;
import com.example.try_gpt4_1.feature.project.repository.ProjectRepository;
import com.example.try_gpt4_1.feature.project.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public ProjectResponseDto findById(Long id) {
        Project project = projectRepository.findById(id);
        if (project == null)
            throw new IllegalArgumentException("Project not found");
        return toResponseDto(project);
    }

    @Override
    public List<ProjectResponseDto> findAll(int page, int size) {
        List<Project> all = projectRepository.findAll();
        return all.stream()
                .skip((long) page * size)
                .limit(size)
                .map(this::toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public ProjectResponseDto create(ProjectRequestDto dto) {
        Project project = new Project();
        project.setCustomerId(dto.getCustomerId());
        project.setDepartmentName(dto.getDepartmentName());
        project.setProjectManager(dto.getProjectManager());
        project.setProjectLeader(dto.getProjectLeader());
        project.setProjectRank(dto.getProjectRank());
        project.setSalesAmount(dto.getSalesAmount());
        project.setStartDate(dto.getStartDate());
        project.setEndDate(dto.getEndDate());
        project.setProjectType(dto.getProjectType());
        projectRepository.insert(project);
        return toResponseDto(project);
    }

    @Override
    @Transactional
    public ProjectResponseDto update(Long id, ProjectRequestDto dto) {
        Project project = projectRepository.findById(id);
        if (project == null)
            throw new IllegalArgumentException("Project not found");
        project.setCustomerId(dto.getCustomerId());
        project.setDepartmentName(dto.getDepartmentName());
        project.setProjectManager(dto.getProjectManager());
        project.setProjectLeader(dto.getProjectLeader());
        project.setProjectRank(dto.getProjectRank());
        project.setSalesAmount(dto.getSalesAmount());
        project.setStartDate(dto.getStartDate());
        project.setEndDate(dto.getEndDate());
        project.setProjectType(dto.getProjectType());
        projectRepository.update(project);
        return toResponseDto(project);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Project project = projectRepository.findById(id);
        if (project == null)
            throw new IllegalArgumentException("Project not found");
        projectRepository.delete(id);
    }

    @Override
    public int count() {
        return projectRepository.count();
    }

    private ProjectResponseDto toResponseDto(Project project) {
        ProjectResponseDto dto = new ProjectResponseDto();
        dto.setId(project.getId());
        dto.setCustomerId(project.getCustomerId());
        dto.setDepartmentName(project.getDepartmentName());
        dto.setProjectManager(project.getProjectManager());
        dto.setProjectLeader(project.getProjectLeader());
        dto.setProjectRank(project.getProjectRank());
        dto.setSalesAmount(project.getSalesAmount());
        dto.setStartDate(project.getStartDate());
        dto.setEndDate(project.getEndDate());
        dto.setProjectType(project.getProjectType());
        return dto;
    }
}
