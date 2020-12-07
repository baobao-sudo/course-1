package com.course.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @Description 展示课程矩阵的界面
 * @ClassName ListMatrixForm
 * @Author: baobao
 * @Date: Created in 17:31 2020/12/5
 */
@Data
public class ListMatrixForm {

    @NotNull(message = "年级非空")
    @ApiModelProperty("输入年级")
    private Integer grade;
}
