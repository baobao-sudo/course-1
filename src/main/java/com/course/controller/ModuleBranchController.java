package com.course.controller;

import com.course.enums.ResultEnum;
import com.course.form.ModuleBranchForm;
import com.course.form.ModuleBranchUpdateForm;
import com.course.service.ModuleBranchService;
import com.course.utils.ResultVOUtil;
import com.course.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @Description 模块小题号
 * @ClassName ModuleBranchController
 * @Author: baobao
 * @Date: Created in 14:53 2020/11/19
 */
@RestController
@Api(tags = "模块小题分支")
@RequestMapping("/api/moduleBranch")
@CrossOrigin
@Slf4j
public class ModuleBranchController {

    @Autowired
    private ModuleBranchService moduleBranchService;

    @PostMapping("/add")
    @ApiOperation("新增题目")
    ResultVO addModuleBranch(@Valid ModuleBranchForm moduleBranchForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResultVOUtil.error(ResultEnum.PARAMETER_ERROR);
        }
        return moduleBranchService.addModuleBranch(moduleBranchForm);
    }

    @ApiOperation("删除小题模块")
    @GetMapping("/delete")
    ResultVO deleteModuleBranch(Integer moduleBranchId) {
        return moduleBranchService.deleteModuleBranch(moduleBranchId);
    }

    @ApiOperation("更新小题")
    @PostMapping("/update")
    ResultVO editModuleBranch(@Valid ModuleBranchUpdateForm moduleBranchUpdateForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResultVOUtil.error(ResultEnum.PARAMETER_ERROR);
        }
        return moduleBranchService.editModuleBranch(moduleBranchUpdateForm);
    }

    @ApiOperation("获取所有小题")
    @GetMapping("/all")
    ResultVO allModuleBranch(Integer moduleId) {
        return moduleBranchService.allModuleBranch(moduleId);
    }
}
