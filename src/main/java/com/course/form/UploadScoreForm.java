package com.course.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Description 上传成绩的表单
 * @ClassName UploadScoreForm
 * @Author: baobao
 * @Date: Created in 16:18 2020/11/25
 */
@Data
public class UploadScoreForm {

    @ApiModelProperty("学号")
    private String stuNo;

    @ApiModelProperty("模块ID")
    private Integer moduleId;

    @ApiModelProperty("模块下所有的小题")
    private List<BranchScoreForm> branchScoreForms;

    @ApiModelProperty("模块分数状态,0代表正常，1代表缺考")
    private Integer moduleScoreStatus;

}
