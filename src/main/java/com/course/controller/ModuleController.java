package com.course.controller;

import com.course.enums.ResultEnum;
import com.course.form.ModuleForm;
import com.course.form.ModuleUpdateForm;
import com.course.service.ModuleService;
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
import java.util.List;

/**
 * @Description TODO
 * @ClassName ModuleController
 * @Author: baobao
 * @Date: Created in 13:03 2020/10/24
 */
@RestController
@CrossOrigin
@RequestMapping("/api/module")
@Slf4j
@Api(tags = "模块接口")
public class ModuleController {

    @Autowired
    private ModuleService moduleService;

    @PostMapping("/add")
    @ApiOperation("新增模块")
    ResultVO addModule(@Valid ModuleForm moduleForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.info("请注意必填项！");
            ResultVOUtil.error(ResultEnum.PARAMETER_ERROR);
        }
        return moduleService.addModule(moduleForm);
    }


    @GetMapping("/delete")
    @ApiOperation("删除")
    ResultVO deleteModule(Integer moduleId){
        return moduleService.deleteModule(moduleId);
    }


    @GetMapping("/edit")
    @ApiOperation("编辑模块")
    ResultVO editModule(@Valid ModuleUpdateForm moduleUpdateForm,BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.info("请注意必填项！");
            ResultVOUtil.error(ResultEnum.PARAMETER_ERROR);
        }
        return moduleService.editModule(moduleUpdateForm);
    }

    @GetMapping("/all")
    @ApiOperation("返回所有模块")
    ResultVO allModule(Integer planId){
        return moduleService.allModule(planId);
    }

   @PostMapping("/editList")
   @ApiOperation("批量更新")
    ResultVO updateModules(@Valid @RequestBody List<ModuleUpdateForm> moduleUpdateForms,BindingResult bindingResult){
       if(bindingResult.hasErrors()){
           log.info("请注意必填项！");
           ResultVOUtil.error(ResultEnum.PARAMETER_ERROR);
       }
       return moduleService.updateModules(moduleUpdateForms);
    }
}
