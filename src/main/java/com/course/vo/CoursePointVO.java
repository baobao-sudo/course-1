package com.course.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Description 课程对应的二级指标点
 * @ClassName CoursePointVO
 * @Author: baobao
 * @Date: Created in 17:48 2020/12/5
 */
@Data
public class CoursePointVO {

    private Integer secondRequirementId;

    private String secondPoint;

    private Double weight;
}
