package com.course.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description TODO
 * @ClassName SecondRequirementUpdateFrom
 * @Author: baobao
 * @Date: Created in 21:16 2020/10/9
 */
@Data
public class SecondRequirementUpdateFrom {

    @ApiModelProperty("二级指标点ID")
    private Integer secondRequirementId;

    @ApiModelProperty("二级指标点序号")
    private Integer secondRequirementNo;

    @ApiModelProperty("二级指标标点详情")
    private String description;
}
