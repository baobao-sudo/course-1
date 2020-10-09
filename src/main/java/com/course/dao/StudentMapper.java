package com.course.dao;

import com.course.model.Student;
import java.util.List;

public interface StudentMapper {
    int deleteByPrimaryKey(Integer stuId);

    int insert(Student record);

    Student selectByPrimaryKey(Integer stuId);

    List<Student> selectAll();

    int updateByPrimaryKey(Student record);

    /**
     * 获取本专业学生的最大年级返回出来
     * @param majorId
     * @return
     */
    int selectMaxGrade(Integer majorId);
}