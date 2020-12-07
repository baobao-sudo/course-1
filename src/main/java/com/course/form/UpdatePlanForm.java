package com.course.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description 修改教学计划的提交数据
 * @ClassName UpdatePlanForm
 * @Author: baobao
 * @Date: Created in 15:59 2020/10/7
 */
@Data
public class UpdatePlanForm {

    @ApiModelProperty("教学计划ID")
    private Integer planId;

    @ApiModelProperty("专业课程ID")
    private Integer majorCourseId;

    @ApiModelProperty("学期")
    private Integer term;

    @ApiModelProperty("老师工号")
    private String teacherId;
}
