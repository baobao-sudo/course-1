package com.course.dao;

import com.course.model.ScoreModule;
import java.util.List;

public interface ScoreModuleMapper {
    int deleteByPrimaryKey(Integer moduleId);

    int insert(ScoreModule record);

    ScoreModule selectByPrimaryKey(Integer moduleId);

    List<ScoreModule> selectAll();

    int updateByPrimaryKey(ScoreModule record);
}