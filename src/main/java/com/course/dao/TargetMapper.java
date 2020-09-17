package com.course.dao;

import com.course.model.Target;
import java.util.List;

public interface TargetMapper {
    int deleteByPrimaryKey(Integer targetId);

    int insert(Target record);

    Target selectByPrimaryKey(Integer targetId);

    List<Target> selectAll();

    int updateByPrimaryKey(Target record);
}