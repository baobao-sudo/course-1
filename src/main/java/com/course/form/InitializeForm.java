package com.course.form;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description 输入成绩的初始化界面界面传值
 * @ClassName InitializeForm
 * @Author: baobao
 * @Date: Created in 15:20 2020/11/26
 */
@Data
public class InitializeForm {

    @ApiModelProperty("年级")
    private Integer grade;

    @ApiModelProperty("模块ID")
    private Integer moduleId;

}
