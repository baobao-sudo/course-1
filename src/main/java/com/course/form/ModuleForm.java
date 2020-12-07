package com.course.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @Description 插入模块的
 * @ClassName ModuleForm
 * @Author: baobao
 * @Date: Created in 10:58 2020/10/24
 */
@Data
@NoArgsConstructor
public class ModuleForm {

    @ApiModelProperty("教学安排ID")
    private Integer planId;

    @ApiModelProperty("模块名称")
    private String moduleName;

    @ApiModelProperty("百分比")
    private BigDecimal percentage;
}
