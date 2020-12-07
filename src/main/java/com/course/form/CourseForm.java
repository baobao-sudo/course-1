package com.course.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description 新增课程
 * @ClassName CourseForm
 * @Author: baobao
 * @Date: Created in 22:23 2020/12/2
 */
@Data
public class CourseForm {

    @ApiModelProperty("学分")
    private Integer credit;

    @ApiModelProperty("课程名")
    private String name;

}
