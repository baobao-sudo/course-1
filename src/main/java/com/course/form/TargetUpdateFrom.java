package com.course.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description TODO
 * @ClassName TargetUpdateFrom
 * @Author: baobao
 * @Date: Created in 16:43 2020/10/7
 */
@Data
public class TargetUpdateFrom {

    @ApiModelProperty("目标ID")
    private Integer targetId;

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
