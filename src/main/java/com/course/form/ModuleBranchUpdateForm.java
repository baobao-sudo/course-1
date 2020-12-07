package com.course.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @Description 更新模块分支的时候
 * @ClassName ModuleBranchUpdateForm
 * @Author: baobao
 * @Date: Created in 20:13 2020/10/24
 */
@Data
public class ModuleBranchUpdateForm {

    @ApiModelProperty("模块小题ID")
    private Integer moduleBranchId;

    @ApiModelProperty("小题号")
    private String branchName;

    @ApiModelProperty("配分")
    private BigDecimal partition;

    @ApiModelProperty("二级指标点")
    private Integer secondRequirementId;

    @ApiModelProperty("显示次序")
    private Integer moduleBranchSequence;
}
