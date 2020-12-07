package com.course.controller;

import com.alibaba.druid.sql.visitor.functions.Bin;
import com.course.enums.ResultEnum;
import com.course.form.LoginForm;
import com.course.service.UserService;
import com.course.utils.ResultVOUtil;
import com.course.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * @Description TODO
 * @ClassName AnonController
 * @Author: baobao
 * @Date: Created in 13:38 2020/10/10
 */
@RestController
@RequestMapping("/api/anon")
@Api(tags = "登录")
@CrossOrigin
@Slf4j
public class AnonController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    @ApiOperation("登录")
    public ResultVO login(@Valid LoginForm loginForm, HttpServletResponse response, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            log.info("参数注意必填项！");
            return ResultVOUtil.error(ResultEnum.PARAMETER_ERROR);
        }
        return userService.login(loginForm,response);
    }
    @GetMapping("/captcha")
    @ApiOperation("获取图片验证码")
    public ResultVO captcha(HttpServletRequest request, HttpServletResponse response){
        return userService.captcha(request,response);
    }
}
