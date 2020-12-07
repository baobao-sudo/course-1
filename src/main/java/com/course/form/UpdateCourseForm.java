package com.course.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description 更新课程
 * @ClassName UpdateCourseForm
 * @Author: baobao
 * @Date: Created in 22:27 2020/12/2
 */
@Data
public class UpdateCourseForm {

    @ApiModelProperty("课程ID")
    private Integer courseId;

    @ApiModelProperty("学分")
    private Integer credit;

    @ApiModelProperty("课程名")
    private String name;
}
