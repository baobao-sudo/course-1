package com.course.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @Description 上传成绩表单
 * @ClassName BranchScoreForm
 * @Author: baobao
 * @Date: Created in 16:43 2020/11/19
 */

@Data
public class BranchScoreForm {

    @ApiModelProperty("模块分支ID")
    private Integer moduleBranchId;

    @ApiModelProperty("分数")
    private BigDecimal point;

}
