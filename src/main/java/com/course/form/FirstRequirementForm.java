package com.course.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description TODO
 * @ClassName FirstRequirementForm
 * @Author: baobao
 * @Date: Created in 16:40 2020/10/9
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FirstRequirementForm {
    @ApiModelProperty("一级指标点详情")
    private String detail;

    @ApiModelProperty("详细描述")
    private String description;

    @ApiModelProperty("一级指标点的序号")
    private Integer firstRequirementNo;
}
