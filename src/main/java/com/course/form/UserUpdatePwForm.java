package com.course.form;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @Description 修改密码的表单
 * @ClassName UserUpdatePwForm
 * @Author: baobao
 * @Date: Created in 11:34 2020/10/7
 */
@Data
public class UserUpdatePwForm {

    @NotNull(message = "工号不能为空")
    @ApiModelProperty("用户工号")
    private String cardId;

    @NotNull(message = "旧密码不能为空")
    @ApiModelProperty("旧密码")
    private String oldPassword;

    @NotNull(message = "新密码不能为空")
    @ApiModelProperty("新密码")
    private String newPassword;

}
