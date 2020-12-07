package com.course.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description 用于更新学生用的form
 * @ClassName StudentUpdateForm
 * @Author: baobao
 * @Date: Created in 15:42 2020/10/17
 */
@Data
public class StudentUpdateForm {

    @ApiModelProperty("学号")
    private String stuNo;

    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("年级")
    private Integer grade;

    @ApiModelProperty("手机")
    private String phone;

    @ApiModelProperty("邮箱")
    private String email;
}
