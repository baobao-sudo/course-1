package com.course.dao;

import com.course.model.SecondRequirement;
import com.course.vo.CoursePointVO;

import java.util.List;

public interface SecondRequirementMapper {
    int deleteByPrimaryKey(Integer secondRequirementId);

    int insert(SecondRequirement record);

    SecondRequirement selectByPrimaryKey(Integer secondRequirementId);

    List<SecondRequirement> selectAll();

    int updateByPrimaryKey(SecondRequirement record);

    /**
     * 获取一级指标点所有的二级指标点
     * @param firstRequirementId 一级指标点ID
     * @return
     */
    List<SecondRequirement> selectByFirstRequirement(Integer firstRequirementId);

    /**
     * 获取二级指标点的序号
     * @param secondRequirement
     * @return
     */
    String selectSecondRequirementSequence(Integer secondRequirement);


    /**
     * 通过矩阵获取二级指标点
     * @param majorId
     * @param firstRequirementNo
     * @param secondRequirementNo
     * @return
     */
    SecondRequirement selectByMajorCourseId(Integer majorId,Integer firstRequirementNo,Integer secondRequirementNo);
}