package com.course.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description TODO
 * @ClassName TargetForm
 * @Author: baobao
 * @Date: Created in 16:11 2020/10/7
 */
@Data
public class TargetForm {

    @ApiModelProperty("专业课程编号")
    private Integer majorCourseId;

    @ApiModelProperty("序号")
    private Integer order;

    @ApiModelProperty("描述")
    private String description;

    @ApiModelProperty("目标名称")
    private String targetName;

    @ApiModelProperty("对应二级指标点")
    private Integer secondRequirementId;
}
