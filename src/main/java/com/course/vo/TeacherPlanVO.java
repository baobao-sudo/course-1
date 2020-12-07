package com.course.vo;

import lombok.Data;

import java.util.Date;

/**
 * @Description 展示老师教授课程
 * @ClassName TeacherPlanVO
 * @Author: baobao
 * @Date: Created in 9:05 2020/12/7
 */
@Data
public class TeacherPlanVO {

    private Integer grade;

    private String majorName;

    private String courseName;

    private Integer status;

    private Date computeTime;

}
