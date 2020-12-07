package com.course.controller;

import com.course.model.Score;
import com.course.service.ScoreService;
import com.course.utils.ResultVOUtil;
import com.course.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description 成绩计算接口
 * @ClassName ScoreController
 * @Author: baobao
 * @Date: Created in 1:08 2020/12/7
 */
@RestController
@CrossOrigin
@RequestMapping("/api/score")
@Api(tags = "成绩计算展示接口")
@Slf4j
public class ScoreController {

    @Autowired
    private ScoreService scoreService;


    @ApiOperation("计算成绩")
    @GetMapping("/planId")
    ResultVO calculate(Integer planId){
        return scoreService.calculate(planId);
    }


    @ApiOperation("查看该老师的所有学生成绩")
    @GetMapping("/all")
    ResultVO allStudentScore(Integer planId){
        return scoreService.allStudentScore(planId);
    }
}
