package com.example.try_gpt4_1.feature.project.service;

import com.example.try_gpt4_1.feature.project.dto.ProjectRequestDto;
import com.example.try_gpt4_1.feature.project.dto.ProjectResponseDto;
import java.util.List;

public interface ProjectService {
    ProjectResponseDto findById(Long id);

    List<ProjectResponseDto> findAll(int page, int size);

    ProjectResponseDto create(ProjectRequestDto dto);

    ProjectResponseDto update(Long id, ProjectRequestDto dto);

    void delete(Long id);

    int count();
}
