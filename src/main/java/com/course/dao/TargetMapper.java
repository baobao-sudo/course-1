package com.course.dao;

import com.course.model.Target;
import java.util.List;

public interface TargetMapper {
    int deleteByPrimaryKey(Integer targetId);

    int insert(Target record);

    Target selectByPrimaryKey(Integer targetId);

    List<Target> selectAll();

    int updateByPrimaryKey(Target record);

    /**
     * 根据教学计划获取教学目标
     * @param planId
     * @return
     */
    List<Target> selectByPlanId(Integer planId);
}