package com.example.try_gpt4_1.feature.project.controller;

import com.example.try_gpt4_1.feature.project.dto.ProjectRequestDto;
import com.example.try_gpt4_1.feature.project.dto.ProjectResponseDto;
import com.example.try_gpt4_1.feature.project.service.ProjectService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @GetMapping("/{id}")
    public ProjectResponseDto getById(@PathVariable Long id) {
        return projectService.findById(id);
    }

    @GetMapping
    public List<ProjectResponseDto> getAll(@RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return projectService.findAll(page, size);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProjectResponseDto create(@RequestBody @Valid ProjectRequestDto dto) {
        return projectService.create(dto);
    }

    @PutMapping("/{id}")
    public ProjectResponseDto update(@PathVariable Long id, @RequestBody @Valid ProjectRequestDto dto) {
        return projectService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        projectService.delete(id);
    }
}
