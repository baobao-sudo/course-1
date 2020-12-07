package com.course.dao;

import com.course.model.FirstRequirement;
import java.util.List;

public interface FirstRequirementMapper {
    int deleteByPrimaryKey(Integer firstRequirementId);

    int insert(FirstRequirement record);

    FirstRequirement selectByPrimaryKey(Integer firstRequirementId);

    List<FirstRequirement> selectAll();

    int updateByPrimaryKey(FirstRequirement record);

    /**
     * 通过一级指标点主键返回一级指标点序号
     * @param firstRequirementId 一级指标点主键
     * @return 返回的是一级指标点的序号
     */
    int getFirstRequirementNo(Integer firstRequirementId);

    /**
     * 获取专业的所有一级指标点
     * @param majorId
     * @return
     */
    List<FirstRequirement> selectByMajorId(Integer majorId);
}