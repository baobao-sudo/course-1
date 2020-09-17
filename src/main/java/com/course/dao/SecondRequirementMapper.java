package com.course.dao;

import com.course.model.SecondRequirement;
import java.util.List;

public interface SecondRequirementMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SecondRequirement record);

    SecondRequirement selectByPrimaryKey(Integer id);

    List<SecondRequirement> selectAll();

    int updateByPrimaryKey(SecondRequirement record);
}