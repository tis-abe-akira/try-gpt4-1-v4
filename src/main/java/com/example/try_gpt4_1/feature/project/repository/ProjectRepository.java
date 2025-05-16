package com.example.try_gpt4_1.feature.project.repository;

import com.example.try_gpt4_1.common.entity.Project;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface ProjectRepository {
    Project findById(@Param("id") Long id);

    List<Project> findAll();

    int insert(Project project);

    int update(Project project);

    int delete(@Param("id") Long id);

    int count();
}
