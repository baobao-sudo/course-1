package com.course.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description 新增教学计划需要填写的
 * @ClassName PlanForm
 * @Author: baobao
 * @Date: Created in 15:29 2020/10/4
 */
@Data
public class PlanForm {

    @ApiModelProperty("专业课程ID")
    private Integer majorCourseId;

    @ApiModelProperty("学期")
    private Integer term;

    @ApiModelProperty("老师工号")
    private String teacherId;
}
