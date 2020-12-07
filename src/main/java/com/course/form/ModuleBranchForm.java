package com.course.form;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * @Description 新增模块下分支小题
 * @ClassName ModuleBranchForm
 * @Author: baobao
 * @Date: Created in 20:12 2020/10/24
 */
public class ModuleBranchForm {

    @ApiModelProperty("题号")
    private String branchName;

    @ApiModelProperty("模块编号")
    private Integer moduleId;

    @ApiModelProperty("配分")
    private BigDecimal partition;

    @ApiModelProperty("二级指标点")
    private Integer secondRequirementId;

    @ApiModelProperty("显示顺序")
    private Integer moduleBranchSequence;
}
