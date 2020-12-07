package com.course.controller;

import com.course.enums.ResultEnum;
import com.course.form.FirstRequirementForm;
import com.course.form.FirstRequirementUpdateForm;
import com.course.service.FirstRequirementService;
import com.course.utils.ResultVOUtil;
import com.course.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


/**
 * @Description
 * @ClassName FirstRequirementController
 * @Author: baobao
 * @Date: Created in 20:16 2020/10/10
 */
@RestController
@CrossOrigin
@RequestMapping("/api/firstRequirement")
@Api(tags = "一级指标")
@Slf4j
public class FirstRequirementController {

    @Autowired
    private FirstRequirementService firstRequirementService;

    @PostMapping(value = "/inset")
    @ApiOperation("插入一个一级指标点")
    public ResultVO insertFirstRequirement(@Valid @RequestBody FirstRequirementForm firstRequirementForm, BindingResult bindingResult) {
       if(bindingResult.hasErrors()){
           log.info("请注意必填项！");
           ResultVOUtil.error(ResultEnum.PARAMETER_ERROR);
       }
       return firstRequirementService.insertFirstRequirement(firstRequirementForm);
    }

    @PostMapping("/update")
    @ApiOperation("更新一级指标点")
    public ResultVO updateFirstRequirement(@Valid @RequestBody FirstRequirementUpdateForm firstRequirementUpdateForm,BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            log.info("请注意必填项！");
            ResultVOUtil.error(ResultEnum.PARAMETER_ERROR);
        }
        return firstRequirementService.updateFirstRequirement(firstRequirementUpdateForm);
    }

    @GetMapping("/all")
    @ApiOperation("获取所有一级指标点")
    public ResultVO findAllFirstRequirement() {
        return firstRequirementService.findAllFirstRequirement();
    }

    @GetMapping("/delete")
    @ApiOperation("删除一级指标点")
    public ResultVO deleteFirstRequirement(@ApiParam("一级指标点") Integer firstRequirementId) {
        return firstRequirementService.deleteFirstRequirement(firstRequirementId);
    }
}
