package com.course.controller;

import com.course.enums.ResultEnum;
import com.course.form.TargetForm;
import com.course.form.TargetUpdateFrom;
import com.course.service.TargetService;
import com.course.utils.ResultVOUtil;
import com.course.vo.ResultVO;
import io.swagger.annotations.Api;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


/**
 * @Description TODO
 * @ClassName TargetController
 * @Author: baobao
 * @Date: Created in 22:03 2020/10/14
 */
@RestController
@CrossOrigin
@RequestMapping("/api/target")
@Api(tags = "教学目标")
public class TargetController {

    @Autowired
    private TargetService targetService;

    @ApiOperation("新增教学目标")
    @PostMapping("/add")
    public ResultVO addTarget(@Valid TargetForm targetForm, BindingResult bindingResult) {
       if(bindingResult.hasErrors()){
           return ResultVOUtil.error(ResultEnum.BIND_ERROR);
       }
       return targetService.addTarget(targetForm);
    }

    @ApiOperation("编辑教学目标")
    @PostMapping("/edit")
    public ResultVO editTarget(@Valid TargetUpdateFrom updateFrom,BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return ResultVOUtil.error(ResultEnum.BIND_ERROR);
        }
        return targetService.editTarget(updateFrom);
    }

    @ApiOperation("删除教学目标")
    @GetMapping("/delete")
    public ResultVO deleteTarget(Integer targetId) {
      return targetService.deleteTarget(targetId);
    }

    @ApiOperation("获取当前课程所有课程目标")
    @GetMapping("/list")
    public ResultVO findAll(Integer planId) {
       return targetService.findAll(planId);
    }
}
