package com.course.dao;

import com.course.model.FirstRequirement;
import java.util.List;

public interface FirstRequirementMapper {
    int deleteByPrimaryKey(Integer firstRequirementId);

    int insert(FirstRequirement record);

    FirstRequirement selectByPrimaryKey(Integer firstRequirementId);

    List<FirstRequirement> selectAll();

    int updateByPrimaryKey(FirstRequirement record);
}