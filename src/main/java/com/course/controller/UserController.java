package com.course.controller;

import com.course.accessctro.RoleContro;
import com.course.dto.PhotoUploadDTO;
import com.course.enums.ResultEnum;
import com.course.enums.RoleEnum;
import com.course.form.LoginForm;
import com.course.form.UserRegisterForm;
import com.course.form.UserUpdatePwForm;
import com.course.model.User;
import com.course.service.UserService;
import com.course.utils.ResultVOUtil;
import com.course.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * @author zty200329
 * @date 2020/7/15 9:38
 */
@RestController
@Slf4j
@RequestMapping("/api/user")
@Api(tags = "用户接口")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/insertUser")
    @ApiOperation("注册用户")
    @RoleContro(role = RoleEnum.SUPPER_ADMIN)
    public ResultVO insertUser(@Valid UserRegisterForm registerForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.info("参数注意必填项！");
            return ResultVOUtil.error(ResultEnum.PARAMETER_ERROR);
        }
        return userService.userRegister(registerForm);
    }

    @PostMapping("/updatePw")
    @ApiOperation("更新密码")
    public ResultVO updatePassword(@Valid UserUpdatePwForm userUpdatePwForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.info("参数注意必填项！");
            return ResultVOUtil.error(ResultEnum.PARAMETER_ERROR);
        }
        return userService.updateUserPw(userUpdatePwForm);
    }

    @PostMapping("/uploadPhoto")
    @ApiOperation("上传头像")
    public ResultVO uploadPhoto(MultipartFile file) {
        return userService.uploadPhoto(file);
    }

    @GetMapping("/teacher")
    @ApiOperation("返回所有老师")
    ResultVO allTeacher() {
        return userService.allTeacher();
    }
}
