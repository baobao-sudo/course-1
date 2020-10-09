package com.course.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author: zty
 * @date 2019/10/12 下午7:52
 */
@Data
public class UserRegisterForm {


    @NotNull(message = "工号不能为空")
    @ApiModelProperty("工号")
    private String cardId;

    @NotNull(message = "姓名不能为空")
    @ApiModelProperty("姓名")
    private String name;

    @NotNull(message = "权限不能为空")
    @ApiModelProperty("权限")
    private Integer role;

}
