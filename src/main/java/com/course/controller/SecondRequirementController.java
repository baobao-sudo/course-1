package com.course.controller;


import com.course.enums.ResultEnum;
import com.course.form.SecondRequirementForm;
import com.course.form.SecondRequirementUpdateFrom;
import com.course.service.SecondRequirementService;
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
 * @Description 二级指标点
 * @ClassName SecondRequirementController
 * @Author: baobao
 * @Date: Created in 10:24 2020/10/11
 */
@RestController
@CrossOrigin
@RequestMapping("/api/secondRequirement")
@Api(tags = "二级指标点接口")
@Slf4j
public class SecondRequirementController {

    @Autowired
    private SecondRequirementService secondRequirementService;

    @ApiOperation("新增二级指标点")
    @PostMapping("/add")
    public ResultVO addSecondRequirement(@Valid SecondRequirementForm secondRequirementForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.info("参数注意必填项！");
            return ResultVOUtil.error(ResultEnum.PARAMETER_ERROR);
        }
        return secondRequirementService.addSecondRequirement(secondRequirementForm);
    }

    @ApiOperation("编辑二级指标点")
    @PostMapping("/edit")
    public ResultVO editSecondRequirement(@Valid SecondRequirementUpdateFrom secondRequirementUpdateFrom,BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.info("参数注意必填项！");
            return ResultVOUtil.error(ResultEnum.PARAMETER_ERROR);
        }
        return secondRequirementService.editSecondRequirement(secondRequirementUpdateFrom);
    }

    @ApiOperation("删除二级指标点")
    @GetMapping("/delete")
    public ResultVO deleteSecondRequirement(Integer secondRequirementId) {
        return secondRequirementService.deleteSecondRequirement(secondRequirementId);
    }

    @ApiOperation("找到相应一级下的所有二级")
    @GetMapping("/all")
    public ResultVO findAllSecondRequirement(Integer firstRequirementId) {
        return secondRequirementService.findAllSecondRequirement(firstRequirementId);
    }
}
