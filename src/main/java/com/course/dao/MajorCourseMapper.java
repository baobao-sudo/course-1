package com.course.dao;

import com.course.model.MajorCourse;
import com.course.dto.MajorCourseDTO;

import java.util.List;

public interface MajorCourseMapper {
    int deleteByPrimaryKey(Integer majorCourseId);

    int insert(MajorCourse record);

    MajorCourse selectByPrimaryKey(Integer majorCourseId);

    List<MajorCourse> selectAll();

    int updateByPrimaryKey(MajorCourse record);

    /**
     * 查询专业课程
     * @param majorId
     * @param grade
     * @return
     */
    List<MajorCourseDTO> selectMajorCourse(Integer majorId, Integer grade);

    /**
     * 根据专业课程获取课程名
     * @param majorCourseId
     * @return
     */
    String selectCourseName(Integer majorCourseId);

    /**
     * 获取当前专业年级的所有专业课程
     * @param majorId
     * @param grade
     * @return
     */
    List<MajorCourse> selectAllMajorCourse(Integer majorId, Integer grade);

}