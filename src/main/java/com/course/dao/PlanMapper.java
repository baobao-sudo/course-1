package com.course.dao;

import com.course.model.Plan;
import java.util.List;

public interface PlanMapper {
    int deleteByPrimaryKey(Integer planId);

    int insert(Plan record);

    Plan selectByPrimaryKey(Integer planId);

    List<Plan> selectAll();

    int updateByPrimaryKey(Plan record);
}