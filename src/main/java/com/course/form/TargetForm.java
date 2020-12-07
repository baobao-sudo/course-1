package com.course.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description 新增课程目标
 * @ClassName TargetForm
 * @Author: baobao
 * @Date: Created in 16:11 2020/10/7
 */
@Data
public class TargetForm {

    @ApiModelProperty("教学计划ID")
    private Integer planId;

    @ApiModelProperty("序号")
    private Integer order;

    @ApiModelProperty("描述")
    private String description;

    @ApiModelProperty("目标名称")
    private String targetName;

    @ApiModelProperty("对应二级指标点")
    private Integer secondRequirementId;
}
