package com.course.dao;

import com.course.dto.CourseDTO;
import com.course.dto.StudentDTO;
import com.course.model.Course;
import java.util.List;

public interface CourseMapper {
    int deleteByPrimaryKey(Integer courseId);

    int insert(Course record);

    Course selectByPrimaryKey(Integer courseId);

    List<Course> selectAll();

    int updateByPrimaryKey(Course record);

    /**
     * 通过名字查询课程
     * @param name
     * @return
     */
    Course selectByName(String name);

    /**
     * 导入excel中数据
     * @param record
     * @return
     */
    int upload(CourseDTO record);


}