package com.course.controller;

import com.course.form.MatrixAttachedFrom;
import com.course.service.MajorCourseService;
import com.course.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @ClassName MajorCourseController
 * @Author: baobao
 * @Date: Created in 17:23 2020/12/6
 */
@RestController
@CrossOrigin
@RequestMapping("/api/majorCourse")
@Api(tags = "专业课程")
@Slf4j
public class MajorCourseController {

    @Autowired
    private MajorCourseService majorCourseService;


    @GetMapping("/find")
    @ApiOperation("获取当前专业年级的所有课程")
    ResultVO findAllMajorCourse(Integer grade){
        return majorCourseService.findAllMajorCourse(grade);
    }

}
