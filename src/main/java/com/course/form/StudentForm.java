package com.course.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description 新增学生的form
 * @ClassName StudentForm
 * @Author: baobao
 * @Date: Created in 11:22 2020/10/17
 */
@Data
public class StudentForm {

    @ApiModelProperty("学号")
    private String stuNo;

    @ApiModelProperty("年级")
    private Integer grade;

    @ApiModelProperty("真实姓名")
    private String name;

    @ApiModelProperty("手机号")
    private String phone;

    @ApiModelProperty("邮箱")
    private String email;

}
