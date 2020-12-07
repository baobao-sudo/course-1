package com.course.controller;

import com.course.enums.ResultEnum;
import com.course.form.PlanForm;
import com.course.form.UpdatePlanForm;
import com.course.service.PlanService;
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
 * @Description 教学计划的控制器
 * @ClassName PlanController
 * @Author: baobao
 * @Date: Created in 15:47 2020/10/7
 */
@RestController
@Slf4j
@RequestMapping("/api/plan")
@Api(tags = "教学计划")
@CrossOrigin
public class PlanController {

    @Autowired
    private PlanService planService;

    @ApiOperation("新增申请")
    @PostMapping("/add")
    public ResultVO addPlan(@Valid PlanForm planForm , BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            log.info("参数注意必填项！");
            return ResultVOUtil.error(ResultEnum.PARAMETER_ERROR);
        }
        return planService.addPlan(planForm);
    }

    @ApiOperation("删除教学计划")
    @GetMapping("/delete")
    public ResultVO deletePlan(@RequestParam("planId") Integer planId){
        return planService.deletePlan(planId);
    }

    @ApiOperation("查询所有教学计划")
    @GetMapping("/allPlan")
    public ResultVO allPlan(Integer grade){
        return planService.allPlan(grade);
    }

    @ApiOperation("编辑教学计划")
    @PostMapping("/edit")
    public ResultVO editPlan(@Valid UpdatePlanForm updatePlanForm ,BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            log.info("参数注意必填项！");
            return ResultVOUtil.error(ResultEnum.PARAMETER_ERROR);
        }
        return planService.editPlan(updatePlanForm);
    }

    @ApiOperation("获取老师所有的教授的课程")
    @GetMapping("/teacher")
    ResultVO teacherPlan(){
        return planService.teacherPlan();
    }
}
