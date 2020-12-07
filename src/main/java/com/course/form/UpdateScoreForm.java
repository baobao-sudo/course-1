package com.course.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Description 更新的表单
 * @ClassName UpdateScoreForm
 * @Author: baobao
 * @Date: Created in 10:24 2020/11/26
 */
@Data
public class UpdateScoreForm {

    @ApiModelProperty("学号")
    private String stuNo;

    @ApiModelProperty("模块ID")
    private Integer moduleId;

    @ApiModelProperty("模块下所有的小题")
    private List<UpdateBranchScoreForm> updateBranchScoreForms;

    @ApiModelProperty("模块分数状态,0代表正常，1代表缺考")
    private Integer moduleScoreStatus;

}
