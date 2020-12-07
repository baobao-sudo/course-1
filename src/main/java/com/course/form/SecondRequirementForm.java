package com.course.form;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description TODO
 * @ClassName SecondRequirementForm
 * @Author: baobao
 * @Date: Created in 21:16 2020/10/9
 */
@Data
public class SecondRequirementForm {

    @ApiModelProperty("一级指标点")
    private Integer firstRequirementId;

    @ApiModelProperty("二级指标点序号")
    private Integer secondRequirementNo;

    @ApiModelProperty("详细解释")
    private String description;
}
