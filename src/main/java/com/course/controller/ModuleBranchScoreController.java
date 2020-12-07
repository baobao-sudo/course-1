package com.course.controller;

import com.course.enums.ResultEnum;
import com.course.form.InitializeForm;
import com.course.form.UpdateScoreForm;
import com.course.form.UploadScoreForm;
import com.course.service.ModuleBranchScoreService;
import com.course.utils.ResultVOUtil;
import com.course.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @Description TODO
 * @ClassName ModuleBranchScoreController
 * @Author: baobao
 * @Date: Created in 8:49 2020/11/28
 */
@RestController
@RequestMapping("/api/branchScore")
@Api(tags = "录入分数")
@CrossOrigin
public class ModuleBranchScoreController {


    @Autowired
    private ModuleBranchScoreService moduleBranchScoreService;

    @ApiOperation("上传成绩")
    @PostMapping("/upload")
    ResultVO uploadScore(@Valid @RequestBody List<UploadScoreForm> uploadScoreForms, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResultVOUtil.error(ResultEnum.PARAMETER_ERROR);
        }
        return moduleBranchScoreService.uploadScore(uploadScoreForms);
    }


    @ApiOperation("初始化已有数据")
    @PostMapping("/initialize")
    ResultVO initialize(@Valid InitializeForm initializeForm,BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResultVOUtil.error(ResultEnum.PARAMETER_ERROR);
        }
        return moduleBranchScoreService.initialize(initializeForm);
    }

    @ApiOperation("更新成绩")
    @PostMapping("/update")
    ResultVO updateScore(@Valid @RequestBody List<UpdateScoreForm> updateScoreForms,BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResultVOUtil.error(ResultEnum.PARAMETER_ERROR);
        }
        return moduleBranchScoreService.updateScore(updateScoreForms);
    }
}
