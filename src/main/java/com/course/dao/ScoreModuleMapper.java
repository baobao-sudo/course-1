package com.course.dao;

import com.course.model.ScoreModule;
import java.util.List;

public interface ScoreModuleMapper {
    int deleteByPrimaryKey(Integer moduleId);

    int insert(ScoreModule record);

    ScoreModule selectByPrimaryKey(Integer moduleId);

    List<ScoreModule> selectAll();

    int updateByPrimaryKey(ScoreModule record);

    /**
     * 通过教学计划获取所有配分模块
     * @param planId
     * @return
     */
    List<ScoreModule> selectByPlanId(Integer planId);
}