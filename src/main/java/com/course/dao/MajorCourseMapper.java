package com.course.dao;

import com.course.model.MajorCourse;
import java.util.List;

public interface MajorCourseMapper {
    int deleteByPrimaryKey(Integer majorCourseId);

    int insert(MajorCourse record);

    MajorCourse selectByPrimaryKey(Integer majorCourseId);

    List<MajorCourse> selectAll();

    int updateByPrimaryKey(MajorCourse record);


}