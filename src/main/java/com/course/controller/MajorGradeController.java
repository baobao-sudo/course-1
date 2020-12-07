package com.course.controller;

import com.course.enums.ResultEnum;
import com.course.form.MajorGradeForm;
import com.course.service.MajorGradeService;
import com.course.utils.ResultVOUtil;
import com.course.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @Description TODO
 * @ClassName MajorGradeController
 * @Author: baobao
 * @Date: Created in 21:09 2020/10/29
 */
@RestController
@CrossOrigin
@Slf4j
@RequestMapping("/api/grade")
@Api(tags = "年级变化")
public class MajorGradeController {

    @Autowired
    private MajorGradeService majorGradeService;

    @ApiOperation("增加年级")
    @PostMapping("/add")
    ResultVO addGrade(@Valid MajorGradeForm majorGradeForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResultVOUtil.error(ResultEnum.BIND_ERROR);
        }
        return majorGradeService.addGrade(majorGradeForm);
    }

    @ApiOperation("删除年级")
    @GetMapping("/delete")
    ResultVO deleteGrade(Integer grade){
        return majorGradeService.deleteGrade(grade);
  }
}
