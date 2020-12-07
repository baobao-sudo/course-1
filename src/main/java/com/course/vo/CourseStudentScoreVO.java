package com.course.vo;

import lombok.Data;

import java.util.List;

/**
 * @Description 返回课程整体的成绩数据
 * @ClassName CourseStudentScoreVO
 * @Author: baobao
 * @Date: Created in 0:40 2020/12/7
 */
@Data
public class CourseStudentScoreVO {

    private Integer majorCourseId;

    private String courseName;

    List<StudentScoreVO> studentScoreVOS;
}
