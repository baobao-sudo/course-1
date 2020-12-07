package com.course.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description 更新课程目标的表单
 * @ClassName TargetUpdateFrom
 * @Author: baobao
 * @Date: Created in 16:43 2020/10/7
 */
@Data
public class TargetUpdateFrom {

    @ApiModelProperty("目标ID")
    private Integer targetId;

    @ApiModelProperty("序号")
    private Integer order;

    @ApiModelProperty("描述")
    private String description;

    @ApiModelProperty("目标名称")
    private String targetName;
}
