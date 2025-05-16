package com.example.try_gpt4_1.feature.project.service.impl;

import com.example.try_gpt4_1.common.entity.Project;
import com.example.try_gpt4_1.common.entity.ProjectRank;
import com.example.try_gpt4_1.feature.project.dto.ProjectRequestDto;
import com.example.try_gpt4_1.feature.project.repository.ProjectRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class ProjectServiceImplTest {
    @Mock
    ProjectRepository projectRepository;
    @InjectMocks
    ProjectServiceImpl projectService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Nested
    @DisplayName("プロジェクト更新: salesAmountによるprojectRank自動決定")
    class UpdateProjectRankAutoTest {
        @Test
        @DisplayName("salesAmount=12000ならSランク")
        void updateProjectRank_S() {
            ProjectRequestDto dto = new ProjectRequestDto();
            dto.setCustomerId(1L);
            dto.setDepartmentName("dep");
            dto.setProjectManager("mgr");
            dto.setProjectLeader("lead");
            dto.setSalesAmount(12000);
            dto.setStartDate(LocalDate.now());
            dto.setEndDate(LocalDate.now().plusDays(1));
            dto.setProjectType(null);
            Project existing = new Project();
            existing.setId(10L);
            when(projectRepository.findById(10L)).thenReturn(existing);

            projectService.update(10L, dto);

            ArgumentCaptor<Project> captor = ArgumentCaptor.forClass(Project.class);
            verify(projectRepository).update(captor.capture());
            assertThat(captor.getValue().getProjectRank()).isEqualTo(ProjectRank.S);
        }

        @Test
        @DisplayName("salesAmount=9000ならAランク")
        void updateProjectRank_A() {
            ProjectRequestDto dto = new ProjectRequestDto();
            dto.setCustomerId(1L);
            dto.setDepartmentName("dep");
            dto.setProjectManager("mgr");
            dto.setProjectLeader("lead");
            dto.setSalesAmount(9000);
            dto.setStartDate(LocalDate.now());
            dto.setEndDate(LocalDate.now().plusDays(1));
            dto.setProjectType(null);
            Project existing = new Project();
            existing.setId(11L);
            when(projectRepository.findById(11L)).thenReturn(existing);

            projectService.update(11L, dto);

            ArgumentCaptor<Project> captor = ArgumentCaptor.forClass(Project.class);
            verify(projectRepository).update(captor.capture());
            assertThat(captor.getValue().getProjectRank()).isEqualTo(ProjectRank.A);
        }

        @Test
        @DisplayName("salesAmount=6000ならBランク")
        void updateProjectRank_B() {
            ProjectRequestDto dto = new ProjectRequestDto();
            dto.setCustomerId(1L);
            dto.setDepartmentName("dep");
            dto.setProjectManager("mgr");
            dto.setProjectLeader("lead");
            dto.setSalesAmount(6000);
            dto.setStartDate(LocalDate.now());
            dto.setEndDate(LocalDate.now().plusDays(1));
            dto.setProjectType(null);
            Project existing = new Project();
            existing.setId(12L);
            when(projectRepository.findById(12L)).thenReturn(existing);

            projectService.update(12L, dto);

            ArgumentCaptor<Project> captor = ArgumentCaptor.forClass(Project.class);
            verify(projectRepository).update(captor.capture());
            assertThat(captor.getValue().getProjectRank()).isEqualTo(ProjectRank.B);
        }

        @Test
        @DisplayName("salesAmount=3000ならCランク")
        void updateProjectRank_C() {
            ProjectRequestDto dto = new ProjectRequestDto();
            dto.setCustomerId(1L);
            dto.setDepartmentName("dep");
            dto.setProjectManager("mgr");
            dto.setProjectLeader("lead");
            dto.setSalesAmount(3000);
            dto.setStartDate(LocalDate.now());
            dto.setEndDate(LocalDate.now().plusDays(1));
            dto.setProjectType(null);
            Project existing = new Project();
            existing.setId(13L);
            when(projectRepository.findById(13L)).thenReturn(existing);

            projectService.update(13L, dto);

            ArgumentCaptor<Project> captor = ArgumentCaptor.forClass(Project.class);
            verify(projectRepository).update(captor.capture());
            assertThat(captor.getValue().getProjectRank()).isEqualTo(ProjectRank.C);
        }

        @Test
        @DisplayName("salesAmount=1000ならDランク")
        void updateProjectRank_D() {
            ProjectRequestDto dto = new ProjectRequestDto();
            dto.setCustomerId(1L);
            dto.setDepartmentName("dep");
            dto.setProjectManager("mgr");
            dto.setProjectLeader("lead");
            dto.setSalesAmount(1000);
            dto.setStartDate(LocalDate.now());
            dto.setEndDate(LocalDate.now().plusDays(1));
            dto.setProjectType(null);
            Project existing = new Project();
            existing.setId(14L);
            when(projectRepository.findById(14L)).thenReturn(existing);

            projectService.update(14L, dto);

            ArgumentCaptor<Project> captor = ArgumentCaptor.forClass(Project.class);
            verify(projectRepository).update(captor.capture());
            assertThat(captor.getValue().getProjectRank()).isEqualTo(ProjectRank.D);
        }
    }
}
