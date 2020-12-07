package com.course.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @Description 更新小题分数
 * @ClassName UpdateBranchScoreForm
 * @Author: baobao
 * @Date: Created in 10:35 2020/11/26
 */
@Data
public class UpdateBranchScoreForm {

    @ApiModelProperty("分数ID")
    private Integer moduleBranchScoreId;

    @ApiModelProperty("分数")
    private BigDecimal point;

}
