package com.course.controller;

import com.course.enums.ResultEnum;
import com.course.form.ListMatrixForm;
import com.course.form.MatrixForm;
import com.course.service.MatrixService;
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
 * @Description 矩阵课程的
 * @ClassName MatrixController
 * @Author: baobao
 * @Date: Created in 14:13 2020/12/3
 */
@RestController
@RequestMapping("/api/matrix")
@CrossOrigin
@Api(tags = "课程矩阵")
@Slf4j
public class MatrixController {

    @Autowired
    private MatrixService matrixService;

    @PostMapping("/upload")
    @ApiOperation("通过文件上传课程矩阵")
    ResultVO upload(@Valid  MatrixForm matrixForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResultVOUtil.error(ResultEnum.PARAMETER_ERROR);
        }
        return matrixService.upload(matrixForm);
    }

    @ApiOperation("展示所有的矩阵约束")
    @PostMapping("/list")
    ResultVO list(@Valid ListMatrixForm listMatrixForm,BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResultVOUtil.error(ResultEnum.PARAMETER_ERROR);
        }
        return matrixService.list(listMatrixForm);
    }


    @ApiOperation("获取所有一级二级指标点数量展示出来")
    @GetMapping("/getHead")
    ResultVO getRequirementByMajor(){
        return matrixService.getRequirementByMajor();
    }
}
