package com.course.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @Description 更新模块的
 * @ClassName ModuleUpdateForm
 * @Author: baobao
 * @Date: Created in 11:06 2020/10/24
 */
@Data
@NoArgsConstructor
public class ModuleUpdateForm {

    @ApiModelProperty("模块ID")
    private Integer moduleId;

    @ApiModelProperty("教学安排ID")
    private Integer planId;

    @ApiModelProperty("模块名称")
    private String moduleName;

    @ApiModelProperty("百分比")
    private BigDecimal percentage;
}
