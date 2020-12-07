package com.course.vo;

import lombok.Data;

/**
 * @Description 展示教学计划的时候，就展示所有的专业课程，然后返回是否有老师
 * @ClassName MajorCourseVO
 * @Author: baobao
 * @Date: Created in 17:52 2020/12/6
 */
@Data
public class MajorCourseVO {

    private Integer majorCourseId;

    private String  courseName;

    /**
     * 这个用来显示是否给这个课程分配
     */
    private Boolean majorCourseStatus;

    /**
     * 记录已经分配的
     */
    private PlanVO planVO;

}
