package com.course.vo;

import lombok.Data;

/**
 * @Description 展示所有教学计划
 * @ClassName PlanVO
 * @Author: baobao
 * @Date: Created in 10:27 2020/10/9
 */
@Data
public class PlanVO {

    private Integer planId;

    private String majorCourseName;

    private Integer term;

    private Integer teacherId;

    private Integer status;
}
