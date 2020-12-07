package com.course.dao;

import com.course.model.Plan;
import java.util.List;

public interface PlanMapper {
    int deleteByPrimaryKey(Integer planId);

    int insert(Plan record);

    Plan selectByPrimaryKey(Integer planId);

    List<Plan> selectAll();

    int updateByPrimaryKey(Plan record);

    /**
     * 查询一个已经分配老师的教学计划
     * @param majorId 专业Id
     * @return 返回一个专业所有的教学计划
     */
    List<Plan> selectAllByMajor(Integer majorId);

    /**
     * 通过专业课程进行查询
     * @param majorCourseId
     * @return
     */
    Plan selectByMajorCourseId(Integer majorCourseId);

    /**
     * 查询老师要教授的所有的课程
     * @param cardId
     * @return
     */
    List<Plan> selectByTeacher(String  cardId);
}